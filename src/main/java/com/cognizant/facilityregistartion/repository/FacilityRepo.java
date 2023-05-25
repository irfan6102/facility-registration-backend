package com.cognizant.facilityregistartion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.facilityregistartion.model.Facility;

@Repository
public interface FacilityRepo extends JpaRepository<Facility, Integer> {
	  
	  @Query(value="select fac_status from facility_details3 where fac_id =:id", nativeQuery = true)
      String findFacilityStatus(int id);
}
