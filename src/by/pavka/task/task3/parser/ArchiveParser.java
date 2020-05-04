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

    //The method saves the map with students' files in xml
    public static void writeFolder(Map<Student, Double> map, File file, int count) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = documentBuilder.newDocument();
        Element rootElement = doc.createElement("folder");
        doc.appendChild(rootElement);
        rootElement.setAttribute("counter", String.valueOf(count));

        for (Map.Entry<Student, Double> entry: map.entrySet()){
            Element studentFile = doc.createElement("file");
            rootElement.appendChild(studentFile);
            studentFile.setAttribute("id", String.valueOf(entry.getKey().getId()));
            studentFile.setAttribute("name", entry.getKey().getName());
            studentFile.setAttribute("address", entry.getKey().getAddress());
            studentFile.setAttribute("average_mark", entry.getValue().toString());

        }

        TransformerFactory transformerFactory =TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(file);

        transformer.transform(domSource, result);
    }

    //This method saves authentication set in xml
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

    //The method restores set of users from xml
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

    //The method restores static counter from xml
    public static int getCount(File file) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Element rootElement = document.getDocumentElement();

        return Integer.parseInt(rootElement.getAttribute("counter"));
    }

    //This method restores map of students' files from xml
    public static Map<Student, Double> loadStudents(File file) throws ParserConfigurationException, IOException, SAXException {

        Map<Student, Double> map = new ConcurrentHashMap<Student, Double>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Element rootElement = document.getDocumentElement();
        NodeList files = rootElement.getChildNodes();
        for(int i = 0; i < files.getLength(); i++) {
            Element studentFile = (Element)files.item(i);
            int id = Integer. parseInt(studentFile.getAttribute("id"));
            String name = studentFile.getAttribute("name");
            String address = studentFile.getAttribute("address");
            double mark = Double.parseDouble(studentFile.getAttribute("average_mark"));
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAddress(address);
            map.put(student, mark);
        }

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

}
