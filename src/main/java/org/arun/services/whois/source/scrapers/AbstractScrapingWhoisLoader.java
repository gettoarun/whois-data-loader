package org.arun.services.whois.source.scrapers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.arun.services.whois.model.Domain;
import org.arun.services.whois.model.Registrant;
import org.arun.services.whois.model.RegistryAdmin;
import org.arun.services.whois.model.RegistryTech;
import org.arun.services.whois.model.WhoIsRecord;
import org.arun.services.whois.processors.WhoIsRecordProcessor;
import org.arun.services.whois.source.WhoIsService;
import org.arun.services.whois.source.WhoIsServiceException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * A default abstract workflow for a Web Scraping WHOIS loader.
 * 
 * You can override lookup to provide a more customized workflow or
 * just implement the <code>parseDocument()</code>
 * 
 * <b>Tip</b>
 * 
 * To troubleshoot or for learning misses, set the 
 * <b>org.arun.services.whois.scrapelog</b> system property to true
 * This would make the scraped document be logged for review in the tmp folder.
 * 
 * The path reference to this will be logged, just in case.
 * 
 * @author gettoarun
 *
 */
public abstract class AbstractScrapingWhoisLoader implements WhoIsService {
	private static final int    DEFAULT_TIMEOUT = 3000;
	private static final String DEFAULT_USER_AGENT = "Mozilla";

	private static final String SCRAPELOG_SUFFIX = ".html";
	private static final String SCRAPELOG_PREFIX = "whois-loader-";

	private String baseURL    = null;

	protected Document document = null;
	
	/** Just make sure you give me a base URL,
	 *  baseURL is such that
	 *  <baseURL>/<domain> should provide the required data.
	 *  
	 *  I have used whois.net and who.is as the URL sources to
	 *  base this URL format on.
	 *  
	 * @param baseURL
	 */
	public AbstractScrapingWhoisLoader(String baseURL) {
		this.baseURL= baseURL;
	}
	
	/**
	 * Default implementation to scrape a WhoIsRecord.
	 * 
	 * @param domain
	 * @throws IOException
	 */
	protected void load( String domain ) throws IOException {
		// JSoup source the document
		document = Jsoup.connect(baseURL + domain)
					  .data("query", "Java")
					  .userAgent(DEFAULT_USER_AGENT)
					  //.cookie("auth", "token")
					  .timeout(DEFAULT_TIMEOUT)
					  .get();

		if ( "true".equalsIgnoreCase( System.getProperty(ENABLE_SCRAPELOG_KEY)  ) ) {
			dumpScrapedFile( domain );
		}
	}
	
	/**
	 * Mostly for learning purposes, its writing to temp folder
	 * so it can be removed by standard maintainence processes.
	 * @param domain 
	 */
	protected void dumpScrapedFile(String domain) {
		try {
			File scrapedFile = File.createTempFile(
					SCRAPELOG_PREFIX + 
					this.getClass().getSimpleName() + "-" + domain, 
					SCRAPELOG_SUFFIX);
			FileWriter fw = new FileWriter( scrapedFile ); 
			fw.write( document.toString() );
			fw.close();
			log("created cache " + scrapedFile.getAbsolutePath());
		} catch (IOException ignore) {
			ignore.printStackTrace();
		}
	}

	/**
	 * Abstraction to parse the scraped document 
	 * 
	 * override me (no you wont get tickets for this)...
	 * 
	 * @return parsed data
	 */
	public  abstract String parseDocument();
	
	/* 
	 * The default web scraping workflow.
	 * 
	 * TODO: make this a sdedit taglet.
	 * 
	 * @sequence.diagram
	 * 
	 * <ol>
	 * <li>load document from web -> <code>load()</code>
	 * <li>extract search result  -> <code>parseDocument</code>
	 * <li>parse result           -> <code>WhoIsRecordProcessor</code>
	 * </ol>
	 * 
	 * @see org.arun.services.whois.source.WhoIsService#lookup(java.lang.String)
	 */
	public WhoIsRecord lookup( String domain ) throws WhoIsServiceException {
		WhoIsRecord whoisRec = null;

		// Load the WhoIs Document
		try {
			load( domain );
		
			// Parse it using extension
			String rawData = parseDocument();
			if ( rawData == null || "".equals( rawData ) ) 
				throw new WhoIsServiceException("No data found or blocked!");
			
			// Process the raw stream in rawData
			WhoIsRecordProcessor processor = new WhoIsRecordProcessor();
				whoisRec = processor.process(WhoIsRecord.class, rawData);
					whoisRec.setDomain       ( processor.process(Domain.class, rawData) );
					whoisRec.setRegistrant   ( processor.process(Registrant.class, rawData) );
					whoisRec.setRegistryAdmin( processor.process(RegistryAdmin.class, rawData));
					whoisRec.setRegistryTech ( processor.process(RegistryTech.class, rawData) );
		
		} catch (IOException e) {
			e.printStackTrace();
			throw new WhoIsServiceException("Failed to lookup.", e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new WhoIsServiceException("Failed to create WhoIsRecord, talk to me.", e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new WhoIsServiceException("Failed to set WhoIsRecord properties, talk to me.", e);
		}
		return whoisRec;
	}

	/** 
	 * Teehee.. my notion of lightweight logging
	 * @param string
	 */
	private void log(String string) {
		System.out.println( string );	
	}
}