<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyOrders-BdbookBazzar</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="tabledataheading">
		<h2>My Order History</h2>
		<img alt="reviews" src="images/order.png" />
	</div>

	<c:if test="${fn:length(listOrders) ==0}">
	<div align="center">
		<h2>You Have not Placed Any Orders</h2>
	</div>
	</c:if>
	<c:if test="${fn:length(listOrders) > 0}">
		<div align="center" class="tabledata">
			<table border="1">
				<tr>
					<th>Index</th>
					<th>Order ID</th>
					<th>Quantity</th>
					<th>Total</th>
				    <th>Order Date</th>
					<th>Status</th>	
					<th>Action</th>

				</tr>
				<c:forEach var="order" items="${listOrders}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${order.orderId}</td>
						<td>${order.bookCopies}</td>
						<td>${order.total}</td>
						<td><fmt:formatDate pattern='MM/dd/yyyy' value='${order.orderDate}' /></td>
						<td>${order.status}</td>

						<td>
						<a href="show_order_detail?id=${order.orderId}"><button>View Details</button></a>	
					</tr>

				</c:forEach>

			</table>

		</div>
	</c:if>
	<jsp:directive.include file="footer.jsp" />
</body>

</html>