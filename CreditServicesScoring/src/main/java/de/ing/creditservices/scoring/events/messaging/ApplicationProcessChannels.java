package de.ing.creditservices.scoring.events.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ApplicationProcessChannels {
	String SCORING_REQUEST = "scoringRequestIn";
	String SCORING_POSITIVE = "scoringPositivOut";
	String SCORING_NEGATIVE = "scoringNegativOut";


	@Output
	MessageChannel scoringNegativOut();

	@Output
	MessageChannel scoringPositivOut();

	@Input
	SubscribableChannel scoringRequestIn();

}
