package com.nagarro.advancejava.assignment4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tshirt {

	@Id
	private String id;
	private String name;
	private String colour;
	private char gender_recommendation;
	private String size;
	private float price;
	private float rating;
	private char availability;
	
	@ManyToOne
	private Company company;

	public Tshirt() {
		
	}
	
	public Tshirt(String id, String name, String colour, char gender_recommendation, String size, float price, float rating,
			char availability, Company c) {

		this.id = id;
		this.name = name;
		this.colour = colour;
		this.gender_recommendation = gender_recommendation;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
		this.company = c;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public char getGender_recommendation() {
		return gender_recommendation;
	}
	public void setGender_recommendation(char gender_recommendation) {
		this.gender_recommendation = gender_recommendation;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public char getAvailability() {
		return availability;
	}
	public void setAvailability(char availability) {
		this.availability = availability;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Tshirt [id=" + id + ", name=" + name + ", colour=" + colour + ", gender_recommendation="
				+ gender_recommendation + ", size=" + size + ", price=" + price + ", rating=" + rating
				+ ", availability=" + availability + "]" + "\n";
	}	
}