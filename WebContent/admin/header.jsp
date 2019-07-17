<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center"
	style="background-color: black; color: white; padding-bottom: 20px;">
	<div>
		<a href="${pageContext.request.contextPath}/admin/"> <img
			src="../images/BookstoreAdminLogo.png">
		</a>
	</div>
	<div>
		<h3>
			welcome,
			<c:out value="${sessionScope.useremail}">&nbsp;&nbsp;</c:out>
			<a href="logout">Logout</a>
		</h3>
		<div id="headermanu">
			<b>
				<div>
					<a href="${pageContext.request.contextPath}/admin/">
					<img alt="home" src="../images/home.png" /><br />Home</a>
				</div>

				<div>
					<a href="list_users"><img alt="users" src="../images/user.png" /><br />Users</a>
				</div>

				<div>
					<a href="list_categorys"><img alt="Category"
						src="../images/category.png" /><br />Categories</a>
				</div>
				<div class="menu_item">
					<a href="books_list"><img alt="books" src="../images/book.jpg" /><br />Books</a>
				</div>

				<div>
					<a href="list_customer"><img alt="customer"
						src="../images/customer.png" /><br />Customers</a>
				</div>

				<div>
					<a href="list_review"><img alt="reviews"
						src="../images/review.jpg" /><br />Reviews</a>
				</div>


				<div>
					<a href="list_order"><img alt="order" src="../images/order.png" /><br />Orders</a>
				</div>

			</b>
		</div>
	</div>
</div>