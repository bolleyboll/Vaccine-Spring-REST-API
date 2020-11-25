package com.example.vaccine;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {

	List<Vaccine> findAllByOrgId(Integer OrgId);
}
