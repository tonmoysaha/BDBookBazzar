<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books in-${category.name}</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center" style="background-color: #323256; color: white;font-size: 20px;padding-top: 2px;">
		<h2>${category.name}</h2>
		<img alt="" src="images/categorybybook.jpg">
		<br>
	</div>
    <div style="background-color: #f1fc90;">
	<div align="center" style="width: 80%;margin: 0 auto;">
		<c:forEach items="${listBooks}" var="book">
			<div style="display: inline-block; margin: 20px;">
				<div>
					<a href="view_book?id=${book.bookId}"> <img
						src="data:image/jpg;base64,${book.base64Image}" width="128"
						height="164">
					</a>
				</div>
				<div>
					<a href="view_book?id=${book.bookId}"style="color: black;">
						By ${book.title}
					</a>
				</div>
				<div>
					<jsp:directive.include file="book_rating.jsp"/>
				</div>
				<div align="center"><i>${book.author}</i></div>
				<div><b>Tk. ${book.price}</b></div>
			</div>

		</c:forEach>

	</div>
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>