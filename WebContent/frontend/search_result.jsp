<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List For-${keyword}</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">

		<c:if test="${fn:length(searchBook)==0}">
			<h2>No result For ${keyword}</h2>
		</c:if>

		<c:if test="${fn:length(searchBook) > 0}">

			<div align="left" style="width: 80%; margin: 0 auto;">
				<h2 align="center">Result for ${keyword}:</h2>

				<c:forEach items="${searchBook}" var="book">
					<div>
						<div style="display: inline-block; margin: 20px; width: 10%;">
							<div align="left">
								<a href="view_book?id=${book.bookId}"> <img
									src="data:image/jpg;base64,${book.base64Image}" width="128"
									height="164">
								</a>
							</div>
						</div>
						<div
							style="display: inline-block; margin: 20px; vertical-align: top; width: 60%;"
							align="left">
							<div>
								<h2>
									<a href="view_book?id=${book.bookId}"> By ${book.title} </a>
								</h2>
							</div>
							<div><jsp:directive.include file="book_rating.jsp"/></div>
							<div>
								<i>by ${book.author}</i>
							</div>
							<div>
								<p>${fn:substring(book.description,0,100)}.....</p>
							</div>
						</div>
						<div
							style="display: inline-block; margin: 20px; vertical-align: top;">
							<h3>
								<b>Tk. ${book.price}</b>
							</h3>
							<h3>
								<a href="#" style="color: blue;">Add to Cart</a>
							</h3>
						</div>
					</div>
				</c:forEach>
	</div>
	</c:if>

		<jsp:directive.include file="footer.jsp" />
</body>
</html>