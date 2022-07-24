package projectC.models.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class CommonInformationServiceModel extends BaseServiceModel {

	private LocalDate date;
	private int testsPerformance;
	private int testsPerDay;
	private int confirmedCases;
	private int activeCases;
	private int newCasesPerDay;
	private int hospitalized;
	private int newlyHospitalized;
	private int inTheIntensiveCare;
	private int recovery;
	private int recoveryPerDay;
	private int deceased;
	private int deceasedPerDay;
	
	private double percentPTest;
	private double coefficientIncreasment;
}
