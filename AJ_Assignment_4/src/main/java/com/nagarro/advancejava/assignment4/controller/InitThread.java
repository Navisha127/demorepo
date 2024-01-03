package com.nagarro.advancejava.assignment4.controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nagarro.advancejava.assignment4.dao.ModificationWatcher;

@WebListener
public class InitThread implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("server destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Server started..");
//		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//		service.scheduleAtFixedRate(new ModificationWatcher(), 0, 3, TimeUnit.SECONDS);
	}
}