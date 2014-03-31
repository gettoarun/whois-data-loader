package org.arun.services.whois.model;

import java.io.Serializable;
import java.util.List;

import org.arun.services.whois.model.meta.Whois;

public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Whois("Registry Domain ID") private String id;
	@Whois("Domain Name")		 private String       domainName;
	@Whois("Updated Date")		 private String       updatedDate;
	@Whois("Creation Date")		 private String       createdDate;
	@Whois("Expiration Date")    private String       expirationDate;
	@Whois(value = "Domain Status", isList = true)	private List<String> statuses;
	@Whois(value = "Name Server"  , isList = true)	private List<String> nameServers;

	private Registrar  registrar;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public List<String> getNameServers() {
		return nameServers;
	}

	public void setNameServers(List<String> nameServers) {
		this.nameServers = nameServers;
	}

	public Registrar getRegistrar() {
		return registrar;
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}