/**
 * 
 */
package br.atech.workshop.bestpractices.thirdpart1;


/**
 * @author marcio
 * 
 */
public class DataException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DataException() {
		this("Data error.");
	}

	/**
	 * @param message
	 */
	public DataException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DataException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
