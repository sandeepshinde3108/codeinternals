import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public final class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("Init called");
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Clean up called");
    }
}
