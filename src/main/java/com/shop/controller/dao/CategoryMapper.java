package com.shop.controller.dao;

import com.shop.service.impl.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int deleteByByCategoryCode(String categoryCode);

    int insert(Category record);

    Category selectByByCategoryCode(String categoryCode);

    int updateByCategoryCode(Category record);

    List<Category> selectAll();
}
