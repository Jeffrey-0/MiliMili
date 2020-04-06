package com.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import com.demo.bean.PageInfo;
import com.demo.domain.Admin;
import com.demo.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Admin admin = new Admin();
    AdminService adminService = new AdminServiceImp();
    UserService userService = new UserServiceImp();
    CategoryService categoryService = new CategoryServiceImp();
    ResourceService resourceService = new ResourceServiceImp();
    PostingService postingService = new PostingServiceImp();
    PostService postService = new PostServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        System.out.println(method);
        if (method.equals("adminLogin")){
            adminLogin(request,response);
        } else if (method.equals("indexJsp")) {
            indexJsp(request,response);
        } else if (method.equals("userManageJsp")){
            userManageJsp(request, response);
        } else if (method.equals("adminManageJsp")){
            adminManageJsp(request,response);
        } else if (method.equals("addAdminJsp")){
            addAdminJsp(request,response);
        } else if (method.equals("addAdmin")){
            addAdmin(request,response);
        } else if (method.equals("deleteSelectAdmin")){
            deleteSelectAdmin(request,response);
        } else if (method.equals("deleteAdmin")){
            deleteAdmin(request,response);
        } else if (method.equals("editAdminJsp")){
            editAdminJsp(request,response);
        } else if (method.equals("editAdmin")){
            editAdmin(request,response);
        } else if (method.equals("changePasswordJsp")){
            changePasswordJsp(request,response);
        } else if (method.equals("changePassword")){
            changePassword(request,response);
        } else if (method.equals("categoryManageJsp")){
            categoryManageJsp(request,response);
        } else if (method.equals("deleteCategory")){
            deleteCategory(request,response);
        } else if (method.equals("editCategoryJsp")){
            editCategoryJsp(request,response);
        } else if (method.equals("editCategory")){
            editCategory(request,response);
        } else if (method.equals("addCategoryJsp")){
            addCategoryJsp(request,response);
        } else if (method.equals("addCategory")){
            addCategory(request,response);
        } else if (method.equals("deleteSelectCategory")){
            deleteSelectCategory(request,response);
        } else if (method.equals("resourceManageJsp")){
            resourceManageJsp(request,response);
        } else if (method.equals("deleteSelectResource")){
            deleteSelectResource(request,response);
        } else if (method.equals("deleteResource")){
            deleteResource(request,response);
        } else if (method.equals("postingManageJsp")){
            postingManageJsp(request,response);
        } else if (method.equals("deletePosting")){
            deletePosting(request, response);
        } else if (method.equals("deleteSelectPosting")){
            deleteSelectPosting(request, response);
        } else if (method.equals("postManageJsp")){
            postManageJsp(request,response);
        } else if (method.equals("deletePost")){
            deletePost(request, response);
        } else if (method.equals("deleteSelectPost")){
            deleteSelectPost(request, response);
        }
    }

    private void postManageJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = postService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager_post.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) {
        String postID[] = {request.getParameter("postID")};
        postService.deleteSelectPost(postID);
        postManageJsp(request, response);
    }

    private void deleteSelectPost(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("id[]");
        postService.deleteSelectPost(ids);
        postManageJsp(request, response);
    }


    private void postingManageJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = postingService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager_posting.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePosting(HttpServletRequest request, HttpServletResponse response) {
        String postingID[] = {request.getParameter("postingID")};
        postingService.deleteSelectPosting(postingID);
        postingManageJsp(request, response);
    }

    private void deleteSelectPosting(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("id[]");
        postingService.deleteSelectPosting(ids);
        postingManageJsp(request, response);
    }

    private void deleteResource(HttpServletRequest request, HttpServletResponse response) {
        String resourceID[] = {request.getParameter("resourceID")};
        resourceService.deleteSelectResource(resourceID);
        resourceManageJsp(request, response);
    }

    private void deleteSelectResource(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("id[]");
        resourceService.deleteSelectResource(ids);
        resourceManageJsp(request, response);
    }

    private void resourceManageJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = resourceService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager_resource.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSelectCategory(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("id[]");
        categoryService.deleteSelectCategory(ids);
        categoryManageJsp(request, response);
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {
        String aname = request.getParameter("aname");
        String descn = request.getParameter("descn");
        boolean b =categoryService.addCategory(aname, descn);
        JSONObject json = new JSONObject();
        if (b){
            json.put("status","1");
            json.put("message","资源类型添加成功");
            System.out.println("添加成功");
        }
        else{
            json.put("status","0");
            json.put("message","添加失败，资源类型已存在");
            System.out.println("添加失败");
        }
        response.setCharacterEncoding("UTF-8");
        System.out.println(json);
        System.out.println(json.toJSONString());
        try {
            PrintWriter out = response.getWriter();
            out.print(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCategoryJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/add_category.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            String aname = request.getParameter("aname");
            String categoryName = (String) request.getSession().getAttribute("categoryName");
            boolean b = categoryService.editCategory(aname, categoryName);
            JSONObject json = new JSONObject();
            if (b) {
                json.put("status","1");
                json.put("message","修改成功");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print(json);
                categoryManageJsp(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCategoryJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            String categoryName = request.getParameter("categoryName");
            request.getSession().setAttribute("categoryName",categoryName);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/edit_category.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        String categoryName = request.getParameter("categoryName");
        boolean b = categoryService.deleteCategoryByName(categoryName);
        if (b){
            System.out.println("删除成功！");
        }
        else {
            System.out.println("删除失败！");
        }
        categoryManageJsp(request, response);
    }

    private void categoryManageJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = categoryService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager_category.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) {
        admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        String newpassword1 = request.getParameter("password");
        String newpassword2 = request.getParameter("password2");
        Integer id = admin.getId();
        boolean b = adminService.changePassword(id, newpassword2);
        JSONObject json = new JSONObject();
        if (b){
            json.put("status","1");
            json.put("redirect",true);
            json.put("message","修改成功，请重新登录");
        }
        else {
            json.put("status","0");
            json.put("message","修改失败");
        }
        response.setCharacterEncoding("UTF-8");
        System.out.println(json);
        System.out.println(json.toJSONString());
        try {
            PrintWriter out = response.getWriter();
            out.print(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void changePasswordJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/change_password.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editAdmin(HttpServletRequest request, HttpServletResponse response) {
        try {
            String aname = request.getParameter("aname");
            String adminName = (String) request.getSession().getAttribute("adminName");
            boolean b = adminService.editAdmin(aname, adminName);
            JSONObject json = new JSONObject();
            if (b){
                json.put("status","1");
                json.put("message","修改成功");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print(json);
                adminManageJsp(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void editAdminJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            String adminName = request.getParameter("adminName");
            request.getSession().setAttribute("adminName",adminName);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/edit_admin.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
        String adminID[] = {request.getParameter("adminID")};
        adminService.deleteSelectAdmin(adminID);
        adminManageJsp(request, response);
    }

    private void deleteSelectAdmin(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("id[]");
        adminService.deleteSelectAdmin(ids);
        adminManageJsp(request, response);
    }

    private void addAdmin(HttpServletRequest request, HttpServletResponse response) {
        String aname = request.getParameter("aname");
        String password = request.getParameter("password");
        boolean b = adminService.addAdmin(aname, password);
        JSONObject json = new JSONObject();
        if (b){
            json.put("status","1");
            json.put("message","管理员添加成功");
            System.out.println("添加成功");
        }
        else{
            json.put("status","0");
            json.put("message","添加失败，用户已存在");
            System.out.println("添加失败");
        }
        response.setCharacterEncoding("UTF-8");
        System.out.println(json);
        System.out.println(json.toJSONString());
        try {
            PrintWriter out = response.getWriter();
            out.print(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addAdminJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/add_admin.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adminManageJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = adminService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager_admin.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        admin.setUsername(username);
        admin.setPassword(password);
        Admin admin1 = adminService.login(admin);
        admin = admin1;
        JSONObject json = new JSONObject();
        System.out.println(admin1.getId());
        if (admin1.getId() != null){
            try {
                request.getSession().setAttribute("admin",admin);
                json.put("status","1");
                json.put("message",admin.getUsername());
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                json.put("status","0");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void userManageJsp(HttpServletRequest request,HttpServletResponse response){
        //管理员总览页面之前对数据进行处理
        try {
            Integer currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && currentPageStr.trim() != ""){
                currentPage = Integer.parseInt(currentPageStr);
            }
            PageInfo pageInfo = userService.queryByPages(currentPage);
            request.setAttribute("pageInfo",pageInfo);
            request.setAttribute("currentPage",currentPage);
            pageInfo.getUserList();
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/user.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void indexJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
