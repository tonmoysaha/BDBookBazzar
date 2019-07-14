<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center"  class="tabledataheading">
		<h2>Customers Management</h2>
		<img alt="customer" src="../images/customer.png" />
		<h3>
			<a href="customer_form.jsp">Create New Customer</a>
		</h3>
	</div>
	<c:if test="${message != null}">
		<div align="center" style="background-color: #f9fece;">
			<!-- from User services method-->
			<h4 class="massage">
				${message}
			</h4>
		</div>
	</c:if>

	<div align="center" class="tabledata">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>FullName</th>
				<th>Phone Number</th>
				<th>Address</th>
				<th>City</th>
				<th>Country</th>
				<th>Zip Code</th>
				<th>Registered Date</th>
				<th>Action</th>
			</tr>
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${customer.customerId}</td>
					<td>${customer.email}</td>
					<td>${customer.fullname}</td>
					<td>${customer.phone}</td>
					<td>${customer.address}</td>
					<td>${customer.city}</td>
					<td>${customer.country}</td>
					<td>${customer.zipcode }</td>
					<td><fmt:formatDate pattern ='MM/dd/yyyy' value='${customer.registerDate}'/></td>
					
					<td><a href="edit_customer?id=${customer.customerId}"><button>Update</button></a>
						&nbsp; <a href="javascript:void(0);" class="deletelink" id="${customer.customerId}"><button>Delete</button></a></td>

				</tr>

			</c:forEach>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
 <script type="text/javascript">
 $(document).ready(function(){
	$(".deletelink").each(function(){
		$(this).on("click",function(){
			customerId = $(this).attr("id");
			if(confirm('Are you sure you want delete this customer with this Id: '+customerId+'?'))
			{
			window.location='delete_customer?id='+ customerId;
			}
		
			
		});
	});
 });


 </script>

</body>

</html>