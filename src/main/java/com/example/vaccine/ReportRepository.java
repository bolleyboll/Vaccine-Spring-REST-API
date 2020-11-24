package com.example.vaccine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Integer> {
	
	@Query(value = "SELECT * FROM reports WHERE patient_id = ?", nativeQuery = true)
	List<Report> findReportByPatientId(Integer patientId);
	

}
