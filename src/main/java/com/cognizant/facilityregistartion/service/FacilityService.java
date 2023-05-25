package com.cognizant.facilityregistartion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.facilityregistartion.model.Facility;

public interface FacilityService {
	
	public List<Facility> getAllFacility();
	public Facility saveFacility(Facility facility) ;
    public Facility updateFacility(Facility facility);
    public String findFacStatus(int id);
}
