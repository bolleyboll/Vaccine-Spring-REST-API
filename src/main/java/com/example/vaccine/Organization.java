package com.example.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "organization")
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orgId;
	private String orgName;
	private String description;
	private String logo;
	private String password;
	private String email;

	public Organization() {

	}

	public Organization(Integer orgId, String orgName, String description, String logo, String email, String password) {
		this.orgId = orgId;
		this.orgName = orgName;
		this.description = description;
		this.logo = logo;
		this.email = email;
		this.password = password;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgName=" + orgName + ", description=" + description + ", logo="
				+ logo + ", password=" + password + ", email=" + email + "]";
	}
}
