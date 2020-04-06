package servlet;

import dao.ResDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/classily")
public class ClassilyServlet extends HttpServlet {
    ResDao rd = new ResDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String search = request.getParameter("search");
        String page = request.getParameter("page");
        String flag = request.getParameter("flag");
        String curRes = null;
        Integer pages = null;
        if("1".equals(flag)){
            curRes = rd.queryResByName(search,page);
            pages = rd.querySearchPages(search);
            request.getSession().setAttribute("flag", "1");
        }else if("3".equals(flag)){
            Integer userId = (Integer)request.getSession().getAttribute("userId");
            curRes = rd.queryResByUserId(userId, page);
            pages = rd.queryUserPages(userId);
            request.getSession().setAttribute("flag", "3");
            request.setAttribute("curRes",curRes);
            request.setAttribute("search",search);
            request.setAttribute("pages",pages);
            request.setAttribute("page",Integer.parseInt(page));
            request.getRequestDispatcher("my_resource.jsp").forward(request, response);
            return;
        } else if("全部".equals(search)){
            curRes = rd.queryAllRes(search,page);
            pages = rd.queryAllPages(search);
            request.getSession().setAttribute("flag","0");
        }else {
            curRes = rd.queryResByCategory(search,page);
            pages = rd.queryCategoryPages(search);
            request.getSession().setAttribute("flag","0");
        }
        request.setAttribute("curRes",curRes);
        request.setAttribute("search",search);
        request.setAttribute("pages",pages);
        request.setAttribute("page",Integer.parseInt(page));
        request.getRequestDispatcher("classily.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
