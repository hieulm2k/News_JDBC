package com.harry.news_jdbc.dao;

import com.harry.news_jdbc.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}