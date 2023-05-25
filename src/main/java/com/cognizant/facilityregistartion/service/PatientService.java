package com.cognizant.facilityregistartion.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.facilityregistartion.model.Patient;

public interface PatientService {
	
	public List<Patient> getAllPatient();
	public Patient savePatient(Patient patient);
	public ResponseEntity<Patient> updatePatient(Patient patient);

}
