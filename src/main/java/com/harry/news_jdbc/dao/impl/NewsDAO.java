package com.harry.news_jdbc.dao.impl;

import com.harry.news_jdbc.dao.INewsDAO;
import com.harry.news_jdbc.mapper.NewsMapper;
import com.harry.news_jdbc.model.NewsModel;

import java.util.List;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {
    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "Select * from news where categoryid = ?";
        return query(sql, new NewsMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "Insert into news (title, content, categoryid) values(?,?,?)";
        return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
    }
}
