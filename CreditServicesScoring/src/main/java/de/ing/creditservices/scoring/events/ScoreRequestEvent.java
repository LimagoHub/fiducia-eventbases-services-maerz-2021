package de.ing.creditservices.scoring.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.ing.creditservices.scoring.models.Kreditantrag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreRequestEvent extends BaseEvent {

	
	private static final long serialVersionUID = -1927441108202517L;
	private Kreditantrag kreditantrag;
	
	
}
