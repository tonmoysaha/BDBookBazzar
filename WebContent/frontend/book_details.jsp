<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title}-details</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
	
		<table width="80%" style="border: 0;">
			<tr>
				<td align="left" colspan="3">
					<h2>${book.title}</h2>
					<h3>${book.author}</h3>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
				<img src="data:image/jpg;base64,${book.base64Image}"
					width="128" height="164">
				</td>
			
				<td valign="top" align="left">
				Rating *****
				</td>
				
				<td valign="top" rowspan="2" width="20%">
				${book.price}
				 <br />
				<button type="submit">Add to cart</button>
				</td>
			</tr>
			
			<tr>
				<td valign="top" style="text-align: justify;">
				${book.description}</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			</tr>
			
			<tr>
			<td><h2>Customer Reviews</h2></td>
			
			<td colspan="2" align="center">
			
			<button type="submit" >Write a Customer Review</button>
			
			</td>
			</tr>
			
		</table>

	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>