package com.cognizant.facilityregistartion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.facilityregistartion.model.Clinic;
import com.cognizant.facilityregistartion.model.FacilityUser;

@Repository
public interface ClinicRepo extends JpaRepository<Clinic, Integer> {
    
	
	Optional<Clinic> findByClinicStore(int clinicStore);
	Optional<Clinic> findByVisitDate(String visitDate);
	Optional<Clinic> findByClinicStoreAndVisitDate(int clinicStore,String visitDate);

//	
	@Query(value="select fk_fac_id from clinic_details3 where clin_id=:id",nativeQuery = true)
	public int getFacilityId(@Param("id") int id);
}
