package com.cognizant.facilityregistartion.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.facilityregistartion.model.Clinic;
import com.cognizant.facilityregistartion.repository.ClinicRepo;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	private ClinicRepo clinicrepo;
	
	@Autowired
	private FacilityServiceImpl facSrvcImpl;
	
	private static final Logger logger=LoggerFactory.getLogger(ClinicServiceImpl.class);

	@Override
	public ResponseEntity<Clinic> getAllClinic() {
		if (clinicrepo.findAll().size() > 0) {
			return new ResponseEntity(clinicrepo.findAll(), HttpStatus.OK);
		} else {
			return new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Clinic> saveClinic(Clinic clinic) {
		  int clin_id= clinic.getId();
			int fac_id = clinicrepo.getFacilityId(clin_id);
			String fac_status = facSrvcImpl.findFacStatus(fac_id);

			if (fac_status.equals("ACTIVATED")) {
				return new ResponseEntity(clinicrepo.save(clinic), HttpStatus.CREATED);
			} else {
				return new ResponseEntity("Facility is not activated.", HttpStatus.BAD_REQUEST);
			}
	}

	@Override
	public int getFacilityId(int id) {
		return clinicrepo.getFacilityId(id);
	}

	@Override
	public Optional<Clinic> findByClinicStore(int clinicStore) {
		Optional<Clinic> clin = clinicrepo.findByClinicStore(clinicStore);
		Clinic cl = clin.get();
		return clinicrepo.findByClinicStore(clinicStore);
	}

	@Override
	public Optional<Clinic> findByVisitDate(String visitDate) {
		return clinicrepo.findByVisitDate(visitDate);
	}

	@Override
	public ResponseEntity<Clinic> findByClinicStoreAndVisitDate(int clinicStore, String visitDate) {
		if (clinicrepo.findByClinicStoreAndVisitDate(clinicStore, visitDate).isPresent()) {
			return new ResponseEntity(clinicrepo.findByClinicStoreAndVisitDate(clinicStore, visitDate),
					HttpStatus.OK);
		} else {
			return new ResponseEntity("No data found", HttpStatus.NOT_FOUND);
		}
	}

}
