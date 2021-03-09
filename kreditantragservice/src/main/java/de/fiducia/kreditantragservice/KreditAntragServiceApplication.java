package de.fiducia.kreditantragservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.fiducia.kreditantragservice.events.messaging.KreditAntragChannels;

@SpringBootApplication
@EnableBinding(KreditAntragChannels.class)
public class KreditAntragServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KreditAntragServiceApplication.class, args);
	}

}
