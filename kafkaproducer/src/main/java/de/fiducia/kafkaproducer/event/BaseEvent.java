package de.fiducia.kafkaproducer.event;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEvent implements Serializable{

	
	private static final long serialVersionUID = 1069121335073007169L;
	@Id
	@Builder.Default private String eventId = UUID.randomUUID().toString();
	@Builder.Default private LocalDate createDate = LocalDate.now();
	
}
