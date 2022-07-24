/**
 * This interface contains methods for managing general
 *  information about Covid cases.
 */

package projectC.service.commonInfo;

import java.time.LocalDate;
import java.util.List;

import projectC.exceptions.DateExistException;
import projectC.models.service.CommonInformationServiceModel;
import projectC.models.service.PercentPTestServiceModel;

public interface CommonInformationService {

	/**
	 * The method queries the database and takes all general information about Covid cases.
	 * The method returns a list of information, each record of which is for one day.
	 * @return List of CommonInformationServiceModel
	 */
	List<CommonInformationServiceModel> getAllCommonInformation();

	/**
	 * The method queries the database and takes all general information about Covid cases.
	 * Returns a list of objects that contains information about the percentage of new Covid cases,
	 * based on the number of tests for the day.
	 * @return {@link List} of {@link PercentPTestServiceModel} 
	 */
	List<PercentPTestServiceModel> getPercentPTestForEveryDay();

	/**
	 * The method queries the database and takes general information about Covid cases for current day.
	 * @return PercentPTestServiceModel
	 */
	CommonInformationServiceModel getAllInformationForCurrentDayByDate(LocalDate currentDate);

	List<PercentPTestServiceModel> getAllInformationForCurrentYearAndMonth(int inputYear, int inputMonth);

	void addDataForCurrentDay(CommonInformationServiceModel map) throws DateExistException;
	
}
