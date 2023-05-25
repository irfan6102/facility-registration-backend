package com.cognizant.facilityregistartion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authorities2")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long auth_id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "id")
	private FacilityUser user;

	public Long getId() {
		return auth_id;
	}

	public void setId(Long id) {
		this.auth_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FacilityUser getUser() {
		return user;
	}

	public void setUser(FacilityUser user) {
		this.user = user;
	}

}
