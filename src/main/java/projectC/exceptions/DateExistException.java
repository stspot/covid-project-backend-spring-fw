package projectC.exceptions;

public final class DateExistException extends Exception {

	private static final long serialVersionUID = 8735945921766892204L;

	public DateExistException(String msg){
		super(msg);
	}
}
