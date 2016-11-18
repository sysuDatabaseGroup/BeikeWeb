package com.databasegroup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.databasegroup.model.Book;

@Repository
public interface IBookDao extends IBaseDao<Book> {
	List<Book> getNoSelledAndNoRentedBooks();
	List<Book> getByBookCategoryId(
			@Param("bookCategoryId") int bookCategoryId);
	List<Book> getByBookTitle(
			@Param("bookTitle") String bookTitle);
	List<Book> getLimitBooks(@Param("start")int start,@Param("num")int num);
}
