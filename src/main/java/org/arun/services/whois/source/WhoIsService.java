package org.arun.services.whois.source;

import org.arun.services.whois.model.WhoIsRecord;

/**
 * The Primary Service Interface.
 * 
 * Implement this interface with any data provider, 
 * scraped public libraries or a local DB.
 * 
 * @author gettoarun
 *
 */
public interface WhoIsService {
	
	public static final String ENABLE_SCRAPELOG_KEY = "org.arun.services.whois.scrapelog";

	/**
	 * Provide a WhoIsRecord for a given domain.
	 * 
	 * @param domain
	 * @return
	 * @throws WhoIsServiceException
	 */
	public WhoIsRecord lookup(String domain) throws WhoIsServiceException;

}