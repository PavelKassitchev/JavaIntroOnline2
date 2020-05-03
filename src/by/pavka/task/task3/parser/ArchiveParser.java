package by.pavka.task.task3.parser;

import by.pavka.task.task3.person.Student;
import by.pavka.task.task3.person.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

            Element student = doc.createElement("student");
            studentFile.appendChild(student);
            student.setAttribute("id", String.valueOf(entry.getKey().getId()));

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(entry.getKey().getName()));
            student.appendChild(name);

            Element address = doc.createElement("address");
            address.appendChild(doc.createTextNode(entry.getKey().getAddress()));
            student.appendChild(address);

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
        }

        TransformerFactory transformerFactory =TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult result = new StreamResult(file);

        transformer.transform(domSource, result);
    }
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        map.put(new Student("Petrov", "Minsk"), 4.4);
        map.put(new Student("Ivanov", "Moscow"), 3.9);
        try {
            writeFolder(map, null, 2);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
