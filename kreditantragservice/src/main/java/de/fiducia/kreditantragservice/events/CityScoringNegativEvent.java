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
public class CityScoringNegativEvent extends BaseEvent {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2735454869551026327L;
	private String kreditAntragId;
}
