package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.encapsulated.Volkswagenentity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class VwData extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public VwData() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("Vwobject");
		Volkswagenentity volkswagen = null;
		if(obj!=null) {
			volkswagen = (Volkswagenentity)obj;
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/VwServlet"); 
		session.setAttribute("VwData", rd);
		PrintWriter out = response.getWriter();
		out.print("<html><body><table>");
		out.print("<button>");
		out.print("<a href = 'VwServlet'>Data</a>");
		out.print("</button>");
		out.print("</table></body><html>");
	}
	
	

}
