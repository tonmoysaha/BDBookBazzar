<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ReviewPostedPage</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center" style="background-color: #d199a5;">
		
			<table class="normal" width="60%">
				<tr>
					<td><h2>Write Review</h2></td>
					<td>&nbsp;</td>
					<td><h2>${loggedcustomer.fullname}</h2></td>
				</tr>
				<tr>
					<td colspan="3"><hr></td>
				</tr>
				<tr>
					<td><span class="book-title">${book.title}</span> <br> <br>
						<img src="data:image/jpg;base64,${book.base64Image}" width="128"
						height="164"></td>
					<td colspan="2">
					<h3>Your review has been posted.Thank you!</h3>
					</td>
				</tr>

			</table>
	
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>

</html>