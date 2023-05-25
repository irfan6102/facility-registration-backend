package com.cognizant.facilityregistartion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "facility_details3")
@DynamicInsert
public class Facility {

	@Id
	@Column(name = "fac_id")
	private int id;

	private String facilityName;
	private String facilityCity;
	private String state;
	private String streetLine1;
	private String streetLine2;
	private int zipcode;

	@ColumnDefault("'ACTIVATED'")
	@Column(name = "fac_status")
	private String fac_status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_fac_id", referencedColumnName = "fac_id")
	private List<Clinic> clinic;

	
	
	

	public Facility(int id, String facilityName, String facilityCity, String state, String streetLine1,
			String streetLine2, int zipcode, String fac_status, List<Clinic> clinic) {
		super();
		this.id = id;
		this.facilityName = facilityName;
		this.facilityCity = facilityCity;
		this.state = state;
		this.streetLine1 = streetLine1;
		this.streetLine2 = streetLine2;
		this.zipcode = zipcode;
		this.fac_status = fac_status;
		this.clinic = clinic;
	}

	public String getFac_status() {
		return fac_status;
	}

	public void setFac_status(String fac_status) {
		this.fac_status = fac_status;
	}


	public String getStatus() {
		return fac_status;
	}

	public void setStatus(String status) {
		this.fac_status = status;
	}

	public Facility() {
		super();
	}

	public List<Clinic> getClinic() {
		return clinic;
	}

	public void setClinic(List<Clinic> clinic) {
		this.clinic = clinic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityCity() {
		return facilityCity;
	}

	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetLine1() {
		return streetLine1;
	}

	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}

	public String getStreetLine2() {
		return streetLine2;
	}

	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
