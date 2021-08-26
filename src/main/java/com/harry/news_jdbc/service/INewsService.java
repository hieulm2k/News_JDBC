package com.harry.news_jdbc.service;

import com.harry.news_jdbc.model.NewsModel;
import com.harry.news_jdbc.paging.Pageble;

import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    NewsModel update(NewsModel updateNews);
    void delete(long[] ids);
    List<NewsModel> findAll(Pageble pageble);
    int getTotalItem();
}
