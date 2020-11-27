package com.example.vaccine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {

	List<Vaccine> findAllByOrgId(Integer orgId);
	List<Vaccine> findAllByDisease(String disease);
	
	@Query(value="select distinct disease from vaccines", nativeQuery = true)
    List<String> findDistinctDisease();
}
