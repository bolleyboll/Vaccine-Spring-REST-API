package com.example.vaccine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String symptoms;
	private String medicalHistory;
	private Integer vaccId;
	private Integer orgId;
	private String password;
	private String disease;
	private String profilePicture;
	private String dob;
	private String gender;

	public Patient() {
	}

	public Patient(Integer patientId, String name, String email, String phone, String address, String symptoms,
			String medicalHistory, Integer vaccId, Integer orgId, String password, String disease,
			String profilePicture, String dob, String gender) {
		this.patientId = patientId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.symptoms = symptoms;
		this.medicalHistory = medicalHistory;
		this.vaccId = vaccId;
		this.orgId = orgId;
		this.password = password;
		this.disease = disease;
		this.profilePicture = profilePicture;
		this.dob = dob;
		this.gender = gender;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Integer getVaccId() {
		return vaccId;
	}

	public void setVaccId(Integer vaccId) {
		this.vaccId = vaccId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	
}
