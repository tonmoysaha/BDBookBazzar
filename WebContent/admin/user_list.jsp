<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UsersManagement-BdbookBazzar Administrative</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Users Management</h2>
		<h3>
			<a href="user_form.jsp">Create New User</a>
		</h3>
	</div>
	<c:if test="${message != null}">
		<div align="center">
			<!-- from User services method-->
			<h4>
				<i>${message}</i>
			</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>FullName</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${listUsers}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${user.userId}</td>
					<td>${user.email}</td>
					<td>${user.fullname}</td>
					<td><a href="edit_user?id=${user.userId}"><button>Update</button></a>
						&nbsp; <a href="javascript:confirmDelete(${user.userId})"><button>Delete</button></a></td>

				</tr>

			</c:forEach>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
 <script type="text/javascript">
 function confirmDelete(userId) {
		if(confirm('Are you sure you want delete this userId: '+userId+'?'))
			{
			window.location='delete_user?id='+userId;
			}
		
 }

 
 </script>

</body>

</html>