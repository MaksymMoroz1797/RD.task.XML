package exemple;

import java.util.Collection;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class Runner {
    public static void main(String[] args) {
        CatalogXMLBuilder catalogXMLBuilder = new CatalogXMLBuilder();
        catalogXMLBuilder.addperson("Vasya1", "Damask", "1200", "Hight");
        catalogXMLBuilder.addperson("Vasya2", "Bagdad", "10000", "Hight");
        catalogXMLBuilder.addperson("Vasya3", "Tripoly", "101100", "Hight");
        catalogXMLBuilder.addperson("Vasya4", "Tegeran", "1000", "Hight");
        catalogXMLBuilder.addperson("Vasya5", "Cairo", "21100", "Hight");
        Writer writer = new Writer();

        System.out.println(writer.toStringXMLRepresentation(catalogXMLBuilder.getDocument()));

        writer.extructXMLToFile(catalogXMLBuilder.getDocument(),
                "C:\\Users\\Maksym_Moroz1\\Desktop\\XML_Sourse.xml");

        PersonParser personParser = new PersonParser("C:\\Users\\Maksym_Moroz1\\Desktop\\XML_Sourse.xml");
        Collection<Person> persons = personParser.getRangedPersons(10000);

        writer.extructPersonsCollectionToFile(persons,
                "C:\\Users\\Maksym_Moroz1\\Desktop\\result.txt");
        String rangedPersons = writer.toStringPersonsCollection(persons);
        System.out.println(rangedPersons);


    }
}
