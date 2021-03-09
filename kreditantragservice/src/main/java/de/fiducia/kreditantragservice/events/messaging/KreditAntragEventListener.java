package de.fiducia.kreditantragservice.events.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import de.fiducia.kreditantragservice.events.CityScoringNegativEvent;
import de.fiducia.kreditantragservice.events.CityScoringPositivEvent;
import de.fiducia.kreditantragservice.events.ScoringNegativEvent;
import de.fiducia.kreditantragservice.events.ScoringPositivEvent;
import de.fiducia.kreditantragservice.services.KreditAntragService;

@Component
public class KreditAntragEventListener {
	
	private final KreditAntragChannels channels;
	private final KreditAntragService service;

	public KreditAntragEventListener(KreditAntragChannels channels,KreditAntragService service) {
		this.channels = channels;
		this.service = service;
	}
	
	@StreamListener(KreditAntragChannels.SCORING_POSITIVE)
	public void handle(ScoringPositivEvent event) {
		switch (service.positivScoreReceived(event.getKreditAntragId())) {
		case 1:
			// Fire Antrag genehmigt Event
			break;
		case 2:
			// Fire Antrag abgelehnt Event
			break;
		default:
			break;
		}
	}

	@StreamListener(KreditAntragChannels.SCORING_NEGATIVE)
	public void handle(ScoringNegativEvent event) {
		
	}

	@StreamListener(KreditAntragChannels.CITY_SCORING_POSITIVE)
	public void handle(CityScoringPositivEvent event) {
		
	}
	@StreamListener(KreditAntragChannels.CITY_SCORING_NEGATIVE)
	public void handle(CityScoringNegativEvent event) {
		
	}

}
