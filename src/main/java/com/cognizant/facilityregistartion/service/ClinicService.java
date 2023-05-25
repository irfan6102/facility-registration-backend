package com.cognizant.facilityregistartion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.facilityregistartion.model.Clinic;

public interface ClinicService {
	public ResponseEntity<Clinic> getAllClinic();
	public ResponseEntity<Clinic> saveClinic(Clinic clinic);
	public int getFacilityId(int id);
	public Optional<Clinic> findByClinicStore(int clinicStore);
	public Optional<Clinic> findByVisitDate(String visitDate);
	public 	ResponseEntity<Clinic> findByClinicStoreAndVisitDate(int clinicStore,String visitDate);

}
