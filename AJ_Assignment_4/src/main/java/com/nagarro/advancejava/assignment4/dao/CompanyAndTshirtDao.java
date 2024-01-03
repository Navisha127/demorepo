package com.nagarro.advancejava.assignment4.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nagarro.advancejava.assignment4.model.Company;
import com.nagarro.advancejava.assignment4.model.Tshirt;

public class CompanyAndTshirtDao {

	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}
	
	public void saveCompany(Company c){
		Session session=template.getSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(c);
	    session.getTransaction().commit();
	    session.close();
	}
	
	public List<Company> getCompanies(){
		return template.loadAll(Company.class);
	}
	
	public List<Tshirt> getTshirts(){
		
		List<Tshirt> list = template.loadAll(Tshirt.class);
		return list;
	}
	
	public void deleteCompany(String companyName) {
		
		Session session=template.getSessionFactory().openSession();
	    session.beginTransaction();
	    
	    Query query = session.createQuery("from Company where name = :string");
		query.setParameter("string", companyName);
		Company c = (Company)query.uniqueResult();
		c = (Company) session.load(Company.class, c.getCompanyId());
		session.delete(c);
		
	    session.getTransaction().commit();
	    session.close();
	    
	}
	
	public void updateCompany(Company company) {
		
		Session session=template.getSessionFactory().openSession();
	    session.beginTransaction();
	    
	    Query query = session.createQuery("from Company where name = :string");
		query.setParameter("string", company);
		Company c = (Company)query.uniqueResult();
		c = (Company) session.load(Company.class, c.getCompanyId());
		session.delete(c);
		session.save(c);
	    session.getTransaction().commit();
	    session.close();
	    
	}	
}
