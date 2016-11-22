package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.Book;
import com.databasegroup.model.BookCategory;
import com.databasegroup.model.City;
import com.databasegroup.model.User;

public interface IBookService extends IBaseService<Book> {
	List<Book> getNoSelledAndNoRentedBooks();
	List<Book> getByBookCategoryId(
			@Param("bookCategoryId") int bookCategoryId);
	List<Book> getByBookTitle(
			@Param("bookTitle") String bookTitle);
	List<Book> getLimitBooks(@Param("start")int start,@Param("num")int num);
	List<Book> searchByName(@Param("name") String name);
}
