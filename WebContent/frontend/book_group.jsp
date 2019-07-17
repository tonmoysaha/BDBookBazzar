<div style="display: inline-block; margin: 20px;" align="center">
	<div>
		<a href="view_book?id=${book.bookId}"> <img
			src="data:image/jpg;base64,${book.base64Image}" width="128"
			height="164">
		</a>
	</div>
	<div>
		<a href="view_book?id=${book.bookId}" style="color: black;">
			${book.title} </a>
	</div>
	<div>
		<jsp:directive.include file="book_rating.jsp" />

		<!-- From book entity class public String getRatingStars() -->
	</div>

	<div align="center">
		<i>${book.author}</i>
	</div>
	<div>
		<b>Tk. ${book.price}</b>
	</div>
</div>