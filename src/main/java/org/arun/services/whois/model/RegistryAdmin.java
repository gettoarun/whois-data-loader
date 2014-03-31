package org.arun.services.whois.model;

import java.io.Serializable;

import org.arun.services.whois.model.meta.Whois;

public class RegistryAdmin  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Whois("Registry Admin ID")		private String id;
	@Whois("Admin Name")			private String name;
	@Whois("Admin Organization")	private String organization;
	@Whois("Admin Street")			private String street;
	@Whois("Admin City")			private String city;
	@Whois("Admin State/Province")	private String state;
	@Whois("Admin Postal Code")		private String postalCode;
	@Whois("Admin Country")			private String country;
	@Whois("Admin Phone")			private String phone;
	@Whois("Admin Phone Ext")		private String phoneExtension;
	@Whois("Admin Fax")				private String fax;
	@Whois("Admin Fax Ext")			private String faxExtension;
	@Whois("Admin Email")			private String email;
	
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