package projectC.models.view;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class PercentPTestViewModel {

	private LocalDate date;
	private double percentPTest;
	private int newCasesPerDay;
	
}
