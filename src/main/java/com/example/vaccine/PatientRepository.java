package com.example.vaccine;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	Patient findByEmailAndPassword(String email, String password);

	List<Patient> findByOrgId(Integer id);
	
	List<Patient> findByOrgIdAndDisease(Integer PatientId, String disease);

}
