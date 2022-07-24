package projectC.service.appS;

/**
 * Load all information in DB.
 */
public interface LoaderService {
	
	/**
	 * The method loads all information for Covid from
	 * origin if the tables are empty.
	 */
	void loadCommonInformationToDb();

}
