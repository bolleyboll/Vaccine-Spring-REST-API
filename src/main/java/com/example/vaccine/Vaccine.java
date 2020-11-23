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

	public Integer getvaccId() {
		return vaccId;
	}

	public void setvaccId(Integer vaccId) {
		this.vaccId = vaccId;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
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
		return "Vaccine [vaccId=" + vaccId + ", name=" + name + ", disease=" + disease + ", orgId=" + orgId + "]";
	}
}
