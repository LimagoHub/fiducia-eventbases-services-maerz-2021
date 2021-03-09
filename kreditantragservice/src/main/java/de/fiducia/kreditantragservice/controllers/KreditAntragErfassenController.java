package de.fiducia.kreditantragservice.controllers;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fiducia.kreditantragservice.events.KreditAntragErfasstEvent;
import de.fiducia.kreditantragservice.events.messaging.KreditAntragChannels;
import de.fiducia.kreditantragservice.models.KreditAntrag;
import de.fiducia.kreditantragservice.repositories.KreditAntragRepository;

@RestController
@RequestMapping("/kredit-antrag")
public class KreditAntragErfassenController {
	
	private final KreditAntragRepository repo;
	private final KreditAntragChannels channels;
	
	
	
	public KreditAntragErfassenController(final KreditAntragRepository repo, final KreditAntragChannels channels) {
		this.repo = repo;
		this.channels = channels;
	}



	@PutMapping(path="", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> erfassen(@Valid @RequestBody KreditAntrag antrag) {
		
		repo.save(antrag);
		fireKreditAntragErfasstEvent(antrag);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<KreditAntrag> findKreditAntragById(@PathVariable String id) {
		return ResponseEntity.of(repo.findById(id));
	}



	private void fireKreditAntragErfasstEvent(KreditAntrag antrag) {
		KreditAntragErfasstEvent event = KreditAntragErfasstEvent.builder().kreditAntrag(antrag).build();
		Message<KreditAntragErfasstEvent> message = MessageBuilder.withPayload(event).build();
		channels.kreditAntragErfasstOut().send(message);
	}

}
