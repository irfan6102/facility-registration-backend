package com.cognizant.facilityregistartion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.facilityregistartion.model.Clinic;
import com.cognizant.facilityregistartion.model.Facility;
import com.cognizant.facilityregistartion.repository.ClinicRepo;
import com.cognizant.facilityregistartion.repository.FacilityRepo;
import com.cognizant.facilityregistartion.service.ClinicServiceImpl;
import com.cognizant.facilityregistartion.service.FacilityServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clinic")
public class ClinicController {

	@Autowired
	private ClinicServiceImpl clinicSrvcImpl;

	@Autowired
	private FacilityServiceImpl facSrvcImpl;

	@Autowired
	private ClinicRepo clinRepo;

	@Autowired
	private FacilityRepo facRepo;

	private Optional<Facility> facility;

	@GetMapping("/getAllClinic")
	public ResponseEntity<Clinic> getAllClinic() {
		return clinicSrvcImpl.getAllClinic();
	}

	@PostMapping("/saveClinic")
	public ResponseEntity<Clinic> saveClinic(@RequestBody Clinic clinic) {
        return clinicSrvcImpl.saveClinic(clinic);
    }

	@GetMapping("/searchClinic/{clinicStore}")
	public Optional<Clinic> findClinic(@PathVariable("clinicStore") int clinicStore) {
		return clinicSrvcImpl.findByClinicStore(clinicStore);
	}

	@GetMapping("/searchByVisitDate/{visitDate}")
	public Optional<Clinic> findByVisitDate(@PathVariable("visitDate") String visitDate) {
		return clinicSrvcImpl.findByVisitDate(visitDate);
	}

	@GetMapping("/saerchByClinicAndVisitDate/{clinicStore}/{visitDate}")
	public ResponseEntity<Clinic> findByClinicStoreAndVisitDate(@PathVariable("clinicStore") int clinicStore,
			@PathVariable("visitDate") String visitDate) {
	   return clinicSrvcImpl.findByClinicStoreAndVisitDate(clinicStore, visitDate);
	}

//	@GetMapping("/getAllClinic1")
//	public int getAllClinic1( ){
//		return clinicSrvcImpl.getFacilityId(2);
//	}

}
