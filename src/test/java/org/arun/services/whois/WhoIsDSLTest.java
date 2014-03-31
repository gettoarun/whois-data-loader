package org.arun.services.whois;

import org.arun.services.whois.dsl.WhoisLookupBuilder;
import org.arun.services.whois.model.WhoIsRecord;
import org.arun.services.whois.source.scrapers.impl.WhoIsDotNetLoader;
import org.arun.services.whois.source.scrapers.impl.WhoIsLoader;
import org.junit.Test;

public class WhoIsDSLTest extends WhoIsTestBase {

	@Test 
	public void testSomehowWhois() throws Exception {
		WhoIsRecord whoisRec = 
			new WhoisLookupBuilder()
				.startWith( new WhoIsDotNetLoader() )
				.nextWith( new WhoIsLoader() )
				.lookup( "google.com" );
		
		validateRecord( whoisRec );
	}
	
}
