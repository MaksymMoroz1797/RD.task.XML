package exemple;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class Runner {
    public static void main(String[] args) {
        CatalogXMLBuilder catalogXMLBuilder = new CatalogXMLBuilder();
        catalogXMLBuilder.addperson("Vasya1", "Damask", "10000", "Hight");
        catalogXMLBuilder.addperson("Vasya2", "Damask", "10000", "Hight");
        catalogXMLBuilder.addperson("Vasya3", "Damask", "10000", "Hight");
        System.out.println(catalogXMLBuilder.toStringXMLRepresentation());
        //catalogXMLBuilder.extructToFile("C:\\Users\\Maksym_Moroz1\\Desktop\\text.txt");
    }
}
