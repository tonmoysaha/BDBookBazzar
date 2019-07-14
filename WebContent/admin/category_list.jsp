<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UsersManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="tabledataheading">
		<h2>Category Management</h2>
		<img alt="Category" src="../images/category.png" />
		<h3>
			<a href="category_form.jsp">Create New Category</a>
		</h3>
	</div>
	<!-- calling from catogoryservice list catrgory method -->
	<c:if test="${massage != null}">
		<div align="center" style="background-color: #f9fece;">
			<!-- from User services method-->
			<h4 class="massage">
				${massage}
			</h4>
		</div>
	</c:if>

	<div align="center" class="tabledata">
		<table border="1" ">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>CategoryName</th>
				<th>Action</th>
				
			</tr>
			<c:forEach var="cat" items="${listCategory}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${cat.categoryId}</td>
					<td>${cat.name}</td>
					
					<td><a href="edit_category?id=${cat.categoryId}"><button>Update</button></a>
						&nbsp; <a href="javascript:void(0);" class="deletelink" id="${cat.categoryId}"><button>Delete</button></a></td>

				</tr>

			</c:forEach>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
 <script type="text/javascript">
 $(document).ready(function(){
		$(".deletelink").each(function(){
			$(this).on("click",function(){
				categoryId=$(this).attr("id");
				if(confirm('Are you sure you want delete this category with id: '+categoryId+'?'))
				{
				window.location='delete_category?id='+categoryId;
				}
			});
		});
	 });
 </script>

</body>

</html>