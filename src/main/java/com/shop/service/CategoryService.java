package com.shop.service;

import java.util.List;

import com.shop.service.impl.pojo.Category;

public interface CategoryService {

	int deleteByByCategoryCode(String categoryCode);

	int insert(Category record);

	Category selectByByCategoryCode(String categoryCode);

	int updateByCategoryCode(Category record);


	List<Category> selectAll(Integer page, Integer limit);
}
