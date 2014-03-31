package org.arun.services.whois.source;


/**
 * A no nonsense wrapper exception.
 * 
 * @author gettoarun
 *
 */
public class WhoIsServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public WhoIsServiceException() {
		super();
	}

	public WhoIsServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WhoIsServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public WhoIsServiceException(String message) {
		super(message);
	}

	public WhoIsServiceException(Throwable cause) {
		super(cause);
	}	
}
