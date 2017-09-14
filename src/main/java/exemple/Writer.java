package exemple;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Collection;

import org.w3c.dom.Document;


/**
 * Created by Maksym_Moroz1 on 9/14/2017.
 */
public class Writer {

    public String toStringXMLRepresentation(Document doc) {
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = null;
        try {
            trans = transfac.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(doc.getDocumentElement());

        try {
            trans.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        String xmlString = sw.toString();
        return xmlString;
    }

    public String toStringPersonsCollection(Collection<Person> persons) {
        StringBuilder personInfornationBuilder = new StringBuilder();
        for (Person person : persons) {
            personInfornationBuilder.append("Name:      " + person.getName() + "\n");
            personInfornationBuilder.append("Address:   " + person.getAddress() + "\n");
            personInfornationBuilder.append("Cash:      " + person.getCash() + "\n");
            personInfornationBuilder.append("Education: " + person.getEducation() + "\n\n");
        }
        return personInfornationBuilder.toString();
    }

    public boolean extructXMLToFile(Document doc, String path) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) { return false; }

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(path));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) { return false; }
        return true;
    }

    public boolean extructPersonsCollectionToFile(Collection<Person> persons, String path) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(
                    new BufferedOutputStream(new FileOutputStream(path)));
        } catch (FileNotFoundException e) { return false; }
        writer.print(this.toStringPersonsCollection(persons));
        writer.close();
        return true;
    }
}
