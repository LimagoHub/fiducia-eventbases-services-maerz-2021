package de.ing.creditservices.scoring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kreditantrag {
	
	private String kreditAntragId;
	private double summeEinnahmen;
	private double summeAusgaben;
	private double kreditsumme;
	
	public boolean processScoring() {
		return kreditsumme < (summeEinnahmen - summeAusgaben) * 10.0;
	}
}