package com.harry.news_jdbc.controller.web;

import com.harry.news_jdbc.constant.SystemConstant;
import com.harry.news_jdbc.model.UserModel;
import com.harry.news_jdbc.service.ICategoryService;
import com.harry.news_jdbc.service.IUserService;
import com.harry.news_jdbc.utils.FormUtil;
import com.harry.news_jdbc.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/home", "/login", "/logout"})
public class HomeController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;

    @Inject
    private IUserService userService;

    ResourceBundle myBundle = ResourceBundle.getBundle("message");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            String message = request.getParameter("message");
            String alert = request.getParameter("alert");
            if(message != null && alert!=null){
                request.setAttribute("message", myBundle.getString(message));
                request.setAttribute("alert", alert);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("categories", categoryService.findAll());
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
            rd.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if(action!=null && action.equals("login")){
            UserModel userModel = FormUtil.toModel(UserModel.class, request);
            userModel = userService.findByUserNameAndPasswordAndStatus(userModel.getUserName(), userModel.getPassword(),1);
            if(userModel != null){
                SessionUtil.getInstance().putValue(request, "USERMODEL", userModel);
                if(userModel.getRole().getCode().equals(SystemConstant.USER)){
                    response.sendRedirect(request.getContextPath() + "/home");
                } else if(userModel.getRole().getCode().equals(SystemConstant.ADMIN)){
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }

    public void destroy() {
    }
}