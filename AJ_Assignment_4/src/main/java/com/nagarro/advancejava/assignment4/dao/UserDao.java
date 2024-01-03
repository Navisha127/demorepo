package com.nagarro.advancejava.assignment4.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nagarro.advancejava.assignment4.model.User;

public class UserDao {
	
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}
	
	public void saveUser(User user){  
	    Session session=template.getSessionFactory().openSession();
	    session.beginTransaction();
	    session.save(user);
	    session.getTransaction().commit();
	    session.close();
	} 
	
	public User getUser(String userName){
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) template.find("from User where userName="+ "'" + userName + "'" );
		if(listUser.isEmpty())
			return null ;
		return listUser.get(0) ;
	}
}