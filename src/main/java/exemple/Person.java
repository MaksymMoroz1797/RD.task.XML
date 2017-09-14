package exemple;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class Person {
    private String name;
    private String address;
    private Integer cash;
    private String education;

    public Person(String name, String address, Integer cash, String education) {
        this.name = name;
        this.address = address;
        this.cash = cash;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getCash() {
        return cash;
    }

    public String getEducation() {
        return education;
    }
}
