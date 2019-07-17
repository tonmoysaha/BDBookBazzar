<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BdBookBazzar</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center"
		style="background-color: #f1fc90; padding-top: 5px; padding-bottom: 5px;">
		<div align="center" style="width: 80%; margin: 0 auto;">
			<div>
				<h2>New Books</h2>
			</div>
			<c:forEach items="${listNewBooks}" var="book">
			
			<jsp:directive.include file="book_group.jsp"/>
			
			</c:forEach>
		</div>

		<div>
			<h2>Best-Selling Books</h2>
			<br>
			<c:forEach items="${listbestSellingBooks}" var="book">
			
				<jsp:directive.include file="book_group.jsp"/>
				
			</c:forEach>

		</div>
		
		<div align="center" style="width: 80%; margin: 0 auto;">
			<h2>Most-Favoured Books</h2>
			<br>
			<c:forEach items="${listMostFavouredBooks}" var="book">
			
				<jsp:directive.include file="book_group.jsp"/>
				
			</c:forEach>
		</div>


	</div>




	<jsp:directive.include file="footer.jsp" />
</body>
</html>