<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Profile</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<br>
		<h2>Welcome, ${loggedcustomer.fullname}</h2>
		<br>
		<table class="normal" >
			<tr>
				<td><b>E-mail Address:</b></td>
				<td>${loggedcustomer.email}</td>
			</tr>
			<tr>
				<td><b>Full Name:</b></td>
				<td>${loggedcustomer.fullname}</td>
			</tr>
			<tr>
				<td><b>Phone Number:</b></td>
				<td>${loggedcustomer.phone}</td>
			</tr>
			<tr>
				<td><b>Address:</b></td>
				<td>${loggedcustomer.address}</td>
			</tr>
			<tr>
				<td><b>City:</b></td>
				<td>${loggedcustomer.city}</td>
			</tr>
			<tr>
				<td><b>Zip Code:</b></td>
				<td>${loggedcustomer.zipcode}</td>
			</tr>
			<tr>
				<td><b>Country:</b></td>
				<td>${loggedcustomer.country}</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<br>
			<tr>
			<td colspan="2" align="center"><a href="edit_profile">Update My profile</a></td>
			</tr>
			
		</table>
	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>