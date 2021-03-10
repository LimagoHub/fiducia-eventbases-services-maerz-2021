package de.ing.creditservices.scoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.ing.creditservices.scoring.events.messaging.ApplicationProcessChannels;

@SpringBootApplication
@EnableBinding(ApplicationProcessChannels.class)
public class CreditServicesScoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditServicesScoringApplication.class, args);
	}

}
