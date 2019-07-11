<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<img alt="customer" src="images/customer.png"><br>
		<h2>Customer Login</h2>
	</div>
	<div align="center">
		<h2 class="errormsg">${message}</h2>
	</div>
	<div align="center">
		<form action="login" method="post" id="loginForm">
			<table class="from">
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" id="email" ,size="40"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password"
						,size="40"></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button type="submit">Login</button>
					</td>
				</tr>

			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginForm").validate({
			rules : {
				email : {
					required : true,
					email : true
				},
				password : "required",
			},
			messages : {
				email : {
					required : "please enter your email",
					email : "please enter a valid email address"
				},
				password : "please enter your password",

			}
		});
	});
</script>
</html>
