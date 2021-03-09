package de.fiducia.kreditantragservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ScoringNegativEvent extends BaseEvent {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6831095959664175243L;
	private String kreditAntragId;
}
