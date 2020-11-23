package com.example.vaccine;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	Patient findByEmailAndPassword(String email,String password);

}
