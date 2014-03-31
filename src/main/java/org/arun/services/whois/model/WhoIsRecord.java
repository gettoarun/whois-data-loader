package org.arun.services.whois.model;

import static org.arun.services.whois.model.meta.Whois.WhoisParseType.REGEX;

import java.io.Serializable;

import org.arun.services.whois.model.meta.Whois;

public class WhoIsRecord  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Whois(value="\\[Querying (.*)\\]", type=REGEX)	private String  source;
	@Whois(value="<<\n(.*)--\n", type=REGEX)	private String  notes;
	private Domain        domain;
	private Registrant    registrant;
	private RegistryAdmin registryAdmin;
	private RegistryTech  registryTech;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public Registrant getRegistrant() {
		return registrant;
	}
	public void setRegistrant(Registrant registrant) {
		this.registrant = registrant;
	}
	public RegistryAdmin getRegistryAdmin() {
		return registryAdmin;
	}
	public void setRegistryAdmin(RegistryAdmin registryAdmin) {
		this.registryAdmin = registryAdmin;
	}
	public RegistryTech getRegistryTech() {
		return registryTech;
	}
	public void setRegistryTech(RegistryTech registryTech) {
		this.registryTech = registryTech;
	}
}