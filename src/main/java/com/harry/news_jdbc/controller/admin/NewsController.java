package com.harry.news_jdbc.controller.admin;

import com.harry.news_jdbc.constant.SystemConstant;
import com.harry.news_jdbc.model.NewsModel;
import com.harry.news_jdbc.paging.PageRequest;
import com.harry.news_jdbc.paging.Pageble;
import com.harry.news_jdbc.service.INewsService;
import com.harry.news_jdbc.sort.Sorter;
import com.harry.news_jdbc.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {
    @Inject
    INewsService newsService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NewsModel newsModel = FormUtil.toModel(NewsModel.class, request);
        Pageble pageble = new PageRequest(newsModel.getPage(), newsModel.getMaxPageItem(),
                new Sorter(newsModel.getSortName(), newsModel.getSortBy()));
        newsModel.setListResult(newsService.findAll(pageble));
        newsModel.setTotalItem(newsService.getTotalItem());
        newsModel.setTotalPage((int) Math.ceil((double) newsModel.getTotalItem() / newsModel.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, newsModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/news/list.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }
}
