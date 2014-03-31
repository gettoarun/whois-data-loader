/**
 * 
 */
package org.arun.services.whois.dsl;

import java.util.Iterator;
import java.util.LinkedList;

import org.arun.services.whois.model.WhoIsRecord;
import org.arun.services.whois.source.WhoIsServiceException;
import org.arun.services.whois.source.scrapers.AbstractScrapingWhoisLoader;

/**
 * A Fluent Interface / DSL for creating a WhoIsRecord Lookup Workflow.
 * 
 * Since we have a default implementation to Scrape things down from sites
 * who most generously block such programs, we need a fallback plan. 
 * 
 * <b>Anonymous: Aye Aye captain !</b>
 * <b>me: cool down, we have got work to do</b>
 * 
 * @author gettoarun
 *
 */
public class WhoisLookupBuilder {

	/** Holds the loader fallback chain */
	private LinkedList<AbstractScrapingWhoisLoader> loaderChain = new LinkedList<AbstractScrapingWhoisLoader>();
	
	/** Sets the first Scraping loader 
	 * @param firstLoader
	 * @return
	 */
	public  WhoisLookupBuilder startWith( AbstractScrapingWhoisLoader firstLoader ) {
		loaderChain.offerFirst( firstLoader );
		return this;
	}

	/**
	 * Appends to the chain.
	 * 
	 * @param nextLoader
	 * @return
	 */
	public WhoisLookupBuilder  nextWith( AbstractScrapingWhoisLoader nextLoader ) {
		loaderChain.offerLast( nextLoader );
		return this;
	}
	
	/**
	 * Invokes the chain of loaders, only when A fails to give one, does it call B...
	 * 
	 * <b>Anonymous: Brilliant, how indigenous</b>
	 * 
	 * @param domain
	 * @return
	 * @throws WhoIsServiceException - The last thrown, not the whole chain.
	 */
	public  WhoIsRecord lookup( String domain ) throws WhoIsServiceException {
		WhoIsRecord theRecord = null;
		WhoIsServiceException lastError = null;

		Iterator<AbstractScrapingWhoisLoader> loaderIter = loaderChain.iterator();
		while ( theRecord == null && 
				loaderIter.hasNext() == true ) {
			AbstractScrapingWhoisLoader curLoader = loaderIter.next();
			try {
				theRecord = curLoader.lookup( domain );
			} catch(WhoIsServiceException whoise){
				log("Failed to load from " + curLoader);
				whoise.printStackTrace();
				lastError = whoise;
			}
		}
		
		if ( theRecord == null && lastError != null ) 
			throw lastError;
		
		return theRecord;
	}

	/** 
	 * Teehee.. my notion of lightweight logging
	 * @param string
	 */
	private void log(String string) {
		System.out.println( string );	
	}	
}