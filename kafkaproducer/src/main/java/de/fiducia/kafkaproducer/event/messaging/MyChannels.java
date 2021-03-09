package de.fiducia.kafkaproducer.event.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyChannels {
	
	String PERSON_ERASST = "personErfasstOut";
	String SCORING_POSITIVE = "scoringRequestIn";
	
	
	@Output
	MessageChannel personErfasstOut();
	
	@Input
	SubscribableChannel scoringRequestIn();

}
