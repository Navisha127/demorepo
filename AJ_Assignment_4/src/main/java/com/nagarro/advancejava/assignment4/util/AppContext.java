package com.nagarro.advancejava.assignment4.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {

	 public static AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

}
