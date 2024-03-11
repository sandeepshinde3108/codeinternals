import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Department department(){
        return new Department(1, "Mechanical");
    }

    @Bean
    public Employee employee(){
        return new Employee(1, "Sandeep");
    }
}
