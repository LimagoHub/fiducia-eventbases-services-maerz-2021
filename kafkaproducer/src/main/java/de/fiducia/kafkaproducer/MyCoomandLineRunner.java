package de.fiducia.kafkaproducer;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.fiducia.kafkaproducer.model.Person;


@Component
public class MyCoomandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo Welt");
		
		Person person = Person.builder().id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build();

	}

}
