package com.bookbazzar.dao;

import java.io.ObjectOutputStream.PutField;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Receiver;

import com.bookbazzar.entity.Review;

public class ReviewDAO extends jpaDAO<Review> implements GenericDAO<Review> {
	

	@Override
	public Review create(Review review) {
		review.setReviewTime(new Date());
		
		return super.create(review);
	}

	@Override
	public Review update(Review review) {
		
		return super.update(review);
	}

	@Override
	public Review get(Object reviewId) {
		// TODO Auto-generated method stub
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
		
	}

	@Override
	public List<Review> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQery("Review.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Review.countAll");
	}
	public Review findByCustomerAndBook(Integer customerId , Integer bookId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customerId", customerId);
		parameters.put("bookId", bookId);
		
		List<Review> result = super.findWithNamedQery("Review.findAllReviewByCustomerAndBook", parameters);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
		
		
	}

	public long countByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Review.countByCustomer", "customerId", customerId);
	}
	public List<Review> listMostRecentReviews(){
		return super.findWithNamedQery("Review.findAll", 0, 5);
		
	}

}
