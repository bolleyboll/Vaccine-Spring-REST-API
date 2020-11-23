package com.example.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vaccines")
public class Vaccine {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vacId;
	private String vacName;
	private String disease;
	private Integer orgId;

	public Vaccine() {

	}

	public Vaccine(Integer vacId, String vacName, String disease, Integer orgId) {
		this.vacId = vacId;
		this.vacName = vacName;
		this.disease = disease;
		this.orgId = orgId;
	}

	public Integer getVacId() {
		return vacId;
	}

	public void setVacId(Integer vacId) {
		this.vacId = vacId;
	}

	public String getVacName() {
		return vacName;
	}

	public void setVacName(String vacName) {
		this.vacName = vacName;
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
		return "Vaccine [vacId=" + vacId + ", vacName=" + vacName + ", disease=" + disease + ", orgId=" + orgId + "]";
	}
}
