package com.databasegroup.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.databasegroup.dao.IDealedBookDao;
import com.databasegroup.dao.ISellingOrderDao;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.SellingOrder;
import com.databasegroup.service.ISellingOrderService;

@Service("sellingOrderService")
public class SellingOrderServiceImpl implements ISellingOrderService {
	
	@Resource
	private ISellingOrderDao sellingOrderDao;
	
	@Resource
	private IDealedBookDao dealedBookDao;

	@Override
	public void insert(SellingOrder entity) {
		sellingOrderDao.insert(entity);
	}

	@Override
	public void update(SellingOrder entity) {
		sellingOrderDao.update(entity);
	}

	@Override
	public void delete(int id) {
		sellingOrderDao.delete(id);
	}

	@Override
	public SellingOrder getById(int id) {
		return sellingOrderDao.getById(id);
	}

	@Override
	public List<SellingOrder> getAll() {
		return sellingOrderDao.getAll();
	}

	@Override
	public List<SellingOrder> getSellingOrdersByUserId(int id) {
		List<SellingOrder> sellingOrders = 
				sellingOrderDao.getSellingOrdersByUserId(id);
		for (SellingOrder order : sellingOrders) {
			String dealedBookId = 
					order.getDealedBookIds().split("|")[0];
			DealedBook dealedBook = dealedBookDao
					.getById(Integer.parseInt(dealedBookId));
			List<DealedBook> dealedBooks = new ArrayList<>();
			dealedBooks.add(dealedBook);
			order.setDealedBooks(dealedBooks);
		}
		return sellingOrders;
	}

	@Override
	public void insertOrder(SellingOrder sellingOrder) {
		StringBuilder dealedBookId = new StringBuilder();
		int bookId = sellingOrder.getBookId();
		int amount  = sellingOrder.getAmount();
		List<DealedBook> dealedBooks = 
				dealedBookDao.getNoDealedBookByBookIdAndAmount(bookId, amount);
		if (dealedBooks.size() != amount) throw new RuntimeException("没有足够的书本");
		for (DealedBook dealedBook : dealedBooks) {
			dealedBook.setSelled(1);
			dealedBook.setSelledDatetime(new Date());
			dealedBookId.append("" + dealedBook.getId() + '|');
			dealedBookDao.update(dealedBook);
		}
		if (dealedBookId.length() > 0) 
			dealedBookId = dealedBookId.deleteCharAt(dealedBookId.length()-1);
		// 设置dealed_book_id字段的值
		sellingOrder.setDealedBookIds(dealedBookId.toString());
		sellingOrderDao.insert(sellingOrder);
	}

	@Override
	public SellingOrder getOrderById(int id) {
		SellingOrder order = sellingOrderDao.getById(id);
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
