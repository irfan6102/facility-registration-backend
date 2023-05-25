package com.cognizant.facilityregistartion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.facilityregistartion.model.Patient;
import com.cognizant.facilityregistartion.repository.ClinicRepo;
import com.cognizant.facilityregistartion.repository.FacilityRepo;
import com.cognizant.facilityregistartion.repository.FacilityUserRepo;
import com.cognizant.facilityregistartion.repository.PatientRepo;
import com.cognizant.facilityregistartion.service.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@Autowired
	private ClinicRepo clinRepo;

	@Autowired
	private PatientRepo patRepo;

	private Patient patient;

	@GetMapping("/getAllPatient")
	public List<Patient> getAllPatient() {
		return patientServiceImpl.getAllPatient();
	}

	@PostMapping("/savePatient")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientServiceImpl.savePatient(patient);
	}

	@PutMapping("/updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
		return patientServiceImpl.updatePatient(patient);
	}
	
	@GetMapping("/getClinicId/{id}")
	public int getClinicId(@PathVariable("id") int id) {
		return patRepo.getClinicId(id);
	}
}
