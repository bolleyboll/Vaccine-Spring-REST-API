package com.example.vaccine;

import java.util.List;
import java.util.Optional;

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
	private OrganizationRepository orgRepository;

	@Autowired
	private VaccineRepository vacRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private HttpSession httpSession;

	public boolean orgValidate() {
		return (httpSession.getAttribute("orgId") == null) ? false : true;
	}

	public boolean patientValidate() {
		return (httpSession.getAttribute("patientId") == null) ? false : true;
	}

	@GetMapping("/partners")
	public List<Organization> getAllOrganizations() {
		return (List<Organization>) orgRepository.findAll();
	}

	@GetMapping("/vaccines")
	public List<Vaccine> getAllVaccines() {
		return (List<Vaccine>) vacRepository.findAll();
	}

	@PostMapping("/org/signup")
	public Organization orgSignUp(@RequestBody Organization org) {
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
		if (dbOrg != null && dbOrg.getEmail().equals(org.getEmail()) && dbOrg.getPassword().equals(org.getPassword())) {
			httpSession.setAttribute("orgId", dbOrg.getOrgId());
			return dbOrg;
		}
		return null;
	}

	@PutMapping("/org/update")
	public Organization updateOrganization(@RequestBody Organization org) {
		return (orgValidate()) ? orgRepository.save(org) : null;
	}

	@DeleteMapping("/org/delete/{id}")
	public Status deleteOrganization(@PathVariable Integer id) {
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

	@GetMapping("/org/profile/{id}")
	public Optional<Organization> getOrgById(@PathVariable int id) {
		return (orgValidate()) ? orgRepository.findById(id) : null;
	}

	@PostMapping("org/vac/add")
	public Vaccine addVaccine(@RequestBody Vaccine vacc) {
		return (orgValidate()) ? vacRepository.save(vacc) : null;
	}

	@GetMapping("/org/{id}/vaccine")
	public List<Vaccine> retriveAllVaccines(@PathVariable int id) {
		return (orgValidate()) ? vacRepository.findByOrgId(id) : null;
	}

	@PutMapping("/org/vaccine/update")
	public Vaccine updateVaccine(@RequestBody Vaccine vacc) {
		return (orgValidate()) ? vacRepository.save(vacc) : null;
	}

	@DeleteMapping("/org/vaccine/delete/{id}")
	public Status deleteVaccine(@PathVariable Integer id) {
		if (!orgValidate()) {
			return null;
		}
		try {
			vacRepository.deleteById(id);
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
		if (patient.getPatientId() != 0) {
			return patient;
		}

		return null;
	}

	@PostMapping("/pat/signin")
	public Patient patSignIn(@RequestBody Patient patient) {
		Patient dbPatient = patientRepository.findByEmailAndPassword(patient.getEmail(), patient.getPassword());
		if (dbPatient != null && dbPatient.getEmail().equals(patient.getEmail())
				&& dbPatient.getPassword().equals(patient.getPassword())) {
			httpSession.setAttribute("patientId", dbPatient.getPatientId());
			return dbPatient;
		}
		return null;
	}

	@GetMapping("/pat")
	public List<Patient> getPatients() {
		return (orgValidate()) ? (List<Patient>) patientRepository.findAll() : null;
	}

	@PutMapping("/pat/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		return (patientValidate()) ? patientRepository.save(patient) : null;
	}

	@DeleteMapping("/pat/delete/{id}")
	public Status deletePatient(@PathVariable Integer id) {
		if (!patientValidate()) {
			return null;
		}
		try {
			patientRepository.deleteById(id);
			return new Status(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Status(false);
		}
	}

	@PostMapping("/rep/add")
	public Report addReport(@RequestBody Report report) {

		return (orgValidate()) ? reportRepository.save(report) : null;
	}

	@PutMapping("/rep/update")
	public Report updateReport(@RequestBody Report report) {
		return (orgValidate()) ? reportRepository.save(report) : null;

	}

	@DeleteMapping("/rep/delete/{id}")
	public Status deleteReport(@PathVariable Integer id) {
		if (!orgValidate()) {
			return null;
		}
		try {
			reportRepository.deleteById(id);
			return new Status(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Status(false);
		}
	}

	@GetMapping("/pat/{id}/rep")
	public List<Report> getReportByPatientId(@PathVariable int id) {
		return (patientValidate()) ? reportRepository.findReportByPatientId(id) : null;
	}

}
