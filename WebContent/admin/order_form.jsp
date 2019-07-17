<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditOrderDetailManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="tabledataheading">
		<h2>Detail for Order ID: ${order.orderId }</h2>
		<img alt="reviews" src="../images/order.png" />
	</div>

	<c:if test="${massage != null}">
		<div align="center" style="background-color: #f9fece;">
			<h4 class="massage">${massage}</h4>
		</div>
	</c:if>

	<form action="update_order" method="post" id="orderForm">
		<div align="center" class="tabledata">
			<br>

			<table>

				<tr>
					<td>Order By:</td>
					<td>${order.customer.fullname}</td>
				</tr>

				<tr>
					<td>Order Date:</td>
					<td><fmt:formatDate pattern='MM/dd/yyyy'
							value='${order.orderDate}' /></td>
				</tr>

				<tr>
					<td>Recipient Name:</td>
					<td><input type="text" name="recipientfullname"
						value="${order.recipientName}" size="45"></td>
				</tr>

				<tr>
					<td>Recipient phone:</td>
					<td><input type="text" name="recipientPhone"
						value="${order.recipientPhone}" size="45"></td>
				</tr>

				<tr>
					<td>Ship To:</td>
					<td><input type="text" name="shippingAddress"
						value="${order.shippingAddress}" size="45"></td>
				</tr>

				<tr>
					<td><b>Payment Method: </b></td>
					<td><select name="paymentMethod">
							<option value="Cash On Delivery">Cash On Delivery</option>
					</select></td>
				</tr>

				<tr>
					<td>Order Status:</td>
					<td><select name="orderStatus">
							<option value="Processing">Processing</option>
							<option value="Shipping">Shipping</option>
							<option value="Delivered">Delivered</option>
							<option value="Completed">Completed</option>
							<option value="Cancel">Cancel</option>
					</select></td>
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
					<th>Remove Order</th>
				</tr>

				<c:forEach items="${order.orderDetails}" var="orderDetail"
					varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td><img style="vertical-align: middle;"
							src="data:image/jpg;base64,${orderDetail.book.base64Image}"
							width="45" height="64"> ${orderDetail.book.title}</td>
						<td>${orderDetail.book.author}</td>
						<td>
						<input type="hidden" name="price" value="${orderDetail.book.price}"> 
						${orderDetail.book.price}
						</td>
						<td>
						<input type="hidden" name="bookId" value="${orderDetail.book.bookId}"> 
						<input type="text" name="quantity${status.index + 1}" value="${orderDetail.quantity}" size="5"></td>
						<td>${orderDetail.subtotal}</td>
						<td><button>
								<a style="color: blue;" href="remove_book_from_order?id=${orderDetail.book.bookId}">Remove</a>
							</button></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right"><b><i>Total:</i></b></td>
					<td><b>${order.bookCopies}</b></td>
					<td><b>${order.total}</b></td>
				</tr>
			</table>
			<div align="center">
				<br> <a style="color: blue;" href="javascript:showAddBookPopUp()"><b>Add
						Books</b></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
					value="update"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="button" value="cancel"
					onclick="javascript:window.location.href='list_order';">
			</div>
		</div>
	</form>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
		function showAddBookPopUp(){
			var width = 500;
			var height = 200;
			var left = (screen.width - width) / 2;
			var left = (screen.height - height) / 2;
			window.open('add_book_form', '_blank', 'width='+width+'height='+height+'top='+top+'left='+left);
		}
		$(document).ready(function() {
			$("#orderForm").validate({
				rules : {
					recipientfullname : "required",
					recipientPhone : "required",
					shippingAddress : "required",
					
					<c:forEach var="book" items="${order.orderDetails}" varStatus="status">
				quantity${status.index + 1}: { 
					required: true,
					number: true,
					min: 1
					},
				</c:forEach>
					
				},
				messages : {
					recipientfullname : "please enter Your recipient name",
					recipientPhone : "please enter Your recipient phone",
					shippingAddress : "please enter Your recipient address",
					
					<c:forEach var="book" items="${order.orderDetails}" varStatus="status">
				quantity${status.index + 1}: { 
					required: "please enter the quantity",
					number: "quantity must be number",
					min: "quaantity must be a greater than 0"
					},
				</c:forEach>

				}
			});
		});
	</script>
</body>

</html>