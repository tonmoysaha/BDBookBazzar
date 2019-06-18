<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
      <c:if test="${category != null }">
			Update Category
		</c:if>
		<c:if test="${category == null}">
			Create New Category
		</c:if>
</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<c:if test="${category != null }">
		<!-- this category object come from edit category method in categoryservice for check is exist or not-->
			<h2 class="pageheading">Update Category</h2>
		</c:if>
		<c:if test="${category == null}">
			<h2 class="pageheading">Create New Category</h2>
		</c:if>

	</div>
	<div align="center">
		<c:if test="${category != null }">
			<form action="update_category" method="post" id="userform">
				<input type="hidden" name="categoryId" value="${category.categoryId}">
		</c:if>
		<c:if test="${category == null}">
			<form action="create_category" method="post" id="userform">
		</c:if>
		<table class="from">
			<tr>
				<td>&nbsp;</td>
			</tr>
			
			<tr>
				<td align="right">Category Name:</td>
				<td align="left">
				<input type="text" name="name" id="name" value="${category.name}" size="20">
				</td>
			</tr>
		
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
			&nbsp;&nbsp;<button type="submit">Add</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="cancelbutton">cancel</button>
					</td>
			</tr>
		</table>
	
		</form>
		
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">


	$(document).ready(function() {
		$("#userform").validate({
			rules : {
				name : "required",
			},
			messages : {
				name : "please enter category fullname",

			}
		});
		$("#cancelbutton").click(function(){
    		history.go(-1);
    	});
	});
</script>
</html>