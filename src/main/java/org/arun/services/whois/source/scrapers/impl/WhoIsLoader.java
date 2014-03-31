package org.arun.services.whois.source.scrapers.impl;

import java.util.List;

import org.arun.services.whois.source.scrapers.AbstractScrapingWhoisLoader;
import org.jsoup.nodes.Element;

/**
 * The who.is Web Scraper Implementation.
 * 
 * The search results appear in a &lt;div&gt; with class raw_data
 * Which contains a single dump of all data elements.
 * 
 * @author gettoarun
 *
 */
public class WhoIsLoader extends AbstractScrapingWhoisLoader {
	public static final String BASE_URL = "http://who.is/whois/";

	public WhoIsLoader() {
		super(BASE_URL);
	}

	@Override
	public String parseDocument() {
		String rawData = "";
		// Pick the search result
		List<Element> searchResultPREs = document.select( "div.raw_data > span " );
	
		if ( searchResultPREs != null ) {
			// Make one text block
			StringBuilder fullSearchText = new StringBuilder();
			for(Element serElement : searchResultPREs) {
				String blockText = serElement.html();
				blockText = blockText.replaceAll("<br />", "\n");
				fullSearchText.append( blockText ).append("\n");
			}
			rawData = fullSearchText.toString();
		}
		
		return rawData;
		
	}
}
