package de.fiducia.kreditantragservice.events;

import de.fiducia.kreditantragservice.models.KreditAntrag;
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
public class KreditAntragErfasstEvent extends BaseEvent {

	private static final long serialVersionUID = -5083279448054793083L;
	private KreditAntrag kreditAntrag;
}
