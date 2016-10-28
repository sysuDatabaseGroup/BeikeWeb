package com.databasegroup.dao;

import org.springframework.stereotype.Repository;

import com.databasegroup.model.DealedBook;

@Repository
public interface IDealedBookDao extends IBaseDao<DealedBook> {
	DealedBook getNoSelledAndNoRentedBookByBookId(int id);
}
