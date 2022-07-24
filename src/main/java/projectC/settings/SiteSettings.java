package projectC.settings;
/**
 * The class contains common settings for the site.
 */

import java.time.format.DateTimeFormatter;

public class SiteSettings {

	public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	public final static DateTimeFormatter DATE_FORMATTER_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
