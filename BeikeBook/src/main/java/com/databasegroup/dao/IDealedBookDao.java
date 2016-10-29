package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.DealedBook;
import com.databasegroup.model.SelledBookFromUser;

@Repository
public interface IDealedBookDao extends IBaseDao<DealedBook> {
	DealedBook getNoSelledAndNoRentedBookByBookId(int id);
	int getAmountOfNoDealedBookBookId(int id);
	int getAmountOfBookUserId(int id);
	List<DealedBook> getNoSelledBookByUserId(int id);
	List<SelledBookFromUser> getSelledBookByUserId(int id);
}
