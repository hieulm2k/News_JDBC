package com.harry.news_jdbc.service.impl;

import com.harry.news_jdbc.dao.ICategoryDAO;
import com.harry.news_jdbc.model.CategoryModel;
import com.harry.news_jdbc.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
//    private ICategoryDAO categoryDAO;
//
//    public CategoryService() {
//        categoryDAO = new CategoryDAO();
//    }
    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
