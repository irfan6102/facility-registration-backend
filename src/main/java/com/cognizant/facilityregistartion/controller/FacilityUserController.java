package com.cognizant.facilityregistartion.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.facilityregistartion.model.FacilityUser;
import com.cognizant.facilityregistartion.repository.FacilityRepo;
import com.cognizant.facilityregistartion.repository.FacilityUserRepo;

@RestController
public class FacilityUserController {
	
	@Autowired
	private FacilityUserRepo facRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/getAllUser")
	public List<FacilityUser> getAllUser(){
		return facRepo.findAll();
	}
	
	@PostMapping("/saveUser")
	public FacilityUser saveUser(@RequestBody FacilityUser user) {
		String hashPwd=passwordEncoder.encode(user.getPwd());
		user.setPwd(hashPwd);
		return facRepo.save(user);
	}
	
//  @GetMapping("/hello")
//  public String helloMsg() {
//	  return "Hello from facilityController";
//	  }
	

}
