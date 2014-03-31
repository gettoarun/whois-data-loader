package org.arun.services.whois;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.arun.services.whois.model.WhoIsRecord;
import org.arun.services.whois.source.WhoIsServiceException;
import org.arun.services.whois.source.scrapers.impl.WhoIsDotNetLoader;
import org.arun.services.whois.source.scrapers.impl.WhoIsLoader;
import org.junit.Test;

public class WhoIsDotNetLoaderTest extends WhoIsTestBase {

	@Test
	public void testWhoIsNet() throws Exception {
		WhoIsRecord whoisRec = new WhoIsDotNetLoader().lookup( "google.com" );
		validateRecord( whoisRec );
	}

	@Test
	public void testWhoIsInvalid() {
		// Hope nobody picks a domain like this.
		try {
			new WhoIsLoader().lookup( UUID.randomUUID().toString() );
			assertFalse( true );
		} catch (WhoIsServiceException e) {
			assertTrue( true );
		}
	}
}
