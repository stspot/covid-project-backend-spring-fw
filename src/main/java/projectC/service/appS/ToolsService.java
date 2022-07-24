package projectC.service.appS;

/**
 * This class contains help method for the project.
 */
import java.time.LocalDateTime;
import java.util.List;

import javax.net.ssl.SSLContext;

public interface ToolsService {

	/**
	 * Create log in DB.
	 * @param date
	 * @param logOper
	 * @param description
	 */
	void createLog(LocalDateTime date, String logOper, String description);
	
	/**
	 * Excludes the requirement for SSL certificate
	 * @return SSLContext
	 */
	SSLContext getInsecureContext();
	
	/**
	 * Accepts a link to the Covid database and 
	 * returns a two dimensional array with them.
	 * @param urlLink
	 * @return String[][]
	 */
	String[][] getResponse(String urlLink);
	
	/**
	 * Checks if a value can be transform from String to int.
	 * @param string
	 * @return boolean
	 */
	boolean checkPosibleToParseToInt(String string);
	
	/**
	 * Convert List from one type to other
	 * @param <S>
	 * @param <T>
	 * @param source
	 * @param targetClass
	 * @return
	 */
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass);
}
