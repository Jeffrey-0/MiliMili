package com.demo.servlet;

import com.demo.bean.PageInfo;
import com.demo.service.UserService;
import com.demo.service.UserServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    AdminServlet adminServlet = new AdminServlet();
    UserService userService = new UserServiceImp();
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        System.out.println(method);
        if (method.equals("deleteUser")) {
            deleteUser(request, response);
        }else if (method.equals("deleteSelectedUser")) {
            deleteSelectedUser(request, response);
        }else if (method.equals("userManageJsp")) {
            userManageJsp(request, response);
        }else if (method.equals("changeSpeak")) {
            changeSpeak(request, response);
        }
    }

    private void userManageJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = userService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/user.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSelectedUser(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("id[]");
        userService.deleteSelectedUser(ids);
        userManageJsp(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        userService.deleteById(id);
        userManageJsp(request, response);
    }

    private void changeSpeak(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String speak = request.getParameter("speak");
        System.out.println(id+"  "+speak);
        userService.changeSpeak(id,speak);
        userManageJsp(request,response);
    }
}








