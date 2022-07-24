/**
 * @author stspot
 * This class describe a PercentPTestServiceModel.
 */

package projectC.models.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class PercentPTestServiceModel {

	private LocalDate date;
	private double percentPTest;
	private int newCasesPerDay;
	
}
