<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add book to order</title>
</head>
<body>
	<div align="center">

		<h2>The Book : ${book.title} has been to this Order Name:
			${order.customer.fullname}</h2>
			<input type="button" value="cancel" onclick="javascript: self.close();">
	</div>
	<script type="text/javascript">
	window.onunload = function(){
		window.opener.location.reload();
	}
	</script>
</body>
</html>