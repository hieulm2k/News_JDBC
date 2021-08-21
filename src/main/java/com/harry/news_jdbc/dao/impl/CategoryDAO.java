package com.harry.news_jdbc.dao.impl;

import com.harry.news_jdbc.dao.ICategoryDAO;
import com.harry.news_jdbc.mapper.CategoryMapper;
import com.harry.news_jdbc.model.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        String sql = "Select * from category";
        return query(sql, new CategoryMapper());
    }
}
