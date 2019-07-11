<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BdBookBazzar</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
	    <br>
		<div align="center" style="width: 80%; margin: 0 auto;">
		<h2>New Books</h2>
			<c:forEach items="${listNewBooks}" var="book">
				<div style="display: inline-block; margin: 20px;"
					align="center">
					<div>
						<a href="view_book?id=${book.bookId}"> <img
							src="data:image/jpg;base64,${book.base64Image}" width="128"
							height="164">
						</a>
					</div>
					<div>
						<a href="view_book?id=${book.bookId}"> By ${book.title} </a>
					</div>
					<div>Ratings ****</div>
					<div align="center">
						<i>${book.author}</i>
					</div>
					<div>
						<b>Tk. ${book.price}</b>
					</div>
				</div>

			</c:forEach>
		</div>

		<div>
			<h2>Best-Selling Books</h2>
		</div>
		<div>
			<h2>Most-Favoured Books</h2>
		</div>
		
	</div>


	<jsp:directive.include file="footer.jsp" />
</body>
</html>