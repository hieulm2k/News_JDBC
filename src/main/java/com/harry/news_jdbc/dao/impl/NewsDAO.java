package com.harry.news_jdbc.dao.impl;

import com.harry.news_jdbc.dao.INewsDAO;
import com.harry.news_jdbc.mapper.NewsMapper;
import com.harry.news_jdbc.model.NewsModel;

import java.util.List;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {
    @Override
    public NewsModel findOne(Long id) {
        String sql = "Select * from news where id = ?";
        List<NewsModel> newsModels = query(sql, new NewsMapper(), id);
        return newsModels.isEmpty() ? null : newsModels.get(0);
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "Select * from news where categoryid = ?";
        return query(sql, new NewsMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        StringBuilder sb = new StringBuilder("Insert into news (title, thumbnail, shortdescription, content, categoryid");
        sb.append(", createddate, createdby) values(?,?,?,?,?,?,?)");
        return insert(sb.toString(), newsModel.getTitle(), newsModel.getThumbnail(),newsModel.getShortDescription(),
                newsModel.getContent(), newsModel.getCategoryId(), newsModel.getCreatedDate(), newsModel.getCreatedBy());
    }

    @Override
    public void update(NewsModel updateNews) {

        StringBuilder sb = new StringBuilder("Update news set title = ?, thumbnail = ?, shortdescription = ?, content = ?");
        sb.append(", categoryid = ?, modifieddate = ?, modifiedby = ? where id = ?");
        update(sb.toString(), updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getShortDescription(), updateNews.getContent(),
                updateNews.getCategoryId(), updateNews.getModifiedDate(), updateNews.getModifiedBy(), updateNews.getId());
    }

    @Override
    public void delete(long id) {
        String sql = "Delete from news where id = ?";
        update(sql, id);
    }
}
