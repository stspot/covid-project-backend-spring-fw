package projectC.models.view;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class InfectedVaccinatedViewModel {

	private LocalDate date;
	private String nameOfVaccine;
	private String gender;
	private String ageRange;
	private int numberOfCases;
	
}
