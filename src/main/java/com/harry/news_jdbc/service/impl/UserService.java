package com.harry.news_jdbc.service.impl;

import com.harry.news_jdbc.dao.IUserDAO;
import com.harry.news_jdbc.dao.impl.UserDAO;
import com.harry.news_jdbc.model.UserModel;
import com.harry.news_jdbc.service.IUserService;

public class UserService implements IUserService {

    private IUserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

}