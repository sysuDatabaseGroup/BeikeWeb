package com.databasegroup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.BookCategory;

@Repository
public interface IBookCategoryDao extends IBaseDao<BookCategory> {
	List<BookCategory> getLimitCategories(@Param("start")int start,@Param("num")int num);
}
