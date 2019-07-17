<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyOrderDetails-BdbookBazzar</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<c:if test="${order == null }">
	<div align="center">
	<h2>Sorry,You are not authorized to see this order.</h2>
	</div>
	</c:if>
	
	<c:if test="${order != null }">
	<div align="center" class="tabledataheading">
		<h2>Your Order: ${order.customer.fullname }</h2>
		<img alt="reviews" src="images/order.png" />
	</div>
   
	<div align="center" class="tabledata">
		<br>
		<table>

			<tr>
				<td>Order Status:</td>
				<td>${order.status}</td>
			</tr>

			<tr>
				<td>Order Date:</td>
				<td><fmt:formatDate pattern='MM/dd/yyyy'
						value='${order.orderDate}' /></td>
			</tr>

			<tr>
				<td>Quantity:</td>
				<td>${order.bookCopies}</td>
			</tr>

			<tr>
				<td>Total Amount:</td>
				<td>Tk. ${order.total}</td>
			</tr>

			<tr>
				<td>Recipient Name:</td>
				<td>${order.recipientName}</td>
			</tr>
			<tr>

				<td>Recipient phone:</td>
				<td>${order.recipientPhone}</td>
			</tr>

			<tr>
				<td>Shipping To:</td>
				<td>${order.shippingAddress}</td>
			</tr>

			<tr>
				<td><b>Payment Method: </b></td>
				<td>${order.paymentMethod}</td>
			</tr>

		</table>
	</div>

	<div align="center" class="tabledata">
		<h2>Ordered Books</h2>
		<table>
			<tr>
				<th>No</th>
				<th>Book</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</th>
			</tr>

			<c:forEach items="${order.orderDetails}" var="orderDetail"
				varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					
					<td>
					<img style="vertical-align: middle;" src="data:image/jpg;base64,${orderDetail.book.base64Image}" width="45" height="64">
					${orderDetail.book.title}</td>
					<td>${orderDetail.book.author}</td>
					<td>${orderDetail.book.price}</td>
					<td>${orderDetail.quantity}</td>
					<td>${orderDetail.subtotal}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right"><b><i>Total:</i></b></td>
				<td><b>${order.bookCopies}</b></td>
				<td><b>${order.total}</b></td>
			</tr>
		</table>

	</div>
	</c:if>
	<jsp:directive.include file="footer.jsp" />
</body>

</html>