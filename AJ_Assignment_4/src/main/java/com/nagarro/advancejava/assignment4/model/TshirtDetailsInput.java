package com.nagarro.advancejava.assignment4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.nagarro.advancejava.assignment4.dao.CompanyAndTshirtDao;

public class TshirtDetailsInput {

	private String colour;
	private String size;
	private char gender;
	private String outputPreference;
	
	public TshirtDetailsInput(String colour, String size, char gender, String outputPreference) {
	
		this.colour = colour;
		this.size = size;
		this.gender = gender;
		this.outputPreference = outputPreference;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}

	@Override
	public String toString() {
		return "UserInput [colour=" + colour + ", size=" + size + ", gender=" + gender + ", outputPreference="
				+ outputPreference + "]";
	}
	
	public List<Tshirt> getListOfMatchingTshirts(){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyAndTshirtDao tshirtDao = (CompanyAndTshirtDao) context.getBean("tshirtDao");
		List<Tshirt> allTshirts =  tshirtDao.getTshirts();
		ArrayList<Tshirt> matchingTshirts = new ArrayList<Tshirt>();
		
		for(Tshirt t : allTshirts)
		{
			if(colour.toUpperCase().equals(t.getColour().toUpperCase()) && 
				   size.toUpperCase().equals(t.getSize().toUpperCase()) && 
				   (gender+"").toUpperCase().charAt(0) == t.getGender_recommendation())
			{
				matchingTshirts.add(t);
			}
		}
		
		if(outputPreference.toUpperCase().equals("PRICE"))
			Collections.sort(matchingTshirts, (Tshirt t1, Tshirt t2) -> Float.valueOf(t1.getPrice()).compareTo(Float.valueOf(t2.getPrice())));
		else if(outputPreference.toUpperCase().equals("RATING"))
			Collections.sort(matchingTshirts, (Tshirt t1, Tshirt t2) -> Float.valueOf(t2.getRating()).compareTo(Float.valueOf(t1.getRating())));
		
		return matchingTshirts;
	}
}
