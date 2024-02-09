package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.encapsulated.Volkswagenentity;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class VwServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public VwServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("Vwobject");
		Volkswagenentity volkswagen = null;
		if(obj!= null) {
			volkswagen = (Volkswagenentity) obj;
		}
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><body>");
		pw.print("<style>\r\n"
						+"body{\r\n"
						+ "		background-image: url('https://i.pinimg.com/736x/06/1b/d7/061bd722eb920b614a62fc9ff9ecd607.jpg');\r\n"
						+ "		background-repeat: no-repeat;\r\n"
						+ "		background-position: center bottom;\r\n"
						+ "		background-size:  60%;\r\n"
						+ "		background-attachment: fixed;\r\n"
						+ "		font-family: Arial, sans-serif;		\r\n"
						+ "		color: white;		\r\n"
						+ "		margin: 0;\r\n"
						+ "        padding: 0;\r\n"
						+ "	}\r\n"
						+ "	 th, td {\r\n"
						+ "        border: 3px solid black;\r\n"
						+ "        padding: 8px;\r\n"
						+ "        text-align: center;\r\n"
						+ "        text-color: black;\r\n"
						+ "    }\r\n"
						+ "table {\r\n"
						+ "            margin-top: 150px; \r\n"
						+ "            font-size:200%;"
						
						+ "            }\r\n"
						+ "            button{\r\n"
						+ "				 background-color: white ; color: black;\r\n"
						+ "				  border: none; border-radius: 10px;\r\n"
						+ "				  padding: 10px 20px;\r\n"
						+ "				  cursor: pointer;\r\n"
						+ "			}\r\n"
						+ "</style>");
		pw.print("<table align='center','font-size:200%,;'>");
		pw.print("<tr><th>ModelName: </th><th>Price: </th> <th>FuelType: </th> <th>SafetyRating: </th> </tr><br>");
		pw.print("<tr><td>"+volkswagen.getModelName()+"</td>");
		pw.print("<td>"+volkswagen.getPrice()+"</td>");
		pw.print("<td>"+volkswagen.getFueltype()+"</td>");
		pw.print("<td>"+volkswagen.getSafetyrating()+"</td></tr><br>");
		
		pw.print("<tr><td><button><a href ='Index.html'>Homepage</button</tr>");
		pw.print("</table></body></html>");
		
	}
}
