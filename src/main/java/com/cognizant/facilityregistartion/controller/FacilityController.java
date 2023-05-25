package com.cognizant.facilityregistartion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.facilityregistartion.model.Facility;
import com.cognizant.facilityregistartion.repository.FacilityRepo;
import com.cognizant.facilityregistartion.service.FacilityServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/facility")
public class FacilityController {
	@Autowired
	private FacilityRepo repo;
	
	@Autowired
	private FacilityServiceImpl facilityImpl;
	
	
	
	@GetMapping("/getAllFacility")
	public List<Facility> getAllFacility(){
		return facilityImpl.getAllFacility();
	}
	
	@PostMapping("/saveFacility")
	public Facility saveFacility(@RequestBody Facility facility) {
		return facilityImpl.saveFacility(facility);
	}
    
	@PutMapping("/updateFacility")
	public Facility updateFacility(@RequestBody Facility facility) {
		return facilityImpl.updateFacility(facility);
	}
	
	@GetMapping("/getFacilityStatus/{id}")
	public String getFacStatus(@PathVariable("id") int id) {
		return facilityImpl.findFacStatus(id);
	}
}
