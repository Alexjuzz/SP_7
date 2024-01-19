package Spring.home.hm2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hm2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hm2Application.class, args);
		HelloControllerByUserName h = new HelloControllerByUserName(new HelloService());
	}

}
