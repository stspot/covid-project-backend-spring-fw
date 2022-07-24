package projectC.models.entities;

//TODO Documentation and checking fields
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "common_informations")
public final class CommonInformation extends BaseEntity {

	@PastOrPresent
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "tests_performance")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int testsPerformance;
	
	@Column(name = "tests_per_day")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int testsPerDay;
	
	@Column(name = "confirmed_cases")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int confirmedCases;
	
	@Column(name = "active_cases")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int activeCases;
	
	@Column(name = "new_cases_per_day")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int newCasesPerDay;
	
	@Column(name = "hospitalized")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int hospitalized;
	
	@Column(name = "newly_hospitalized")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int newlyHospitalized;
	
	@Column(name = "in_the_intensive_care")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int inTheIntensiveCare;
	
	@Column(name = "recovery")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int recovery;
	
	@Column(name = "recovery_per_day")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int recoveryPerDay;
	
	@Column(name = "deceased")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int deceased;
	
	@Column(name = "deceased_per_day")
	@DecimalMin(value = "0", message = "Cannot be negativ")
	private int deceasedPerDay;
	
}
