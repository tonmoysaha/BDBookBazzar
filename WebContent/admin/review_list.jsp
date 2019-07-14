<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ReviewsManagement-BdbookBazzar Administrative</title>
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" class="tabledataheading">
		<h2>Review Management</h2>
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
				<th>ID</th>
				<th>Book</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Comment</th>
				<th>Customer</th>
				<th>Review Time</th>
				<th>Action</th>

			</tr>
			<c:forEach var="review" items="${listReviews}" varStatus="status">
				<tr>
					<td>${status.index}</td>
					<td>${review.reviewId}</td>
					<td>${review.book.title}</td>
					<td>${review.rating}</td>
					<td>${review.headline }</td>
					<td>${review.comment}</td>
					<td>${review.customer.fullname}</td>
					<td>${review.reviewTime}</td>
					
					<td><a href="edit_review?id=${review.reviewId}"><button>Update</button></a>
						&nbsp; <a href="javascript:void(0);" class="deletelink" id="${review.reviewId}"><button>Delete</button></a></td>

				</tr>

			</c:forEach>

		</table>

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