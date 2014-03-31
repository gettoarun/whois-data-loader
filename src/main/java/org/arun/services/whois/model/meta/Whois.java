package org.arun.services.whois.model.meta;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) 
@Target(FIELD)
public @interface Whois {
	String value() default "";
	boolean isList() default false;
	WhoisParseType   type() default WhoisParseType.KEY;
	
	enum WhoisParseType {
		KEY,
		REGEX,
	}
}

