package org.arun.services.whois;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.arun.services.whois.model.WhoIsRecord;
import org.arun.services.whois.source.WhoIsService;

public class WhoIsTestBase {
	
	public WhoIsTestBase() {
		System.setProperty(WhoIsService.ENABLE_SCRAPELOG_KEY, "true");
	}

	protected void validateRecord(WhoIsRecord whoisRec) {
		assertNotNull("WHOIS  Record is empty/null", whoisRec );
		assertNotNull("Domain Record is empty/null", whoisRec.getDomain() );
		assertEquals("google.com", whoisRec.getDomain().getDomainName());
	}
}