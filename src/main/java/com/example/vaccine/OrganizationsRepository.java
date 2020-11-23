package com.example.vaccine;

import org.springframework.data.repository.CrudRepository;

public interface OrganizationsRepository extends CrudRepository<Organization, Integer> {
	Organization findByEmailAndPassword(String email, String password);

}
