package com.harry.news_jdbc.service;

import com.harry.news_jdbc.model.UserModel;

public interface IUserService {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
