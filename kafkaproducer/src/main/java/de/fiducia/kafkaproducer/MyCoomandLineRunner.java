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
public class MyCoomandLineRunner implements CommandLineRunner {

	@Autowired
	private MyChannels channels;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo Welt");
		
		Person person = Person.builder().id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build();

		PersonErfasstEvent event = PersonErfasstEvent.builder().payload(person).build();
		
		Message<PersonErfasstEvent> message = MessageBuilder.withPayload(event).build();
		
		channels.personErfasstOut().send(message);
	}

}
