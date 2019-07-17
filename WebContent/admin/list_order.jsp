<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrdersManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="tabledataheading">
		<h2>Order Management</h2>
		<img alt="reviews" src="../images/review.jpg" />
	</div>

	<c:if test="${massage != null}">
		<div align="center" style="background-color: #f9fece;">
			<h4 class="massage">${massage}</h4>
		</div>
	</c:if>

	<div align="center" class="tabledata">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>Order ID</th>
				<th>Ordered By</th>
				<th>Book Copies</th>
				<th>Total</th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
				<th>Action</th>

			</tr>
			<c:forEach var="order" items="${listOrder}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${order.orderId}</td>
					<td>${order.customer.fullname}</td>
					<td>${order.bookCopies}</td>
					<td>${order.total}</td>
					<td>${order.paymentMethod}</td>
					<td>${order.status}</td>
					<td><fmt:formatDate pattern ='MM/dd/yyyy' value='${order.orderDate}'/></td>
					
					<td>
					<a href="view_order?id=${order.orderId}"><button>Details</button></a>
					<a href="edit_order?id=${order.orderId}"><button>Update</button></a>
						&nbsp; 
						<a href="javascript:void(0);" class="deletelink" id="${order.orderId}"><button>Delete</button></a></td>
				</tr>

			</c:forEach>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
 <script type="text/javascript">
 $(document).ready(function(){
		$(".deletelink").each(function(){
			$(this).on("click",function(){
				orderId =$(this).attr("id");
				if(confirm('Are you sure you want delete this Review with id: '+orderId+'?'))
				{
				window.location='delete_order?id='+orderId;
				}
						}); }); }); </script>
</body>

</html>