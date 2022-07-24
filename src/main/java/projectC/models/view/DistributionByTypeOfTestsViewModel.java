package projectC.models.view;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class DistributionByTypeOfTestsViewModel {

	private LocalDate date;
	private int allTestToNow;
	private int allPCRTestsToNow;
	private int allAntigenTestsToNow;
	private int allTestsFor24;
	private int allPCRTestsFor24Hours;
	private int allAntigenTestsFor24;
	private int allЕstablishedCasesToNow;
	private int allЕstablishedCasesWithPCRToNow;
	private int allЕstablishedCasesWithAntigenToNow;
	private int establishedCasesFor24Hours;
	private int establishedCasesFor24WithPCR;
	private int establishedCasesFor24WithAntigen;
	
}
