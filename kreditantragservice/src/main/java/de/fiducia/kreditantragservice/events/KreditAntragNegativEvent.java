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
public class KreditAntragNegativEvent extends BaseEvent {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1302579588113359812L;
	private String kreditAntragId;
}
