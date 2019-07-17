<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form action="update_cart" method="post" id="cartForm">
				<div>
					<table>
						<tr>
							<th>No</th>
							<th colspan="2">Book</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Sub Totall</th>
							<th>Remove Items</th>
						</tr>
						<c:forEach var="item" items="${cart.items}" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td><img
									src="data:image/jpg;base64,${item.key.base64Image}" width="128"
									height="164"></td>
								<td>${item.key.title}</td>
								
								<td>
								<input type="hidden" name="bookId" value="${item.key.bookId}">
								<input type="text" name="quantity${status.index + 1}"
									value="${item.value}" size="5">
									</td>
								<!-- refer to quantity of the book -->
								<td>Tk. ${item.key.price}</td>
								<td>Tk. ${item.value * item.key.price}</td>
								<td style="color: blue;"><a style="color: blue;" href="remove_from_cart?book_id=${item.key.bookId}">Remove</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><b>${cart.totallQuantity} (Books)</b></td>
							<td><b>Totall:</b></td>
							<td><b>Tk. ${cart.totallAmount}</b></td>
						</tr>
					</table>
				</div>
				<div>
					<table>
						<tr>
							<td></td>
							<td><input type="submit" value="Update"></td>
							<td><input type="button" value="clear_cart" id="clearCart">
								<td><a href="${pageContext.request.contextPath}/"><b>Continue
										Shoppingcart</b></a></td>
							<td><a href="checkout"><b>Checkout</b></a></td>
						</tr>


					</table>


				</div>
			</form>

		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#clearCart").click(function(){
			window.location='clear_cart';
		});
		$("#cartForm").validate({
			rules : {
				<c:forEach var="item" items="${cart.items}" varStatus="status">
				quantity${status.index + 1}: { 
					required: true,
					number: true,
					min: 1
					},
				</c:forEach>
			},
			messages : {
				<c:forEach var="item" items="${cart.items}" varStatus="status">
				quantity${status.index + 1}: { 
					required: "please enter the quantity",
					number: "quantity must be number",
					min: "quaantity must be a greater than 0"
					},
				</c:forEach>

			}
		});
	});
</script></
							html>
