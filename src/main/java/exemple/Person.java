package exemple;

/**
 * Created by Maksym_Moroz1 on 9/13/2017.
 */
public class Person {
    private String name;
    private String address;
    private Integer cash;

    public Person(String name, String address, Integer cash) {
        this.name = name;
        this.address = address;
        this.cash = cash;
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
}
