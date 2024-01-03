package com.nagarro.advancejava.assignment4.controller;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advancejava.assignment4.dao.ModificationWatcher;
import com.nagarro.advancejava.assignment4.model.Tshirt;
import com.nagarro.advancejava.assignment4.model.TshirtDetailsInput;

@Controller
public class TshirtSearch {

	@RequestMapping(value ="/tshirtSearch" , method=RequestMethod.GET)
	public ModelAndView getTshirtSearch(){
		ModelAndView modelAndView = new ModelAndView("tshirtSearch");
		return modelAndView ;
	}
	
	@RequestMapping(value ="/tshirtSearch" , method=RequestMethod.POST)
	public ModelAndView tshirtSearch(@Valid @ModelAttribute("tshirtdetails")TshirtDetailsInput tshirtDetails,BindingResult result){
		
		System.out.println("search tshirt");
//		ModificationWatcher mw = new ModificationWatcher();
//		mw.checkUpdates();
		
		ModelAndView modelAndView =new ModelAndView("tshirtSearch");
		if(result.hasErrors())
		{ 
			System.err.println(result);
			return modelAndView ;
		}
		List<Tshirt> listOfMatchingTshirts = tshirtDetails.getListOfMatchingTshirts();
		System.out.println("**"+listOfMatchingTshirts.toString());
		modelAndView = new ModelAndView("tshirtList");
		modelAndView.addObject("list", listOfMatchingTshirts);
		return modelAndView ;
	}
}