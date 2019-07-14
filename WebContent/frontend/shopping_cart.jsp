<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<img alt="customer" src="images/order.png"><br>
		<h2>Your Cart Details</h2>
	</div>
	<div align="center">
		<h2 class="errormsg">${message}</h2>
	</div>
	<div align="center">
		<c:set var="cart" value="${sessionScope['cart']}"></c:set>

		<c:if test="${cart.totalItems == 0}">
			<h2>There is no items in your cart</h2>
		</c:if>
		<c:if test="${cart.totalItems > 0}">
			<div>
				<form action="" method="post">
					<table>
						<tr>
							<th>No</th>
							<th>Book</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Sub Totall</th>
							<th><a href=""><b>Clear Cart</b></a></th>
						</tr>
						<c:forEach var="item" items="${cart.items}" varStatus="status">
							<td>${status.index + 1}</td>
							<td>${item.key.title}</td>
							<td></td>

						</c:forEach>
					</table>

				</form>
			</div>
		</c:if>
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
