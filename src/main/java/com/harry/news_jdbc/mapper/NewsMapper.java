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
            return newsModel;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
