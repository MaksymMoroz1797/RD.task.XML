package exemple;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class PersonParser {
    private String path;

    public PersonParser(String path) {
        this.path = path;
    }

    public Collection<Person> getRangedPersons(double cashMin) {
        File fileXML = new File(this.path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(fileXML);
        }
        catch (IOException | SAXException e) { return null; }
        Element rootElement = doc.getDocumentElement();
        Element notebook =  (Element) rootElement.getElementsByTagName("notebook").item(0);
        NodeList personElementList = notebook.getElementsByTagName("Person");
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < personElementList.getLength(); ++i) {
            Element personElement = (Element) personElementList.item(i);
            String nameTemp = personElement.getElementsByTagName("name")
                    .item(0)
                    .getTextContent();
            String addessTemp = personElement.getElementsByTagName("addess")
                    .item(0)
                    .getTextContent();
            String cashTemp = personElement.
                    getElementsByTagName("cash")
                    .item(0)
                    .getTextContent();
            String educationTemp = personElement.
                    getElementsByTagName("education")
                    .item(0)
                    .getTextContent();
            Person person = new Person(nameTemp, addessTemp, Integer.parseInt(cashTemp), educationTemp);
            personList.add(person);
        }
        Collection<Person> resoltCollection = personList.stream()
                .filter(person -> person.getCash() >= cashMin)
                .collect(Collectors.toCollection(ArrayList::new));
        return resoltCollection;
    }
}
