<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<img alt="customer" src="images/order.png"><br>
		<h2>CheckOut Orders</h2>
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
				<h2>
					Review your Order Details <a href="view_cart">Edit</a>
				</h2>
				<table>
					<tr>
						<th>No</th>
						<th colspan="2">Book</th>
						<th>Author</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>SubTotall</th>

					</tr>
					<c:forEach var="item" items="${cart.items}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td><img src="data:image/jpg;base64,${item.key.base64Image}"
								width="128" height="164"></td>
							<td>${item.key.title}</td>
							<td>>${item.key.author}</td>
							<td>Tk. ${item.key.price}</td>
							<td>${item.value}</td>
							<!-- refer to quantity of the book -->
							<td>Tk. ${item.value * item.key.price}</td>

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
				<br>
				<form action="palce_order" method="post" id="orderForm">
					<table>
						<tr>
							<td>Recipient Name:</td>
							<td><input type="text" name="recipientfullname"
								value="${loggedcustomer.fullname}"></td>
						</tr>
						<tr>
							<td>Recipient phone:</td>
							<td><input type="text" name="recipientphone"
								value="${loggedcustomer.phone}"></td>
						</tr>
						<tr>
							<td>Street Addres</td>
							<td><input type="text" name="address"
								value="${loggedcustomer.address}"></td>
						</tr>
						<tr>
							<td>City</td>
							<td><input type="text" name="city"
								value="${loggedcustomer.city}"></td>
						</tr>
						<tr>
							<td>Zip Code</td>
							<td><input type="text" name="zipcode"
								value="${loggedcustomer.zipcode}"></td>
						</tr>
						<tr>
							<td>Contry</td>
							<td><input type="text" name="country"
								value="${loggedcustomer.country}"></td>
						</tr>

					</table>
					<div>
						<h2>Payment Method</h2>
						Choose your payment method: &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; <select
							name="paymentmethod">
							<option value="Cash on delivery">Cash On Delivery</option>
						</select>
					</div>
					<div>
						<table>
							<tr>
								<td></td>
								<td>
									<button type="submit">
										<b>Place Order</b>
									</button>
								</td>
								<td><a href="${pageContext.request.contextPath}/"><b>Continue
											Shoppingcart</b></a></td>
								
							</tr>
						</table>
					</div>
				</form>
			</div>


		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">

	$(document).ready(function() {

		$("#orderForm").validate({

			rules : {
				recipientfullname : "required",
				recipientphone : "required",
				address : "required",
				city : "required",
				zipcode : "required",
				country : "required",
			},
			messages: {
				recipientfullname : "please enter the recipient name",
				recipientphone : "please enter the recipient phone",
				address : "please enter the recipient address",
				city : "please enter the recipient city",
				zipcode : "please enter the recipient zipcode",
				country : "please enter the recipient country",
			}

		});
	});
</script>
</html>
