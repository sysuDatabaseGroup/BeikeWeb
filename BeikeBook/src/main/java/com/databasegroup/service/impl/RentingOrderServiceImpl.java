package com.databasegroup.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IDealedBookDao;
import com.databasegroup.dao.IRentingOrderDao;
import com.databasegroup.exception.NoEnoughBooksException;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.RentingOrder;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.service.IRentingOrderService;

@Service("rentingOrderService")
public class RentingOrderServiceImpl implements IRentingOrderService {
	
	@Resource
	private IRentingOrderDao rentingOrderDao;
	
	@Resource
	private IDealedBookDao dealedBookDao;

	@Override
	public void insert(RentingOrder entity) {
		rentingOrderDao.insert(entity);
	}

	@Override
	public void update(RentingOrder entity) {
		rentingOrderDao.update(entity);
	}

	@Override
	public void delete(int id) {
		rentingOrderDao.delete(id);
	}

	@Override
	public RentingOrder getById(int id) {
		return rentingOrderDao.getById(id);
	}

	@Override
	public List<RentingOrder> getAll() {
		return rentingOrderDao.getAll();
	}

	@Override
	public List<RentingOrder> getRentingOrdersByUserId(int id) {
		List<RentingOrder> rentingOrder = 
				rentingOrderDao.getRentingOrdersByUserId(id);
		for (RentingOrder order : rentingOrder) {
			String dealedBookId = 
					order.getDealedBookIds().split("|")[0];
			DealedBook dealedBook = dealedBookDao
					.getById(Integer.parseInt(dealedBookId));
			List<DealedBook> dealedBooks = new ArrayList<>();
			dealedBooks.add(dealedBook);
			order.setDealedBooks(dealedBooks);
		}
		return rentingOrder;
	}

	@Override
	public void insertOrder(RentingOrder rentingOrder) {
		StringBuilder dealedBookId = new StringBuilder();
		int bookId = rentingOrder.getBookId();
		int amount  = rentingOrder.getAmount();
		List<DealedBook> dealedBooks = 
				dealedBookDao.getNoDealedBookByBookIdAndAmount(bookId, amount);
		if (dealedBooks.size() != amount) 
		{
			throw new NoEnoughBooksException("没有足够的书本");
		}
		for (DealedBook dealedBook : dealedBooks) {
			dealedBook.setRented(1);
			dealedBookId.append("" + dealedBook.getId() + '|');
			dealedBookDao.update(dealedBook);
		}
		if (dealedBookId.length() > 0) 
			dealedBookId = dealedBookId.deleteCharAt(dealedBookId.length()-1);
		// 设置dealed_book_id字段的值
		rentingOrder.setDealedBookIds(dealedBookId.toString());
		rentingOrderDao.insert(rentingOrder);
	}

	@Override
	public RentingOrder getOrderById(int id) {
		RentingOrder order = rentingOrderDao.getById(id);
		String[] dealedBookIds = order.getDealedBookIds().split("|");
		List<DealedBook> dealedBooks = new ArrayList<>();
		// 从字段dealed_book_id 取出相应的待售书的信息
		for (String strId : dealedBookIds) {
			int dealedBookid = Integer.parseInt(strId);
			dealedBooks.add(dealedBookDao.getById(dealedBookid));
		}
		order.setDealedBooks(dealedBooks);
		return order;
	}
}
