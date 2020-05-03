package by.pavka.task.task3.parser;

import by.pavka.task.task3.person.Student;
import by.pavka.task.task3.person.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ArchiveParser {

    public static void writeFolder(Map<Student, Double> map, File file, int count) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = documentBuilder.newDocument();
        Element rootElement = doc.createElement("folder");
        doc.appendChild(rootElement);

        Element counter = doc.createElement("counter");
        rootElement.appendChild(counter);
        counter.setAttribute("number", String.valueOf(count));

        for (Map.Entry<Student, Double> entry: map.entrySet()){
            Element studentFile = doc.createElement("file");
            rootElement.appendChild(studentFile);

            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(String.valueOf(entry.getKey().getId())));
            studentFile.appendChild(id);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(entry.getKey().getName()));
            studentFile.appendChild(name);

            Element address = doc.createElement("address");
            address.appendChild(doc.createTextNode(entry.getKey().getAddress()));
            studentFile.appendChild(address);

            Element mark = doc.createElement("av_mark");
            mark.appendChild(doc.createTextNode(entry.getValue().toString()));
            studentFile.appendChild(mark);
        }

        TransformerFactory transformerFactory =TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(file);

        transformer.transform(domSource, result);
    }

    public static void writeAuth(Set<User> users, File file) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = documentBuilder.newDocument();
        Element rootElement = doc.createElement("users");
        doc.appendChild(rootElement);

        for(User u: users) {
            Element user = doc.createElement("user");
            rootElement.appendChild(user);
            user.setAttribute("login", u.getLogin());
            user.setAttribute("pass_hash", String.valueOf(u.getPassHash()));
            user.setAttribute("permission", String.valueOf(u.canModify()));
        }

        TransformerFactory transformerFactory =TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(file);

        transformer.transform(domSource, result);
    }

    public static Set<User> loadUsers(File file) throws ParserConfigurationException, IOException, SAXException {

        Set<User> userSet = new ConcurrentSkipListSet<User>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Node rootElement = document.getDocumentElement();
        NodeList users = rootElement.getChildNodes();

        for(int i = 0; i < users.getLength(); i++) {
            Node u = users.item(i);
            userSet.add(getUser(u));
        }
        return userSet;
    }

    public static int getCount(File file) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Node rootElement = document.getDocumentElement();
        Element count = (Element)rootElement.getFirstChild();
        return Integer.parseInt(count.getAttribute("number"));
    }

    public static Map<Student, Double> loadStudents(File file) throws ParserConfigurationException, IOException, SAXException {

        Map<Student, Double> map = new ConcurrentHashMap<Student, Double>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Node rootElement = document.getDocumentElement();
        NodeList files = rootElement.getChildNodes();

        //TODO

        return map;
    }

    private static User getUser(Node node) {
        if(node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element)node;
            String login = element.getAttribute("login");
            String passHashString = element.getAttribute("pass_hash");
            String permissionString = element.getAttribute("permission");
            int passHash = Integer.parseInt(passHashString);
            boolean permission = Boolean.parseBoolean(permissionString);
            return new User(login, passHash, permission);
        }
        return null;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Set<User> users = loadUsers(new File("auth.xml"));
        for(User u: users) {
            System.out.println(u);
        }
    }
}
