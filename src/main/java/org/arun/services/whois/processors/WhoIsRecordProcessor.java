package org.arun.services.whois.processors;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.arun.services.whois.model.meta.Whois;

/**
 * A Simple Processor based on Java 5 Annotations.
 * 
 * You can think of it as an Unmarshaller of sorts. 
 * Given a textual source of data, it process a given WhoIs Model
 * element with its data. 
 * 
 * <b>Anonymous: Is this the best you've got?</b>
 * <b>me: yes, for now</b>
 * <b>Same Anonymous: Hmmph... </b>
 *  
 * @author gettoarun
 *
 */
public class WhoIsRecordProcessor {

	/**
	 * Given a WhoIs Annotated Class, Source Text 
	 * 	creates an instance
	 *  parses the text for Key, Regex based on the <code>WhoIs</code>
	 *  annotation
	 *  provides a fully populated object back
	 *   
	 * @param clazz
	 * @param sourceData
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <T> T process(Class<T> clazz, String sourceData) throws InstantiationException, IllegalAccessException {
		T object = clazz.newInstance();
		
		for(Field field : clazz.getDeclaredFields() ) {
			log("processing field: " + field.getName() + "...");
			Whois whoisField = field.getAnnotation( Whois.class );
			if ( whoisField != null ) {
				field.setAccessible(true);
				parseWhoisField( object, whoisField, field , sourceData );
			}
		}
		
		return object;
	}

	private <T> void parseWhoisField(T instance, Whois whois, Field field, String sourceData) throws IllegalArgumentException, IllegalAccessException {
		// Create a regex of the whois.value()
		
		String regex =  createParseRegex( whois );
		
		// Compile and load a matcher
		Pattern pattern = Pattern.compile( regex );
		Matcher matcher = pattern.matcher( sourceData );

		Object val = null;
		if ( whois.isList() ) {
			// Parse and load a list
			List<String> results = new ArrayList<String>(); 
			while (matcher.find()) {
			  results.add( matcher.group(1) );
			}
			val = results;
		} else {
			// Parse a simple value
			String result = null;
			while (matcher.find()) {
			  result = matcher.group(1);
			  break;
			}
			val = result;
		}
		
		// Set the value
		field.set(instance, val);
	}
	
	private String createParseRegex(Whois whois) {
		return ( whois.type() == Whois.WhoisParseType.REGEX ) 
					? whois.value()
					: whois.value() + "\\: (.*)";
	}

	/** 
	 * Teehee.. my notion of lightweight logging
	 * @param string
	 */
	private void log(String string) {
		System.out.println( string );	
	}
}
