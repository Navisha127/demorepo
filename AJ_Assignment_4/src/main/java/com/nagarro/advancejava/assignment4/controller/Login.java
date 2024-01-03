package com.nagarro.advancejava.assignment4.controller;

import javax.validation.Valid;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advancejava.assignment4.dao.UserDao;
import com.nagarro.advancejava.assignment4.dao.UserDao;
import com.nagarro.advancejava.assignment4.model.LoginDetails;
import com.nagarro.advancejava.assignment4.model.User;
import com.nagarro.advancejava.assignment4.util.AppContext;

@Controller
@SessionAttributes("loginedUser")
public class Login {
	
	
	@RequestMapping(value ="/login" , method=RequestMethod.GET)
	public ModelAndView getlogin(){
		ModelAndView modelAndView = new ModelAndView("login") ;
		return modelAndView ;
	}
	
	@RequestMapping(value ="/login" , method=RequestMethod.POST)
	public ModelAndView provideLogin(@Valid @ModelAttribute("loginDetails")LoginDetails loginDetails,BindingResult result){
		
		ModelAndView modelAndView = new ModelAndView("login") ;
		if(result.hasErrors())
		{
			return modelAndView ;
		}
		
		UserDao obj = (UserDao)AppContext.context.getBean("userDao");
		User user =  (User)obj.getUser(loginDetails.getUserName());
		if(user==null)
		{
			ObjectError error = new ObjectError("loginError", "No such User Exists");
			result.addError(error);
			modelAndView.addObject("InvalidationMsg", "No such User Exists");
			return modelAndView ;
		}
		else if (!user.getPassword().equals(loginDetails.getPassword()))
		{
			ObjectError error = new ObjectError("loginError", "Password is incorrect");
			result.addError(error);
			modelAndView.addObject("InvalidationMsg", "Password is incorrect");
			return modelAndView ;
		}
		
		
		modelAndView = new ModelAndView("redirect:tshirtSearch") ;
		modelAndView.addObject("loginedUser", user);
		return modelAndView ;
	}
}