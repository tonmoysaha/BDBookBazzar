
<!-- Header part -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">

	<img src="images/BookstoreLogo.png">
	
</div>
<div align="center">
	<input type="text" name="keyword" size="50"> <input
		type="submit" value="search">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="login">Sign In</a>
	<a href="register">Registration</a> <a href="view_cart">Shopping
		Cart</a>

</div>
<div>&nbsp;</div>
<div align="center">
	<c:forEach var="category" items="${listCategory}" varStatus="status">
		<a href="view_category?id=${category.categoryId }"> <c:out
				value="${category.name}"></c:out>
		</a>
		<c:if test="${not status.last}"></c:if>
	&nbsp; | &nbsp;
	</c:forEach>
</div>