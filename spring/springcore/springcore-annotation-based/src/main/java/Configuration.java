import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class Configuration {
    @Bean
    @Qualifier("primarycontact")
    public ContactInfo contact1(){
        return new ContactInfo("abc@xyz.com", "12345");
    }

    @Bean
    @Qualifier("alternatecontact")
    public ContactInfo contact2(){
        return new ContactInfo("lmn@xyz.com", "56789");
    }
}
