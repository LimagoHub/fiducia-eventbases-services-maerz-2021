package de.ing.creditservices.scoring.events.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import de.ing.creditservices.scoring.events.ScoreRequestEvent;
import de.ing.creditservices.scoring.events.ScoringDoneEvent;
import de.ing.creditservices.scoring.models.Kreditantrag;



@Component
public class IncomingMessageListener {
	
	private final ApplicationProcessChannels channels;
	
	
	

	public IncomingMessageListener(ApplicationProcessChannels channels) {
		this.channels = channels;
	}




	@StreamListener(ApplicationProcessChannels.SCORING_REQUEST)
	public void receiveScoreRequestEvent(@Payload ScoreRequestEvent scoreRequestEvent) {
		final Kreditantrag antrag = scoreRequestEvent.getKreditantrag();
		System.out.println(antrag + " received. ######################");
		ScoringDoneEvent event = ScoringDoneEvent.builder().kreditAntragId(antrag.getKreditAntragId()).build();
		Message<ScoringDoneEvent> message = MessageBuilder.withPayload(event).build();
		if(antrag.processScoring())
			channels.scoringPositivOut().send(message);
		else
			channels.scoringNegativOut().send(message);
	}


}
