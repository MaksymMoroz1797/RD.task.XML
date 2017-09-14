package exemple;

import java.util.Collection;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class Runner {
    public static void main(String[] args) {
        CatalogXMLBuilder catalogXMLBuilder = new CatalogXMLBuilder();
        catalogXMLBuilder.addperson("Vasya1", "Damask", "12000", "Hight");
        catalogXMLBuilder.addperson("Vasya2", "Bagdad", "100000", "Hight");
        catalogXMLBuilder.addperson("Vasya3", "Tripoly", "1001100", "Hight");
        catalogXMLBuilder.addperson("Vasya4", "Tegeran", "10000", "Hight");
        catalogXMLBuilder.addperson("Vasya5", "Cairo", "201100", "Hight");
        Writer writer = new Writer();

        System.out.println(writer.toStringXMLRepresentation(catalogXMLBuilder.getDocument()));

        writer.extructXMLToFile(catalogXMLBuilder.getDocument(),
                "C:\\Users\\Maksym_Moroz1\\Desktop\\text.txt");

        PersonParser personParser = new PersonParser("C:\\Users\\Maksym_Moroz1\\Desktop\\text.txt");
        Collection<Person> persons = personParser.getRangedPersons(100000);

        writer.extructPersonsCollectionToFile(persons,
                "C:\\Users\\Maksym_Moroz1\\Desktop\\text1.txt");
        String rangedPersons = writer.toStringPersonsCollection(persons);
        System.out.println(rangedPersons);


    }
}
