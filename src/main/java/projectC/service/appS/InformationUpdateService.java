package projectC.service.appS;

/**
 * This interface contains methods for updating Covid information in DB.
 *
 */
import projectC.exceptions.CommonInformationException;

public interface InformationUpdateService {

	/**
	 * The method update <b>common information</b> for Covid in DB.
	 */
	void updateCommonInformationFromPublicSiteToDb() throws CommonInformationException;

	/**
	 * The method update <b>distribution by data and area</b> information for Covid in DB.
	 */
	void updateDistributionByDataAndAreaFromPublicSitetoDb();

	/**
	 * The method update <b>distribution by date and age group</b> information for Covid in DB.
	 */
	void updateDistributionByDateAndAgeGroupFromPublicSitetoDb();

	/**
	 * The method update <b>distribution by type of tests</b> information for Covid in DB.
	 */
	void updateDistributionByTypeOfTestsFromPublicSitetoDb();

	/**
	 * The method update <b>dead by sex and age groups</b> information for Covid in DB.
	 */
	void updateDeadBySexAndAgeGroupsFromPublicSitetoDb();

	/**
	 * The method update <b>infected vaccinated</b> information for Covid in DB.
	 */
	void updateInfectedVaccinatedFromPublicSiteToDb();

	/**
	 * The method update <b>hospitalized vaccinated</b> information for Covid in DB.
	 */
	void updateHospitalizedVaccinatedFromPublicSitetoDb();

	/**
	 * The method update <b>vaccinated in the intensive care unit</b> information for Covid in DB.
	 */
	void updateVaccinatedInTheIntensiveCareUnitFromPublicSitetoDb();

	/**
	 * The method update <b>died vaccinated</b> information for Covid in DB.
	 */
	void updateDiedVaccinatedFromPublicSitetoDb();

}
