<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<c:if test="${user != null }">
			<h2  class="pageheading">Update User</h2>
		</c:if>
		<c:if test="${user == null}">
			<h2  class="pageheading">Create New User</h2>
		</c:if>

	</div>
	<div align="center">
		<c:if test="${user != null }">
			<form action="update_user" method="post" id="userform">
				<input type="hidden" name="userId" value="${user.userId}">
		</c:if>
		<c:if test="${user == null}">
			<form action="create_user" method="post" id="userform">
		</c:if>
		<table class="from">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="email" name="email" id="email"
					value="${user.email}"></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" name="fullname"
					id="fullname" value="${user.fullname}"></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" name="password"
					id="password" value="${user.password}"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				&nbsp;&nbsp;<button type="submit">register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="cancelbutton">cancel</button>
				</td>
			</tr>
		</table>
	
		</form>
		
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
   
    $(document).ready(function(){
    	$("#userform").validate({
    		rules: {
    			email: {
    				required: true,
    				email: true
    			},
    				fullname: "required",
    					password: "required",
    		},
    		messages: {
    			email: {
    				required: "please enter your email",
    				email: "please enter a valid email address"
    			},
    			fullname: "please enter your fullname",
    			password: "please enter your password",
    		
    		}
    	});
    	$("#cancelbutton").click(function(){
    		history.go(-1);
    	});
    });
    
</script>
</html>