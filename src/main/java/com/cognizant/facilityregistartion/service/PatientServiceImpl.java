package com.cognizant.facilityregistartion.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.facilityregistartion.model.Patient;
import com.cognizant.facilityregistartion.repository.ClinicRepo;
import com.cognizant.facilityregistartion.repository.FacilityRepo;
import com.cognizant.facilityregistartion.repository.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepo patientRepo;

	@Autowired
	private ClinicRepo clinicRepo;

	@Autowired
	private FacilityRepo facilityRepo;

	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Override
	public List<Patient> getAllPatient() {
		return patientRepo.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public ResponseEntity<Patient> updatePatient(Patient patient) {
		int patId = patient.getId();
		Optional<Patient> patient1 = patientRepo.findById(patId);

		try {
			int clinicId = patientRepo.getClinicId(patId);
			int facilityId = clinicRepo.getFacilityId(clinicId);
			Patient patient2 = patient1.get();

			if (facilityRepo.findFacilityStatus(facilityId).equals("ACTIVATED")) {
				if (patient2.getVacType() == null
						|| patient2.getVacType().length() > 0 && patient2.getVacType().trim().isEmpty()) {

					return new ResponseEntity(patientRepo.save(patient), HttpStatus.OK);
				} else {
					return new ResponseEntity("Patient has been vaccinated.", HttpStatus.BAD_REQUEST);

				}
			} else {
				return new ResponseEntity("Facility is not activated.", HttpStatus.BAD_REQUEST);
			}
		} catch (NullPointerException e) {
			return new ResponseEntity("Patient is not registered under a particular clinic", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity("Some exception occured", HttpStatus.BAD_REQUEST);
		}

	}

}
