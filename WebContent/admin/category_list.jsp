<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CategoryManagement-BdbookBazzar Administrative</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Category Management</h2>
		<h3>
			<a href="">Create New Category</a>
		</h3>
	</div>


	<div align="center">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>CategoryID</th>
				<th>Category Name</th>
				<th>Action</th>

			</tr>
			<c:forEach var="category" items="${listCategory}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${category.categoryId}</td>
					<td>${category.name}</td>
					<td><a href=""><button>Update</button></a> &nbsp; <a href=""><button>Delete</button></a></td>

				</tr>

			</c:forEach>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
	</script>

</body>

</html>