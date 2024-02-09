package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.servlet.encapsulated.Volkswagenentity;
import com.servlet.implementation.Implementation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CreatereadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public CreatereadServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST method trigered");
		
		String modelName = request.getParameter("modelName");
		String price = request.getParameter("price");
		int id = 0;
		try {
			id = Integer.parseInt(price);
		}catch(Exception e) {
			id = 0;
		}
		String fueltype = request.getParameter("fueltype");
		
		String safetyrating = request.getParameter("safetyrating");
		int sr = 0;
		try {
			sr = Integer.parseInt(safetyrating);
		}catch(Exception e) {
			sr = 0;
		}
		
		
		Volkswagenentity volkswagen = new Volkswagenentity();
		volkswagen.setModelName(modelName);
		volkswagen.setPrice(id);
		volkswagen.setFueltype(fueltype);
		volkswagen.setSafetyrating(sr);
		
		
		Implementation imp = new Implementation();
		int result = imp.Insertmethod(volkswagen);
		
		HttpSession session = request.getSession();
		session.setAttribute("volkswagenInsert", volkswagen);
		
		RequestDispatcher success = request.getRequestDispatcher("Success.html");
		RequestDispatcher failed = request.getRequestDispatcher("Failure.html");
		
		if(result>0) {
			success.forward(request, response);
		}else {
			failed.forward(request, response);
		}
	}		
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("GET method Triggereed");
	
	String modelName = request.getParameter("modelName");
	
	Volkswagenentity volkswagen = new Volkswagenentity();
	volkswagen.setModelName(modelName);
	
	Implementation imp = new Implementation();
	Volkswagenentity entity = imp.Search(modelName);
	HttpSession session = request.getSession();
	session.setAttribute("Vwobject", entity);
	RequestDispatcher success = request.getRequestDispatcher("/VwServlet");
	RequestDispatcher failed = request.getRequestDispatcher("/Failure.html");
	if(entity!=null) {
		success.forward(request, response);
	}else {
		failed.forward(request, response);
	}
}
}
