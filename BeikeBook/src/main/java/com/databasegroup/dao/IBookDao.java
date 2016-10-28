package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.Book;

@Repository
public interface IBookDao extends IBaseDao<Book> {
	List<Book> getNoSelledAndNoRentedBooks();
}
