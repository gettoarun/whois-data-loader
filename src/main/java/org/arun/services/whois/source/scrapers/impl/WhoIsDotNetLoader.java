package org.arun.services.whois.source.scrapers.impl;

import java.util.List;

import org.arun.services.whois.source.scrapers.AbstractScrapingWhoisLoader;
import org.jsoup.nodes.Element;

/**
 * The Whois.net Scraper Implementation.
 * 
 * Search results comes in a &lt;div&gt; with class searchresults. 
 * There are two &lt;pre&gt; tags that contain this data.
 * 
 * @author gettoarun
 *
 */
public class WhoIsDotNetLoader extends AbstractScrapingWhoisLoader {
	public static final String BASE_URL = "http://whois.net/whois/";

	public WhoIsDotNetLoader() {
		super(BASE_URL);
	}

	@Override
	public String parseDocument() {
		String rawData = "";
		// Pick the search result
		List<Element> searchResultPREs = document.select( "div.searchresults > pre" );
	
		if ( searchResultPREs != null && searchResultPREs.size() > 0 ) {
			// Make one text block
			StringBuilder fullSearchText = new StringBuilder();
			for(Element serElement : searchResultPREs) {
				fullSearchText.append( serElement.text() ).append("\n");
			}
			rawData = fullSearchText.toString();
		}
		
		return rawData;
	}
}
