package de.fiducia.kafkaproducer;

import org.springframework.data.repository.CrudRepository;

import de.fiducia.kafkaproducer.event.PersonErfasstEvent;

public interface PersonErfasstRepository extends CrudRepository<PersonErfasstEvent, String> {

}
