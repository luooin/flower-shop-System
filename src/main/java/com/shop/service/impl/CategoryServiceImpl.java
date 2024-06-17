package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import com.shop.controller.dao.CategoryMapper;
import com.shop.service.impl.pojo.Category;
import com.shop.service.CategoryService;
@Service
public class CategoryServiceImpl implements  CategoryService{
    @Resource
    private CategoryMapper categoryMapper;
	@Override
	public int deleteByByCategoryCode(String categoryCode) {

		int categories = categoryMapper.deleteByByCategoryCode(categoryCode);
		return categories;
	}

	@Override
	public int insert(Category record) {

		int categories = categoryMapper.insert(record);
		return categories;
	}

	@Override
	public Category selectByByCategoryCode(String categoryCode) {

		Category category = categoryMapper.selectByByCategoryCode(categoryCode);
		return category;
	}

	@Override
	public int updateByCategoryCode(Category record) {

		int category = categoryMapper.updateByCategoryCode(record);
		return category;
	}

	@Override
	public List<Category> selectAll(Integer page, Integer limit) {

		PageHelper.startPage(page, limit);
		List<Category> categories = categoryMapper.selectAll();
		return categories;
	}

}
