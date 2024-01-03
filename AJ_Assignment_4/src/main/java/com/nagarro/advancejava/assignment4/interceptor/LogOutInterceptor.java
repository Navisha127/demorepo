package com.nagarro.advancejava.assignment4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nagarro.advancejava.assignment4.model.User;

public class LogOutInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session  =  request.getSession() ;
		User user = (User) session.getAttribute("loginedUser");
		if(user!=null)
		{	
			response.sendRedirect("tshirtSearch");
			return false ;
		}
		return true;
	}
}