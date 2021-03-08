package de.fiducia.kafkaproducer.event.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyChannels {
	
	String PERSON_ERASST = "personErfasstOut";
	
	@Output
	MessageChannel personErfasstOut();

}
