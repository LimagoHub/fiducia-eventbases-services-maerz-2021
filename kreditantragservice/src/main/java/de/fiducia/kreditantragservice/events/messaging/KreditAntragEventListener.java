package de.fiducia.kreditantragservice.events.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import de.fiducia.kreditantragservice.events.CityScoringNegativEvent;
import de.fiducia.kreditantragservice.events.CityScoringPositivEvent;
import de.fiducia.kreditantragservice.events.ScoringNegativEvent;
import de.fiducia.kreditantragservice.events.ScoringPositivEvent;

@Component
public class KreditAntragEventListener {
	
	private final KreditAntragChannels channels;

	public KreditAntragEventListener(KreditAntragChannels channels) {
		this.channels = channels;
	}
	
	@StreamListener(KreditAntragChannels.SCORING_POSITIVE)
	public void handle(ScoringPositivEvent event) {
		
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
