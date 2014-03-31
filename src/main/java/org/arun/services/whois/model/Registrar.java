package org.arun.services.whois.model;

import java.io.Serializable;

import org.arun.services.whois.model.meta.Whois;

public class Registrar  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Whois("Registrar")						private String name;
	@Whois("Registrar IANA ID")				private String ianaID;
	@Whois("Registrar Abuse Contact Email")	private String abuseContactEmail;
	@Whois("Registrar Abuse Contact Phone")	private String abuseContactPhone;
	@Whois("Registrar WHOIS Server")		private String whoisServer;
	@Whois("Registrar URL")					private String url;
	@Whois("Registrar Registration Expiration Date")	private String registrationExpirationDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIanaID() {
		return ianaID;
	}
	public void setIanaID(String ianaID) {
		this.ianaID = ianaID;
	}
	public String getAbuseContactEmail() {
		return abuseContactEmail;
	}
	public void setAbuseContactEmail(String abuseContactEmail) {
		this.abuseContactEmail = abuseContactEmail;
	}
	public String getAbuseContactPhone() {
		return abuseContactPhone;
	}
	public void setAbuseContactPhone(String abuseContactPhone) {
		this.abuseContactPhone = abuseContactPhone;
	}
	public String getWhoisServer() {
		return whoisServer;
	}
	public void setWhoisServer(String whoisServer) {
		this.whoisServer = whoisServer;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRegistrationExpirationDate() {
		return registrationExpirationDate;
	}
	public void setRegistrationExpirationDate(String registrationExpirationDate) {
		this.registrationExpirationDate = registrationExpirationDate;
	}
}