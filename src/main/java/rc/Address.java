package rc;

/**
 * Created by sob1 on 03.08.2017.
 */
public class Address {
    private String city;
    private String country;

    protected Address(){};

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
