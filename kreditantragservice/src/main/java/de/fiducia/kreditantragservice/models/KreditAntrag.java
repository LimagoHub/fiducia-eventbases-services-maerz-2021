package de.fiducia.kreditantragservice.models;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



@Entity
@Table (name = "tbl_credit_applications")

public class KreditAntrag implements Serializable {
	/*
	 * wandelt das Object in einen Bytestrom
	 */


	private static final long serialVersionUID = 8144682724082102640L;
	@Builder.Default
	@Size(min = 36, max = 36)
	@NotBlank
	@Id
	@Column(length = 36)
	private String creditApplicationId = UUID.randomUUID().toString();
	
	@NonNull
	@Size(min = 2, max = 51, message = "bitte min. 2 Zeichen eingeben")

	@Column(length = 51)
	private String firstName;
	
	@NonNull
	@Size(min = 2, max = 51,  message = "bitte min. 2 Zeichen eingeben")
	@NotBlank
	@Column(length = 51)
	private String lastName;
	@Size(min = 2, max = 51)
	@NonNull
	@Size(min = 2, max = 51, message = "bitte min. 2 Zeichen eingeben")
	@NotBlank
	@Column(length = 51)
	private String city;

	@Builder.Default
	private LocalDateTime applicationDate = LocalDateTime.now();
	@Version
	private long version;
	@Min(value = 0)
	@DecimalMin(inclusive = false , message = "darf nicht negativ oder leer (0) sein", value = "0")
	@NotNull
	private double monthlyIncome;
	@Min(value = 0)
	private double monthlyExpenditure;
	@Min(value = 0)
	@DecimalMin(inclusive = false , message = "darf nicht negativ oder leer (0) sein", value = "0")
	private double creditSum;

	@Builder.Default
	@Column(length = 20, nullable = false)
	private String scoringState = "in progress";
	@Builder.Default
	@Column(length = 20, nullable = false)
	private String cityCheckState = "in progress"; 
	@Builder.Default
	@Column(length = 20, nullable = false)
	private String applicationState = "in progress";
	

}
