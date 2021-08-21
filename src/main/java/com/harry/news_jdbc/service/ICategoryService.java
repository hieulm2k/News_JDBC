package com.harry.news_jdbc.service;

import com.harry.news_jdbc.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
}
