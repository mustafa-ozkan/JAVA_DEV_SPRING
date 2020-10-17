import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CyberTekApp {

    public static void main(String[] args) {
        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
    }


}
