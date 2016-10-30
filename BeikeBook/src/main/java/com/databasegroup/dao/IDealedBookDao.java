package com.databasegroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.databasegroup.model.DealedBook;
import com.databasegroup.model.SelledBookFromUser;
import com.databasegroup.model.User;

@Repository
public interface IDealedBookDao extends IBaseDao<DealedBook> {
	DealedBook getNoSelledAndNoRentedBookByBookId(int id);
	int getAmountOfNoDealedBookBookId(int id);
	int getAmountOfBookUserId(int id);
	List<DealedBook> getNoSelledBookByUserId(int id);
	List<SelledBookFromUser> getSelledBookByUserId(int id);
	List<DealedBook> getNoDealedBookByBookIdAndAmount(
			@Param("bookId")int bookId, 
			@Param("amount")int amount);
}
