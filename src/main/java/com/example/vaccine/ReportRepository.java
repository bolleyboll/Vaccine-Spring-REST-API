package com.example.vaccine;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Integer> {

	List<Report> findAllByPatientId(Integer patientId);

}
