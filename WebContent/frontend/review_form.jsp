<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WriteReviewPage</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center" style="background-color: #deffab;">
		<form action="submit_review" method="post" id="revireForm">
			<table class="normal" width="60%">
				<tr>
					<td><h2>Write Review</h2></td>
					<td>&nbsp;</td>
					<td><h2>${loggedcustomer.fullname}</h2></td>
				</tr>
				<tr>
					<td colspan="3"><hr></td>
				</tr>
				<tr>
					<td><span class="book-title">${book.title}</span> <br> <br>
						<img src="data:image/jpg;base64,${book.base64Image}" width="128"
						height="164"></td>
					<td>
						<div id="rateYo">
						</div> 
						<input type="hidden" name="rating" id="rating" > 
						<input type="hidden" name="bookId" value="${book.bookId}">
						<br> 
						<input type="text" size="60" , name="headline"
						placeholder="Headline or summary for your review">
						 <br>
						<textarea name="comment" rows="10" cols="70"
							placeholder="Write your review details"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<button type="submit">Submit Review</button> &nbsp;&nbsp; &nbsp;
						&nbsp;
						<button id="cancelbutton">Cancel</button>
					</td>
				</tr>

			</table>
		</form>

	</div>
	<jsp:directive.include file="footer.jsp" />
	
	<script type="text/javascript">
	$(document).ready(function() {
		
		$("#revireForm").validate({
			rules : {
				headline: "required",
				comment : "required"
			},
			messages : {
				headline: "please enter your headline before Submit",
				comment : "please enter your Comment before Submit"
			}
		});
		
		$("#rateYo").rateYo({
		    starWidth: "40px",
		    fullStar: true,
		    onSet: function(rating, rateYoInstance)
		    {
		    	$("#rating").val(rating);
		    }
		  });
		$("#cancelbutton").click(function(){
    		history.go(-1);
    	});
	});
</script>
</body>

</html>