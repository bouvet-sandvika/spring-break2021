package no.bouvet.deskbooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeskBookingApplication {

	Logger logger = LoggerFactory.getLogger(DeskBookingApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(DeskBookingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			logger.info("Hello world!");
		};
	}

}
