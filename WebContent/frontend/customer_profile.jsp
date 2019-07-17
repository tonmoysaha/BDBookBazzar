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
	<div align="center" class="tabledataheading">
		<h2>
			<b><i>Welcome, ${loggedcustomer.fullname}</i></b>
		</h2>
		<img src="images/Profile-logo.png">
	</div>
	<div align="center"
		style="padding-bottom: 10px; background-color: #87CEFA;">
		<br>


		<table class="normal">
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
				<br>
			<tr>
				<td><a style="color: blue; margin-left: 100px;"
					href="edit_profile"><b><i>Update My profile</i></b></a></td>
			</tr>

		</table>
	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>