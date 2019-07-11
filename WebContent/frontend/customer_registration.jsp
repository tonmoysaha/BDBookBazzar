<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer-Registration</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2 class="pageheading">Customer Registration</h2>
	</div>
	<div align="center">
		
			<form action="register_customer" method="post" id="customerform">
			
		<table class="from">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="email" name="email" id="email" size="45"></td>
			</tr>
			<tr>
				<td align="right">Full Name:</td>
				<td align="left"><input type="text" name="fullname" id="fullname" size="45"></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" name="password"
					id="password" size="45"></td>
			</tr>
			<tr>
				<td align="right">Confirm Password:</td>
				<td align="left"><input type="password" name="confirmpassword"
					id="confirmpassword" size="45"></td>
			</tr>
			<tr>
				<td align="right">Phone Number:</td>
				<td align="left"><input type="text" name="phone"
					id="phone" size="45"></td>
			</tr>
			<tr>
				<td align="right">Address:</td>
				<td align="left"><input type="text" name="address"
					id="address" size = "45"></td>
			</tr>
			<tr>
				<td align="right">City:</td>
				<td align="left"><input type="text" name="city"
					id="city" size = "45" ></td>
			</tr>
			<tr>
				<td align="right">Zip Code:</td>
				<td align="left"><input type="text" name="zipcode"
					id="zipcode" size = "45"></td>
			</tr>
			<tr>
				<td align="right">Country:</td>
				<td align="left"><input type="text" name="country"
					id="country" size = "45" ></td>
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
    	$("#customerform").validate({
    		rules: {
    			email: {
    				required: true,
    				email: true
    			},
    				   fullname: "required",
    					password: "required",
    					confirmpassword: {
    						required: true,
    						equalTo: "#password"
    						
    					},
    					phone: "required",
    					address: "required",
    					city: "required",
    					zipcode: "required",
    					country: "required",
    		},
    		messages: {
    			email: {
    				required: "please enter your email",
    				email: "please enter a valid email address"
    			},
    			fullname: "please enter your Fullname",
    			password: "please enter your password",
    			
    			confirmpassword: {
    				required: "please Confirm Password",
    				equalTo: "Confirm Password does not match"
    			},
    			
				phone: "please enter your Phone Number",
				address: "please enter your Address",
				city: "please enter your City",
				zipcode: "please enter your Zip Code",
				country: "please enter your Country",
    		
    		}
    	});
    	$("#cancelbutton").click(function(){
    		history.go(-1);
    	});
    });
    
</script>
</html>