<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
    <div class="wholeloginpage">
	<div align="center" style="background-color: black;">
		<img alt="admin" src="../images/BookstoreAdminLogo.png">
	</div>
	
	<div class="loginheading">
	    <div align="center">
		<h1>BookBazzar Administration</h1>
	   </div>
		<img alt="admin" src="../images/employee.jpg" width="70" height="60"><br>
		<h2>Admin Login</h2>
	</div>
	<div align="center">
		<h2 class="errormsg">${message}</h2>
	</div>
	<div align="center" class="loginpage">
		<form action="login" method="post" id="loginForm">
			<table class="login">
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" id="email" ,size="20"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password"
						,size="20"></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button type="submit">Login</button>
					</td>
				</tr>

			</table>
		</form>
	</div>
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
