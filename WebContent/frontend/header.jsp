
<!-- Header part -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="background-color: black; color: white; padding-bottom: 20px;">
<div class="center">
    <a href="${pageContext.request.contextPath}/">
	<img src="images/BookstoreLogo.png">
	</a>
	
</div>
<div align="center">
    <br>
    <br>
    <form action="search" method="get">
    <input type="text" name="keyword" size="50"> <input
	type="submit" value="search">
    </form>
	
	&nbsp;&nbsp;&nbsp;
	<c:if test="${loggedcustomer == null}">
	<a href="login">Sign In</a>
	 &nbsp;
	<a href="register">Registration</a> 
	&nbsp;
	</c:if>
	<c:if test="${loggedcustomer != null}">
	<a href="view_profile">Welcome , ${loggedcustomer.fullname}</a>
	 &nbsp;
	<a href="view_orders">My Orders</a> 
	&nbsp;
	<a href="logout">Log Out</a>
	&nbsp;
	</c:if>
	 
	<a href="view_cart">Shopping
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
</div>