package exemple;

import java.io.File;
import java.util.Collection;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class PersonParser {
    private String path;

    public PersonParser(String path) {
        this.path = path;
    }

    public Collection<Person> getRangedXML(int cash) {
        File fileXML = new File(this.path);
        return null;
    }
}
