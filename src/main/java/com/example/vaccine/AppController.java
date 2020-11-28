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
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
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
		return (httpSession.getAttribute("orgId") != null) ? true : false;
	}

	public boolean patientValidate() {
		return (httpSession.getAttribute("patientId") != null) ? true : false;
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

	@GetMapping("/org/{id}")
	public Optional<Organization> getOrgById(@PathVariable int id) {
		return orgRepository.findById(id);
	}

	@GetMapping("/org/{id}/vaccines")
	public List<Vaccine> retriveAllOrgVaccines(@PathVariable int id) {
		return (orgValidate()) ? vacRepository.findAllByOrgId(id) : null;
	}

	@PostMapping("/vaccine/add")
	public Vaccine addVaccine(@RequestBody Vaccine vacc) {
		return (orgValidate()) ? vacRepository.save(vacc) : null;
	}

	@PutMapping("/vaccine/update")
	public Vaccine updateVaccine(@RequestBody Vaccine vacc) {
		return (orgValidate()) ? vacRepository.save(vacc) : null;
	}

	@DeleteMapping("/vaccine/delete/{id}")
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

	@PostMapping("/patient/signup")
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

	@PostMapping("/patient/signin")
	public Patient patSignIn(@RequestBody Patient patient) {
		Patient dbPatient = patientRepository.findByEmailAndPassword(patient.getEmail(), patient.getPassword());
		if (dbPatient != null && dbPatient.getEmail().equals(patient.getEmail())
				&& dbPatient.getPassword().equals(patient.getPassword())) {
			httpSession.setAttribute("patientId", dbPatient.getPatientId());
			return dbPatient;
		}
		return null;
	}

	@GetMapping("/unenrolledpatients")
	public List<Patient> getUnenrolledPatients() {
		return (orgValidate()) ? (List<Patient>) patientRepository.findByOrgId(null) : null;
	}

	@PutMapping("/patient/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		return (patientValidate() || orgValidate()) ? patientRepository.save(patient) : null;
	}

	@DeleteMapping("/patient/delete/{id}")
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

	@PostMapping("/report/add")
	public Report addReport(@RequestBody Report report) {

		return (orgValidate()) ? reportRepository.save(report) : null;
	}

	@PutMapping("/report/update")
	public Report updateReport(@RequestBody Report report) {
		return (orgValidate()) ? reportRepository.save(report) : null;

	}

	@DeleteMapping("/report/delete/{id}")
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

	@GetMapping("/patient/{id}/report")
	public List<Report> getReportByPatientId(@PathVariable int id) {
		return (patientValidate()) ? reportRepository.findAllByPatientId(id) : null;
	}

	@GetMapping("/vaccine/id/{id}")
	public Optional<Vaccine> findVaccineById(@PathVariable int id) {
		return vacRepository.findById(id);
	}

	@GetMapping("/report/{id}")
	public Optional<Report> findReportById(@PathVariable int id) {
		return reportRepository.findById(id);
	}

	@GetMapping("/vaccine/disease/{disease}")
	public List<Vaccine> findVaccineByDisease(@PathVariable String disease) {
		return (patientValidate() ? vacRepository.findAllByDisease(disease) : null);
	}
		
	@GetMapping("/distinct/disease")
	public List<String> getDistinctDisease()
	{
		List<String> diseases=vacRepository.findDistinctDisease();
		if(diseases !=null )
		{
			return diseases;
		}
			return null;
	}
	@GetMapping("/unenrolledpatients/{disease}")
	public List <Patient> finfPatientByDisease(@PathVariable String disease){
		return (orgValidate())? patientRepository.findByOrgIdAndDisease(null, disease):null;
	}
	
	@GetMapping("/patient/{id}")
	public Optional <Patient> findPatientById(@PathVariable Integer id){
		return (orgValidate() || patientValidate()) ? patientRepository.findById(id): null;
	}
	
}
