package com.nagarro.advancejava.assignment4.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.nagarro.advancejava.assignment4.dao.CompanyAndTshirtDao;
import com.nagarro.advancejava.assignment4.model.Company;
import com.nagarro.advancejava.assignment4.model.Tshirt;
import com.nagarro.advancejava.assignment4.util.AppContext;

public class ModificationWatcher{

	/**
	 * @lastModifiedTime last modified time of csv file
	 */
	
	private HashMap<String, Long> lastModifiedTime = new HashMap<>();
	static CompanyAndTshirtDao tshirtDao = (CompanyAndTshirtDao) AppContext.context.getBean("tshirtDao");
	
	public ModificationWatcher(){
		List<Company> companies = tshirtDao.getCompanies();
		for(Company c : companies)
		{
			lastModifiedTime.put(c.getCompanyName(), c.getLmt());
		}
	} 
	
	//@tshirtDetails data of csv files
	
	public void checkUpdates() {
		
		/**
		 * @csvFilesName all csv file's name will be stored.
		 */
		
		File dir = new File("resources/");
		File files[] = dir.listFiles();
		
		HashSet<String> csvFilesName = new HashSet<>();
		
		if(files == null)
			System.out.println("null");
		else
			System.out.println("File length: " + files.length);
		
		for(File f : files)
		{
			/**
			 * If any File is being modified then read the data of that file again and change tshirt_details accordingly.
			 */
			if(!(lastModifiedTime.containsKey(f.getName())) || f.lastModified() > lastModifiedTime.get(f.getName())) {
				
				Company company = FileReader.readFile(f) ;
				
				if (!lastModifiedTime.containsKey(f.getName())) {	
					tshirtDao.saveCompany(company);
				}
				else {
					tshirtDao.updateCompany(company);
				}
				lastModifiedTime.put(f.getName(), f.lastModified());
			}
			csvFilesName.add(f.getName());
		}
		if(lastModifiedTime.size() == csvFilesName.size())
			return;
	
		/**
		 * Check any csv file is deleted, if yes then remove that from record (lastModifiedTime and tshirt_details). 
		 */
		for(String fname : lastModifiedTime.keySet())
		{
			if(!csvFilesName.contains(fname))
			{
				tshirtDao.deleteCompany(fname);
				lastModifiedTime.remove(fname);
			}
		}
	}
}