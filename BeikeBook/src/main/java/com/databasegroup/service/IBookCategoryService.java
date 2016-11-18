package com.databasegroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.databasegroup.model.BookCategory;
import com.databasegroup.model.City;
import com.databasegroup.model.User;

public interface IBookCategoryService extends IBaseService<BookCategory> {
	List<BookCategory> getLimitCategories(@Param("start")int start,@Param("num")int num);
}
