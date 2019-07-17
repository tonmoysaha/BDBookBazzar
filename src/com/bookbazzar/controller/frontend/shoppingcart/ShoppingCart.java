package com.bookbazzar.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.bookbazzar.entity.Book;

public class ShoppingCart {
	Map<Book, Integer> cart = new HashMap<Book, Integer>();

	public void addItem(Book book) {
		if (cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
		} else {
			cart.put(book, 1);
		}
	}

	public void removeItem(Book book) {
		cart.remove(book);
	}

	public int getTotallQuantity() {
		
		int totall = 0;

		Iterator<Book> iterator = cart.keySet().iterator();

		while (iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = cart.get(book);
			totall += quantity;
		}
		return totall;
	}

	public float getTotallAmount() {
		float totall = 0.0f;

		Iterator<Book> iterator = cart.keySet().iterator();

		while (iterator.hasNext()) {
			Book book = iterator.next();
			Integer quantity = cart.get(book);
			float subTotall = quantity * book.getPrice();
			totall += subTotall;
		}
		return totall;
	}
	public void UpdateCart(int[] bookIds, int[] quantities) {
		for (int i = 0; i < bookIds.length; i++) {
			Book key = new Book(bookIds[i]);
			Integer value = quantities[i];
			cart.put(key, value);
		}
	}
	public void clear() {
		cart.clear();
	}
	public int getTotalItems() {
		return cart.size();
		
	}

	public Map<Book, Integer> getItems() {
		return this.cart;

	}

}
