package com.example.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	private String description;
	private String result;
	private Integer orgId;
	private Integer patientId;
	private Integer vaccId;
	public Report() {
		
	}
	public Report(Integer reportId, String description, String result, Integer orgId, Integer patientId,
			Integer vacId) {
		this.reportId = reportId;
		this.description = description;
		this.result = result;
		this.orgId = orgId;
		this.patientId = patientId;
		this.vaccId= vacId;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getVacId() {
		return vaccId;
	}
	public void setVacId(Integer vacId) {
		this.vaccId= vacId;
	}
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", description=" + description + ", result=" + result + ", orgId="
				+ orgId + ", patientId=" + patientId + ", vacId=" + vaccId+ "]";
	}
	

}
