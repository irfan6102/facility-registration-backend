package com.cognizant.facilityregistartion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clinic_details3")
public class Clinic {

	@Id
	@Column(name = "clin_id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String clinicName;
	private int clinicStore;
	private String visitDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_clin_id_p", referencedColumnName = "clin_id")
	private List<Patient> patient1;
	
	

	public Clinic() {
		super();
	}

	public Clinic(int id, String clinicName, int clinicStore, String visitDate, List<Patient> patient) {
		super();
		this.id = id;
		this.clinicName = clinicName;
		this.clinicStore = clinicStore;
		this.visitDate = visitDate;
		this.patient1 = patient;
	}
	

	public List<Patient> getPatient() {
		return patient1;
	}

	public void setPatient(List<Patient> patient) {
		this.patient1 = patient;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public int getClinicStore() {
		return clinicStore;
	}

	public void setClinicStore(int clinicStore) {
		this.clinicStore = clinicStore;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

}
