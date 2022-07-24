package projectC.models.entities;

//TODO Documentation and checking fields
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "distribution_by_type_of_tests")
public final class DistributionByTypeOfTests extends BaseEntity {

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
	
	public DistributionByTypeOfTests(LocalDate date, int allTestToNow,
			int allPCRTestsToNow, int allAntigenTestsToNow, int allTestsFor24, int allPCRTestsFor24Hours,
			int allAntigenTestsFor24, int allЕstablishedCasesToNow, int allЕstablishedCasesWithPCRToNow,
			int allЕstablishedCasesWithAntigenToNow, int establishedCasesFor24Hours, int establishedCasesFor24WithPCR,
			int establishedCasesFor24WithAntigen) {
		super();
		this.date = date;
		this.allTestToNow = allTestToNow;
		this.allPCRTestsToNow = allPCRTestsToNow;
		this.allAntigenTestsToNow = allAntigenTestsToNow;
		this.allTestsFor24 = allTestsFor24;
		this.allPCRTestsFor24Hours = allPCRTestsFor24Hours;
		this.allAntigenTestsFor24 = allAntigenTestsFor24;
		this.allЕstablishedCasesToNow = allЕstablishedCasesToNow;
		this.allЕstablishedCasesWithPCRToNow = allЕstablishedCasesWithPCRToNow;
		this.allЕstablishedCasesWithAntigenToNow = allЕstablishedCasesWithAntigenToNow;
		this.establishedCasesFor24Hours = establishedCasesFor24Hours;
		this.establishedCasesFor24WithPCR = establishedCasesFor24WithPCR;
		this.establishedCasesFor24WithAntigen = establishedCasesFor24WithAntigen;
	}
	
}
