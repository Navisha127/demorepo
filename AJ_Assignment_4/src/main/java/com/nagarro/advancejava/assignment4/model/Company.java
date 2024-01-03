package com.nagarro.advancejava.assignment4.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Company {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	
	@OneToMany (mappedBy="company", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Tshirt> tshirt_details;
	
	private long lmt;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Tshirt> getTshirt_details() {
		return tshirt_details;
	}

	public void setTshirt_details(List<Tshirt> tshirt_details) {
		this.tshirt_details = tshirt_details;
	}

	public long getLmt() {
		return lmt;
	}

	public void setLmt(long lmt) {
		this.lmt = lmt;
	}

	
}
