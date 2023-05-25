package com.cognizant.facilityregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.facilityregistartion.model.FacilityUser;

@Repository
public interface FacilityUserRepo extends JpaRepository<FacilityUser, Integer> {
      
	List<FacilityUser> findByEmail(String email);
}
