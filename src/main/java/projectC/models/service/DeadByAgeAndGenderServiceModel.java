package projectC.models.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class DeadByAgeAndGenderServiceModel {

	private LocalDate date;
	private String gender;
	private String ageRange;
	private int numberOfCases;
	
}
