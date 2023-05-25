package com.cognizant.facilityregistartion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.facilityregistartion.model.Facility;
import com.cognizant.facilityregistartion.repository.FacilityRepo;

@Service
public class FacilityServiceImpl implements FacilityService {
	
	@Autowired
	private FacilityRepo facRepo;

	@Override
	public List<Facility> getAllFacility() {
		return facRepo.findAll();
	}

	@Override
	public Facility saveFacility(Facility facility) {
	return	facRepo.save(facility);
	}

	@Override
	public Facility updateFacility(Facility facility) {
		return facRepo.save(facility);
	}

	@Override
	public String findFacStatus(int id) {
		return facRepo.findFacilityStatus(id);
	}

}
