package com.harry.news_jdbc.dao;

import com.harry.news_jdbc.model.NewsModel;

import java.util.List;

public interface INewsDAO{
    NewsModel findOne(Long id);
    List<NewsModel> findByCategoryId(Long categoryId);
    Long save(NewsModel newsModel);
    void update(NewsModel updateNews);
    void delete(long id);
}
