package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqExApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqExApplication.class, args);
		System.out.println("Hello Java");
	}

}
