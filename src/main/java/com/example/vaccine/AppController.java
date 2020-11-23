package com.example.vaccine;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class AppController {

	@Autowired
	private OrganizationsRepository orgRepository;
	
	@Autowired
	private VaccinesRepository vacRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private HttpSession httpSession;
	
	public boolean orgValidate() {
		return (httpSession.getAttribute("orgId") == null) ? false : true;
	}
	public boolean validatePatient() {
		return (httpSession.getAttribute("patientId")==null) ? false : true;
}

	@PostMapping("/org/signup")
	public Organization signUp(@RequestBody Organization org) {
		try {
			org = orgRepository.save(org);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		if (org.getOrgId() != 0) {
			return org;
		}
		return null;
	}

	@PostMapping("/org/signin")
	public Organization signIn(@RequestBody Organization org) {
		Organization dbOrg = orgRepository.findByEmailAndPassword(org.getEmail(), org.getPassword());
		if (dbOrg != null && dbOrg.getEmail().equals(org.getEmail())
				&& dbOrg.getPassword().equals(org.getPassword())) {
			httpSession.setAttribute("orgId", dbOrg.getOrgId());
			return dbOrg;
		}
		return null;
	}
	
	@GetMapping("/org")
	public List<Organization> getOrganizations() {
		return (orgValidate()) ? (List<Organization>) orgRepository.findAll() : null;
	}

	@PutMapping("/org/update")
	public Organization updatePost(@RequestBody Organization org) {
		return (orgValidate()) ? orgRepository.save(org) : null;
	}
	
	@DeleteMapping("/org/delete/{id}")
	public Status deletePost(@PathVariable Integer id) {
		if (!orgValidate()) {
			return null;
		}
		try {
			orgRepository.deleteById(id);
			return new Status(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Status(false);
		}
	}
	@PostMapping("/pat/signup")
	public Patient patSignUp(@RequestBody Patient patient) {
		try {
			patient = patientRepository.save(patient);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		if(patient.getPatientId()!=0) {
			return patient;
		}
		
		return null;
	}
	
	@PostMapping("/pat/signin")
	public Patient patSignIn(@RequestBody Patient patient) {
		Patient dbPatient = patientRepository.findByEmailAndPassword(patient.getEmail(), patient.getPassword());
		if(dbPatient!=null && dbPatient.getEmail().equals(patient.getEmail()) && dbPatient.getPassword().equals(patient.getPassword())) {
			httpSession.setAttribute("patientId", dbPatient.getPatientId());
			return dbPatient;
		}
		return null;
	}
}
