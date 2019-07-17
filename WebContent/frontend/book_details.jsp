<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${book.title}-details</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<table width="80%" style="border: 0;">
			<tr>
				<td align="left" colspan="3">
					<h2>${book.title}</h2>
					<h3>${book.author}</h3>
				</td>
			</tr>
			<tr>
				<td rowspan="2"><img
					src="data:image/jpg;base64,${book.base64Image}" width="128"
					height="164"></td>

				<td valign="top" align="left"><jsp:directive.include
						file="book_rating.jsp" /> &nbsp; &nbsp;<a href="#reviews">${fn:length(book.reviews)} Reviews</a>
				</td>

				<td valign="top" rowspan="2" width="20%">${book.price}<br />
					<button id="AddButtonToCart">Add to cart</button>
				</td>
			</tr>

			<tr>
				<td valign="top" style="text-align: justify;">
					${book.description}</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<!--  <td><h2><a id="reviews">Customer Reviews</a></h2></td> -->
				<td><b><a id="reviews">Customer Reviews</a></b></td>
				<td align="center">
					<button id="writereview">Write a Customer Review</button>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="left" style="background-color: #F0E68C;">
					<table class="normal">
						<c:forEach items="${book.reviews}" var="review">
							<tr>
								<td><c:forTokens items="${review.stars}" delims=","
										var="star">

										<c:if test="${star eq 'on'}">
											<img src="images/rating-on.png">
										</c:if>
										<c:if test="${star eq 'off'}">
											<img src="images/rating-off.png">
										</c:if>
									</c:forTokens>
									<br>
								    <b>Headline: ${review.headline}</b></td>
							</tr>
							<tr>
								<td>by ${review.customer.fullname} on ${review.reviewTime}</td>
							</tr>

							<tr>
								<td><i><b>Comment: </b>${review.comment}</i></td>
							</tr>

							<tr>
								<td>&nbsp;</td>
							</tr>

						</c:forEach>
					</table>
				</td>
			</tr>

		</table>

	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	 $(document).ready(function(){
		 $("#writereview").click(function(){
			 window.location='write_review?book_id='+${book.bookId};
	    	});
		 $("#AddButtonToCart").click(function(){
			 window.location='add_to_cart?book_id='+${book.bookId};
	    	});
	 });
	
	</script>
</body>
</html>