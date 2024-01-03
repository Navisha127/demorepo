package com.nagarro.advancejava.assignment4.dao;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import com.nagarro.advancejava.assignment4.model.Company;
import com.nagarro.advancejava.assignment4.model.Tshirt;


public class FileReader {

	
	/**
	 * Method reads all data of single csv file. 
	 * @param file individual csv file.
	 */
	public static Company readFile(File file)
	{
		BufferedReader br = null;
		List<Tshirt> list = new ArrayList<>();
		Company c = new Company();
		c.setCompanyName(file.getName());
		try {
			br = new BufferedReader(new java.io.FileReader(file));
			br.readLine();
			String line = br.readLine();
			
			while(line != null) {
				Tshirt t = manipulateLine(line);
				t.setCompany(c);
				list.add(t);
				line = br.readLine();				
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			if(br != null) {
				try {
					br.close();
				} catch(Exception e) {
					System.out.println("Could not close the file");
				}
			}
		}
		c.setTshirt_details(list);
		c.setLmt(file.lastModified());
		return c;
	}
	
	/**
	 * break line and create tshirt.
	 * @param line single line of csv file
	 * @return tshirt object
	 */
	public static Tshirt manipulateLine(String line)
	{
		StringTokenizer st = new StringTokenizer(line, "|");
		String id = st.nextToken();
		String name = st.nextToken();
		String colour = st.nextToken();
		char gender = st.nextToken().charAt(0);
		String size = st.nextToken();
		float price = Float.parseFloat(st.nextToken());
		float rating = Float.parseFloat(st.nextToken());
		char availability = st.nextToken().charAt(0);
		
		return new Tshirt(id, name, colour, gender, size, price, rating, availability, null);
	}
}
