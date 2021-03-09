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
public class CityScoringPositivEvent extends BaseEvent {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1460902201144077066L;
	private String kreditAntragId;
}
