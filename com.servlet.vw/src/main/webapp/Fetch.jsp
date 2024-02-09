<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "com.servlet.encapsulated.Volkswagenentity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch</title>
</head>
<body>
<style>
body{
	background-image: url();
  	background-repeat: no-repeat;
 	background-attachment: fixed;
  	background-size: cover; 
}
th,td{
        border: 4px solid black;
        padding: 10px;
    }
img{
width: 55%;
}     
</style>
<h2>
The Fetched Details of Volkswagen Models in Database are as Follows
</h2>
<img src= "https://imageio.forbes.com/specials-images/imageserve/5cd9d73c5218470008b09ab5/0x0.jpg?format=jpg&crop=416,416,x0,y0,safe&height=87&width=87.jpg" alt="volkswagen" align="right";">
<table>
<%
Object obj = session.getAttribute("details");
if(obj == null){
	out.print("No records found :");
}else{
	List<Volkswagenentity> entity = (ArrayList<Volkswagenentity>) obj;	
%>
<tr>
<th>ModelName: </th><th>Price: </th><th>FuelType:</th><th>Safety Rating: </th></tr>

<%
for(Volkswagenentity a : entity){
%>
<tr>
<td><%=a.getModelName() %></td><td><%=a.getPrice() %></td><td><%= a.getFueltype() %></td><td><%=a.getSafetyrating() %></td></tr>
<% } } %>
<br>
<tr><td><button><a href="Index.html">Back to Homepage</a></button></td></tr>
</table>
</body>
</html>