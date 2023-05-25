package com.cognizant.facilityregistartion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.facilityregistartion.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	
	@Query(value="select fk_clin_id_p from patient_details2 where id=:id",nativeQuery = true)
	public Integer getClinicId(@Param("id") int id);

}
