package com.example.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "organizations")
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orgId;
	private String name;
	private String description;
	private String logo;
	private String password;
	private String email;

	public Organization() {
	}

	public Organization(Integer orgId, String name, String description, String logo, String password, String email) {
		this.orgId = orgId;
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.password = password;
		this.email = email;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Organization [description=" + description + ", email=" + email + ", logo=" + logo + ", name=" + name
				+ ", orgId=" + orgId + ", password=" + password + "]";
	}
}
