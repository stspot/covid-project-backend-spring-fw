package projectC.service.appS;
/**
 * This interface contains methods for initial loading of DB.
 *
 */

public interface InformationService {

	/**
	 * The method load <b>common information</b> for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadCommonInformationFromPublicSiteToDb();
	
	
	/**
	 * The method load <b>distribution by date and area</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadDistributionByDataAndAreaFromPublicSitetoDb();
	
	/**
	 * The method load <b>distribution by date and age group</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadDistributionByDateAndAgeGroupFromPublicSitetoDb();
	
	/**
	 * The method load <b>distribution by type of tests</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadDistributionByTypeOfTestsFromPublicSitetoDb();
	
	/**
	 * The method load <b>dead by sex and age groups</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadDeadBySexAndAgeGroupsFromPublicSitetoDb();
	
	/**
	 * The method load <b>infected vaccinated</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadInfectedVaccinatedFromPublicSiteToDb();
	
	/**
	 * The method load <b>hospitalized vaccinated</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadHospitalizedVaccinatedFromPublicSitetoDb();
	
	/**
	 * The method load <b>vaccinated in the intensive care unit</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb();
	
	/**
	 * The method load <b>died vaccinated</b> information for Covid,
	 * when the project starts for first time and if
	 * the table in database for common information
	 * has not any records.
	 */
	void loadDiedVaccinatedFromPublicSitetoDb();
	
}
