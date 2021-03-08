package de.fiducia.kafkaproducer.event;

import de.fiducia.kafkaproducer.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonErfasstEvent extends BaseEvent {
	
	private Person payload;
	
	

}
