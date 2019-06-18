<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<div>
		<img src="../images/BookstoreAdminLogo.png">
	</div>
	<div>
		<h3>
			welcome, <c:out value="${sessionScope.useremail}"></c:out> <a href="logout">Logout</a>
		</h3>
		<div id="headermanu">
			<b>
				<div>
					<a href="list_users"><img alt="users" src="../images/user.png" /><br />Users</a>
				</div>

				<div>
					<a href="list_categorys"><img alt="Category"
						src="../images/category.png" /><br />Categories</a>
				</div>
				<div class="menu_item">
					<a href="books"><img alt="books" src="../images/book.jpg" /><br />Books</a>
				</div>

				<div>
					<a href="customers"><img alt="customer"
						src="../images/customer.png" /><br />Customers</a>
				</div>

				<div>
					<a href="reviews"><img alt="reviews" src="../images/review.jpg" /><br />Reviews</a>
				</div>


				<div>
					<a href="orders"><img alt="order" src="../images/order.png" /><br />Orders</a>
				</div>

			</b>
		</div>
	</div>
</div>