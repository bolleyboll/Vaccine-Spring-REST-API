package com.example.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vaccine")
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccId;
	private String name;
	private String disease;
	private Integer orgId;

	public Vaccine() {
	}

	public Vaccine(Integer vaccId, String name, String disease, Integer orgId) {
		this.vaccId = vaccId;
		this.name = name;
		this.disease = disease;
		this.orgId = orgId;
	}

	public Integer getVaccId() {
		return vaccId;
	}

	public void setVaccId(Integer vaccId) {
		this.vaccId = vaccId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Override
	public String toString() {
		return "Vaccine [disease=" + disease + ", name=" + name + ", orgId=" + orgId + ", vaccId=" + vaccId + "]";
	}
}
