<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BooksManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2  class="pageheading">Books Management</h2>
		<h3>
			<a href="new_book">Create New Book</a>
		</h3>
	</div>
	<c:if test="${massage != null}">
		<div align="center">
			<!-- from User services method-->
			<h4 class="massage">
				${massage}
			</h4>
		</div>
	</c:if>

	<div align="center">
		<table border="1">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Image</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Price</th>
				<th>Last Update</th>
				<th>Action</th>
			</tr>
			<c:forEach var="book" items="${bookList}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${book.bookId}</td>
					
					<td><img src="data:image/jpg;base64,${book.base64Image}" width="84" height="110"></td>
					
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category.name}</td>
					<td>Tk. ${book.price}</td>
					<td><fmt:formatDate pattern ='MM/dd/yyyy' value='${book.lastUpdateTime}'/></td>
					
					
					<td><a href="edit_book?id=${book.bookId}"><button>Update</button></a>
						&nbsp;&nbsp; <a href="javascript:void(0);" class="deletelink" id="${book.bookId}"><button>Delete</button></a>
						</td>
                     
				</tr>

			</c:forEach>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
 <script type="text/javascript">
 $(document).ready(function(){
	$(".deletelink").each(function(){
		$(this).on("click",function(){
			bookId=$(this).attr("id");
			if(confirm('Are you sure you want delete this userId: '+bookId+'?'))
			{
			window.location='delete_book?id='+bookId;
			}
		
			
		});
	});
 });


 </script>

</body>

</html>