package com.harry.news_jdbc.service.impl;

import com.harry.news_jdbc.dao.INewsDAO;
import com.harry.news_jdbc.model.NewsModel;
import com.harry.news_jdbc.paging.Pageble;
import com.harry.news_jdbc.service.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
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
        newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setCreatedBy("");
        Long newsId = newsDAO.save(newsModel);
        return newsDAO.findOne(newsId);
    }

    @Override
    public NewsModel update(NewsModel updateNews) {
        NewsModel oldNews = newsDAO.findOne(updateNews.getId());
        updateNews.setCreatedDate(oldNews.getCreatedDate());
        updateNews.setCreatedBy(oldNews.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNews.setModifiedBy("");
        newsDAO.update(updateNews);
        return newsDAO.findOne(updateNews.getId());
    }

    @Override
    public void delete(long[] ids) {
        for(long id: ids){
            newsDAO.delete(id);
        }
    }

    @Override
    public List<NewsModel> findAll(Pageble pageble) {
        return newsDAO.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return newsDAO.getTotalItem();
    }
}
