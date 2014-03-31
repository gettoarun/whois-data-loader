package org.arun.services.whois.model;

import java.io.Serializable;

import org.arun.services.whois.model.meta.Whois;

public class Registrant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Whois("Registry Registrant ID")		private String id;
	@Whois("Registrant Name")				private String name;
	@Whois("Registrant Organization")		private String organization;
	@Whois("Registrant Street")				private String street;
	@Whois("Registrant City")				private String city;
	@Whois("Registrant State/Province")		private String state;
	@Whois("Registrant Postal Code")		private String postalCode;
	@Whois("Registrant Country")			private String country;
	@Whois("Registrant Phone")				private String phone;
	@Whois("Registrant Phone Ext")			private String phoneExtension;
	@Whois("Registrant Fax")				private String fax;
	@Whois("Registrant Fax Ext")			private String faxExtension;
	@Whois("Registrant Email")				private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoneExtension() {
		return phoneExtension;
	}
	public void setPhoneExtension(String phoneExtension) {
		this.phoneExtension = phoneExtension;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFaxExtension() {
		return faxExtension;
	}
	public void setFaxExtension(String faxExtension) {
		this.faxExtension = faxExtension;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}