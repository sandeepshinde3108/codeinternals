import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringCoreTest {
    public static void main(String[] args) {
        //multiple files can be provided comma separated to the constructor of ClassPathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("employee-beans.xml", "company-beans.xml");

        //get list of beans created in Spring container
        System.out.println("--------------------List of Beans in the Spring Container-------------------");
        String[] names = context.getBeanNamesForType(Department.class);
        for (String name : names) {
            System.out.println(name);
        }

        //explicit type cast to a specific bean type
        Department dept = (Department) context.getBean("department2");
        System.out.println(dept.toString());

        //it is a generic variant of getBean method where explicit casting is not required instead type needs to be passed to the method
        Department deptWithTypeArgs = context.getBean("deptWithTypeArgs", Department.class);
        System.out.println(deptWithTypeArgs.toString());

        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());

        Company company = context.getBean("company", Company.class);
        System.out.println(company.toString());
    }
}
