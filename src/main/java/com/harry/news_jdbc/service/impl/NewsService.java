package com.harry.news_jdbc.service.impl;

import com.harry.news_jdbc.dao.INewsDAO;
import com.harry.news_jdbc.model.NewsModel;
import com.harry.news_jdbc.service.INewsService;

import javax.inject.Inject;
import java.util.List;

public class NewsService implements INewsService {
    @Inject
    public INewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        Long newId = newsDAO.save(newsModel);
        System.out.println(newId);
        return null;
    }
}
