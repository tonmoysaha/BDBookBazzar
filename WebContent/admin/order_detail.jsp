<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderDetailManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="tabledataheading">
		<h2>Detail for Order ID: ${order.orderId }</h2>
		<img alt="reviews" src="../images/review.jpg" />
	</div>

	<c:if test="${massage != null}">
		<div align="center" style="background-color: #f9fece;">
			<h4 class="massage">${massage}</h4>
		</div>
	</c:if>

	<div align="center" class="tabledata">
		<h2>Order Overview</h2>
		<br>
		<table>
		
		<tr>
		<td>Order By: </td>
		<td>${order.customer.fullname}</td>
		</tr>
		
		<tr>
		<td>Book Copies: </td>
		<td>${order.bookCopies}</td>
		</tr>
		
		<tr>
		<td>Total Amount: </td>
		<td>Tk. ${order.total}</td>
		</tr>
		
		<tr>
		<td>Recipient Name: </td>
		<td>${order.recipientName}</td>
		</tr>
		<tr>
		
		<td>Recipient phone: </td>
		<td>${order.recipientPhone}</td>
		</tr>
		
		<tr>
		<td><b>Payment Method: </b></td>
		<td>${order.paymentMethod}</td>
		</tr>
		
		<tr>
		<td>Shipping Address: </td>
		<td>${order.shippingAddress}</td>
		</tr>
		
		<tr>
		<td>Order Status: </td>
		<td>${order.status}</td>
		</tr>
		
		<tr>
		<td>Order Date: </td>
		<td><fmt:formatDate pattern ='MM/dd/yyyy' value='${order.orderDate}'/></td>
		</tr>
		
		</table>
	</div>
	
	<div align="center" class="tabledata">
	<h2>Ordered Books</h2>
	<table>
	<tr>
	<th>Index</th>
	<th>Book Title</th>
	<th>Author</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Subtotal</th>
	</tr>
	
	<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status" >
	<tr>
	<td>${status.index + 1}</td>
	<td>
	<img style="vertical-align: middle;" src="data:image/jpg;base64,${orderDetail.book.base64Image}" width="45" height="64">
	${orderDetail.book.title}
	</td>
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
	<div align="center">
	<br>
	<a href="edit_order?id=${order.orderId}" style="color: black;">Edit The Order</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="delete_order?id=${order.orderId}"style="color: black;">Delete The Order</a>
	</div>
	</div>
	<jsp:directive.include file="footer.jsp" />
 <script type="text/javascript">
 $(document).ready(function(){
		$(".deletelink").each(function(){
			$(this).on("click",function(){
				reviewId =$(this).attr("id");
				if(confirm('Are you sure you want delete this Review with id: '+reviewId+'?'))
				{
				window.location='delete_review?id='+reviewId;
				}
						}); }); }); </script>
</body>

</html>