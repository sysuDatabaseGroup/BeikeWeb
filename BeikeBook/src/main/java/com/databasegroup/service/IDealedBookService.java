package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.BooksViewSellingBook;
import com.databasegroup.model.BooksViewSoldBook;
import com.databasegroup.model.City;
import com.databasegroup.model.DealedBook;
import com.databasegroup.model.SelledBookFromUser;
import com.databasegroup.model.User;

public interface IDealedBookService extends IBaseService<DealedBook> {
	DealedBook getNoSelledAndNoRentedBookByBookId(int id);
	int getAmountOfNoDealedBookBookId(int id);
	int getAmountOfBookUserId(int id);
	List<DealedBook> getNoSelledBookByUserId(int id);
	List<DealedBook> getSelledBookByUserId(int id);
	double getEncashingAmountByUserId(int userId);
	void setEncashedByUser(int userId);
	List<BooksViewSellingBook> getBooksViewSellingBooksByUserId(int id);
	List<BooksViewSoldBook> getBooksViewSoldBooksByUserId(int id);
}
