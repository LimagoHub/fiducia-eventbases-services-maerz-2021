package de.fiducia.kafkaproducer.event;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import de.fiducia.kafkaproducer.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonErfasstEvent extends BaseEvent {
	
	@Embedded
	private Person payload;
	
	

}
