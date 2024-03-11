import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringCoreTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
        Employee employee = context.getBean("emp", Employee.class);

        System.out.println(employee.toString());
    }
}
