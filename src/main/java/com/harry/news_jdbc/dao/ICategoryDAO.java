package com.harry.news_jdbc.dao;

import com.harry.news_jdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
}
