<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" style="background-color: #9dd9b8;padding-top: 10px;  padding-bottom: 10px;">
		<h2 class="pageheading"><b><i>Administrative Dashboard</i></b></h2>
	</div>
	<div style="background-color: #cbff99; padding-bottom: 20px; padding-top: 10px;">
		<div align="center"padding: 50px;">

			<h2 class="pageheading"><b><i>Quick access:</i></b></h2>
			<a href="book_form.jsp" style="color: #2e3192;">New Book</a> &nbsp; <a
				href="user_form.jsp" style="color: #2e3192;">New User</a> &nbsp; <a
				href="category_form.jsp" style="color: #2e3192;">New Category</a>
			&nbsp; <a href="customer_form.jsp" style="color: #2e3192;">New
				Customer</a> &nbsp;
		</div>
		<div align="center"padding: 50px;">
			<h2 class="pageheading"><b><i>Recent Sales:</i></b></h2>
			<table>
				<tr>
					<th>Index</th>
					<th>Order ID</th>
					<th>Order BY</th>
					<th>Book Copies</th>
					<th>Total</th>
					<th>PaymentMethod</th>
					<th>Status</th>
					<th>Order Date</th>
				</tr>
				<c:forEach var="order" items="${listMostRecentsells}"
					varStatus="status">
					<tr>
						<td><a style="color: blue;"
							href="view_order?id=${order.orderId}">${status.index + 1}</a></td>
						<td>${order.orderId}</td>
						<td>${order.customer.fullname}</td>
						<td align="center">${order.bookCopies}</td>
						<td>Tk. ${order.total}</td>
						<td>${order.paymentMethod}</td>
						<td>${order.status}</td>
						<td><fmt:formatDate pattern='MM/dd/yyyy'
								value='${order.orderDate}' /></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<div align="center">

			<h2 class="pageheading"><b><i>Recent Reviews</i></b></h2>
			<table>
				<tr>
					<th>Index</th>
					<th>ID</th>
					<th>Book</th>
					<th>Rating</th>
					<th>Headline</th>
					<th>Customer</th>
					<th>Review On</th>

				</tr>
				<c:forEach var="review" items="${listMostrecentReviews}"
					varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${review.reviewId}</td>
						<td>${review.book.title}</td>
						<td align="center">${review.rating}</td>
						<td><a style="color: blue;"
							href="edit_review?id=${review.reviewId}">${review.headline}</a></td>
						<td>${review.customer.fullname}</td>
						<td><fmt:formatDate pattern='MM/dd/yyyy'
								value='${review.reviewTime}' /></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div align="center">
			<h2 class="pageheading"><b><i>Statistics</i></b></h2>
			Total Users:${totallUser} &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
			Total Books:${totallBook} &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;  
			Total Customers:${totallCustomer} &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
			&nbsp; Total Orders:${totallOrder} &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
			&nbsp; Total Reviews:${totallReviews} &nbsp;&nbsp; &nbsp; &nbsp; 
			&nbsp; &nbsp; &nbsp; 
			<hr width="50%">


		</div>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>