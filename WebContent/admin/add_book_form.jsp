<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book to order</title>
</head>
<body>
	<div align="center" style="background-color: #b3ffff;">
		<h2>Add Book to this Order: ${order.orderId}</h2>
		<br>
		<form action="add_book_to_order" method="post">
			<table>
				<tr>
					<td>Choose Book to Add:</td>
					<td><select name="bookId">
							<c:forEach items="${listBook }" var="book" varStatus="status">
								<option value="${book.bookId}">${book.title}-
									${book.author}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Number of copies:</td>
					<td><select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Add">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="button" value="cancel" onclick="javascript: self.close();"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>