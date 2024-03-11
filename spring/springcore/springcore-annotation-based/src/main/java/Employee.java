import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.inject.Inject;

public final class Employee {
    private int id;
    private String name;
    private Department department;

    @Inject
    private Address address;

    private ContactInfo contactInfo;

    @Autowired
    public Employee(int id, String name, Department department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    @Autowired
    @Qualifier("alternatecontact")
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", address=" + address +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
