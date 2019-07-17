package com.bookbazzar.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.BookOrder;
import com.bookbazzar.entity.Customer;

public class OrderDAO extends jpaDAO<BookOrder> implements GenericDAO<BookOrder> {

	@Override
	public BookOrder create(BookOrder order) {
		order.setOrderDate(new Date());
		order.setStatus("Processing");
		return super.create(order);
	}

	@Override
	public BookOrder update(BookOrder orderId) {
		// TODO Auto-generated method stub
		return super.update(orderId);
	}

	@Override
	public BookOrder get(Object orderId) {
		// TODO Auto-generated method stub
		return super.find(BookOrder.class, orderId);
	}
	
	public BookOrder get(Integer orderId, Integer customerId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("orderId", orderId);
		parameters.put("customerId", customerId);
		List<BookOrder> result = super.findWithNamedQery("BookOrder.findByIdAndCustomer", parameters);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
		
	}

	@Override
	public void delete(Object orderId) {
		super.delete(BookOrder.class, orderId);
 
	}

	@Override
	public List<BookOrder> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQery("listAll.BookOrder");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("countAll.BookOrder");
	}
	public long countOrderDetailByBook(int bookId) {
		return super.countWithNamedQuery("OrderDetail.countByBook", "bookId", bookId);
	}
	public long countByCustomer(int customerId) {
		return super.countWithNamedQuery("BookOrder.countByCustomer", "customerId", customerId);
	}	
	public List<BookOrder> listByCustomer(Integer customerId){
		return super.findWithNamedQery("BookOrder.listByCustomer" , "customerId", customerId);
		
	}
	public List<BookOrder> listMostRecentSells(){
		return super.findWithNamedQery("listAll.BookOrder", 0, 5);
		
	}
	
}
