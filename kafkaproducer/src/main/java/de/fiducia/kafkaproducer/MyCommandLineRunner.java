package de.fiducia.kafkaproducer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import de.fiducia.kafkaproducer.event.PersonErfasstEvent;
import de.fiducia.kafkaproducer.event.messaging.MyChannels;
import de.fiducia.kafkaproducer.model.Person;


@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private MyChannels channels;
	
	@Autowired
	private PersonErfasstRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo Welt");
		
		for (int i = 0; i < 1_000; i++) {
			Person person = Person.builder().id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build();
			PersonErfasstEvent event = PersonErfasstEvent.builder().payload(person).build();
			Message<PersonErfasstEvent> message = MessageBuilder.withPayload(event).build();
			channels.personErfasstOut().send(message);
			repo.save(event);
		}
		System.out.println("Fertig");
	}

}
