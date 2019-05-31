<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2>please login:</h2>
		<form action="">
			Email: <input type="email" size="15" placeholder="enter email"><br>
			Password: <input type="password" size="15"placeholder="enter password"><br> 
			<input type="submit"value="login">
		</form>
	</div>
	<jsp:directive.include file="footer.jsp"/>

</body>
</html>