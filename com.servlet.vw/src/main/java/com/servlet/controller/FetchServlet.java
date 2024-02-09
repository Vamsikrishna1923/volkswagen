package com.servlet.controller;

import java.io.IOException;
import java.util.List;

import com.servlet.encapsulated.Volkswagenentity;
import com.servlet.implementation.Implementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FetchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public FetchServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Get is Triggered");
		Implementation imp = new Implementation();
		List<Volkswagenentity> result = imp.Fetch();
		HttpSession session = request.getSession();
		session.setAttribute("details", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Fetch.jsp");
		try {
			rd.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
