package com.harry.news_jdbc.dao;

import com.harry.news_jdbc.mapper.RowMapper;
import com.harry.news_jdbc.model.CategoryModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update(String sql, Object... parameters);
    Long insert(String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
