package com.harry.news_jdbc.mapper;

import com.harry.news_jdbc.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<NewsModel>{

    @Override
    public NewsModel mapRow(ResultSet rs) {
        try {
            NewsModel newsModel = new NewsModel();
            newsModel.setId(rs.getLong("id"));
            newsModel.setTitle(rs.getString("title"));
            newsModel.setContent(rs.getString("content"));
            newsModel.setCategoryId(rs.getLong("categoryid"));
            newsModel.setThumbnail(rs.getString("thumbnail"));
            newsModel.setShortDescription(rs.getString("shortdescription"));
            newsModel.setCreatedBy(rs.getString("createdby"));
            newsModel.setCreatedDate(rs.getTimestamp("createddate"));
            if(rs.getTimestamp("modifieddate")!=null){
                newsModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if(rs.getTimestamp("modifiedby")!=null){
                newsModel.setModifiedBy(rs.getString("modifiedby"));
            }
            return newsModel;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
