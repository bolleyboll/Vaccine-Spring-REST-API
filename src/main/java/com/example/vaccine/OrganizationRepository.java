package com.example.vaccine;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
	Organization findByEmailAndPassword(String email, String password);
	
	Organization findByOrgId(Integer orgId);
}
