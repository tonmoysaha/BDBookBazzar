<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Review</title>

<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">Update Review</h2>
	</div>

	<c:if test="${massage != null}">
		<div align="center">
			<h4 class="massage">${massage}</h4>
		</div>
	</c:if>


	<div align="center">

		<form action="update_review" method="post" id="reviewForm">
			<input type="hidden" name="reviewId" value="${review.reviewId}">

			<table class="from">
				<tr>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td align="right">Book Name:</td>
					<td align="left"><b>${review.book.title}</b></td>
				</tr>
				<tr>
					<td align="right">Rating:</td>
					<td align="left"><b>${review.rating}</b></td>
				</tr>
				<tr>
					<td align="right">Customer Name:</td>
					<td align="left"><b>${review.customer.fullname}</b></td>
				</tr>
				

				<tr>
					<td align="right">Headline:</td>
					<td align="left"><input type="text" name="headline" id="headline"
						value="${review.headline}" size="49"></td>
				</tr>
				
				<tr>
					<td align="right">Comment:</td>
					<td align="left"><textarea rows="5" cols="50" name="comment" id="comment">${review.comment}</textarea></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center">&nbsp;&nbsp;
						<button type="submit">Update</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
		$("#reviewForm").validate({
			rules : {
				headline : "required",
				comment: "required"
			},
			messages : {
				headline : "please enter the headline",
				comment: "please enter the Comment",

			}
		});
		$("#cancelbutton").click(function(){
    		history.go(-1);
    	});
	});
</script>
</html>