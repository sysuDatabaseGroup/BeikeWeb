package com.databasegroup.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.databasegroup.dao.ICityDao;
import com.databasegroup.dao.IDealedBookDao;
import com.databasegroup.dao.IUserDao;
import com.databasegroup.model.BooksViewSellingBook;
import com.databasegroup.model.BooksViewSoldBook;
import com.databasegroup.model.City;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.SelledBookFromUser;
import com.databasegroup.model.User;
import com.databasegroup.service.ICityService;
import com.databasegroup.service.IDealedBookService;
import com.databasegroup.service.IUserService;

@Service("dealedBookService")
public class DealedBookServiceImpl implements IDealedBookService {
	
	@Resource
	private IDealedBookDao dealedBookDao;

	@Override
	public void insert(DealedBook entity) {
		dealedBookDao.insert(entity);
	}

	@Override
	public void update(DealedBook entity) {
		dealedBookDao.update(entity);
	}

	@Override
	public void delete(int id) {
		dealedBookDao.delete(id);
	}

	@Override
	public DealedBook getById(int id) {
		return dealedBookDao.getById(id);
	}

	@Override
	public List<DealedBook> getAll() {
		return dealedBookDao.getAll();
	}

	@Override
	@Cacheable("dealedBookCache")
	public DealedBook getNoSelledAndNoRentedBookByBookId(int id) {
		return dealedBookDao.getNoSelledAndNoRentedBookByBookId(id);
	}

	@Override
	public int getAmountOfNoDealedBookBookId(int id) {
		return dealedBookDao.getAmountOfNoDealedBookBookId(id);
	}

	@Override
	public int getAmountOfBookUserId(int id) {
		return dealedBookDao.getAmountOfBookUserId(id);
	}

	@Override
	public List<DealedBook> getNoSelledBookByUserId(int id) {
		return dealedBookDao.getNoSelledBookByUserId(id);
	}

	@Override
	public List<DealedBook> getSelledBookByUserId(int id) {
		return dealedBookDao.getSelledBookByUserId(id);
	}

	@Override
	public double getEncashingAmountByUserId(int userId) {
		return dealedBookDao.getEncashingAmountByUserId(userId);
	}

	@Override
	public void setEncashedByUser(int userId) {
		dealedBookDao.setEncashedByUser(userId);
	}

	@Override
	public List<BooksViewSellingBook> getBooksViewSellingBooksByUserId(int id) {
		return dealedBookDao.getBooksViewSellingBooksByUserId(id);
	}

	@Override
	public List<BooksViewSoldBook> getBooksViewSoldBooksByUserId(int id) {
		return dealedBookDao.getBooksViewSoldBooksByUserId(id);
	}

}
