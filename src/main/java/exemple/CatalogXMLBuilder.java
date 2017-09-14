package exemple;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class CatalogXMLBuilder {

    private Document doc;
    private Element notebook;
    private int id = 0;
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {/* Nothing */  }
        doc = documentBuilder.newDocument();
        Element rootElement = doc.createElement("catalog");
        doc.appendChild(rootElement);
        this.notebook = doc.createElement("notebook");
        rootElement.appendChild(this.notebook);
    }

    public void addperson(String name, String address, String cash, String education) {
        Element person = doc.createElement("Person");
        this.notebook.appendChild(person);
        Attr attr = doc.createAttribute("id");
        attr.setValue(Integer.toString(++id));
        person.setAttributeNode(attr);

        Element nameChild = doc.createElement("name");
        nameChild.appendChild(doc.createTextNode(name));
        person.appendChild(nameChild);

        Element adderessChild = doc.createElement("addess");
        adderessChild.appendChild(doc.createTextNode(address));
        person.appendChild(adderessChild);

        Element cashChild = doc.createElement("cash");
        cashChild.appendChild(doc.createTextNode(cash));
        person.appendChild(cashChild);

        Element educationChild = doc.createElement("education");
        educationChild.appendChild(doc.createTextNode(education));
        person.appendChild(educationChild);
    }

    /*public String toStringXMLRepresentation() {
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
        DOMSource source = new DOMSource(this.doc.getDocumentElement());

        try {
            trans.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        String xmlString = sw.toString();
        return xmlString;
    } */

    public Document getDocument() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {/* Nothing */  }
        Document cloneDoc = documentBuilder.newDocument();
        cloneDoc.appendChild(cloneDoc.importNode(this.doc.getDocumentElement(), true));
        return cloneDoc;
    }
}
