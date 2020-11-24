package com.example.vaccine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {
	@Query(value = "SELECT * FROM vaccine WHERE org_id = ?", nativeQuery = true)
	List<Vaccine> findByOrgId(Integer OrgId);
}
