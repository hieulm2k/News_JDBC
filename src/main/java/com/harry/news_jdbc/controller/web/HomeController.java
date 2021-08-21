package com.harry.news_jdbc.controller.web;

import com.harry.news_jdbc.model.NewsModel;
import com.harry.news_jdbc.model.UserModel;
import com.harry.news_jdbc.service.ICategoryService;
import com.harry.news_jdbc.service.INewsService;

import java.io.*;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewsService newsService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NewsModel newsModel = new NewsModel();
        newsModel.setTitle("bai viet test");
        newsModel.setContent("Day la bai viet dau tien cua minh!");
        newsModel.setCategoryId(1L);
        newsService.save(newsModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/home.jsp");
        requestDispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }

    public void destroy() {
    }
}