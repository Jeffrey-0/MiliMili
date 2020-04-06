package servlet;

import dao.ResDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteResource")
public class DeleteResServlet extends HttpServlet {
    ResDao rd = new ResDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer count = rd.deleteById(id);
        if(count==0){
            System.out.println("删除失败！");
        }else{
            System.out.println("删除成功！");
        }
        request.getRequestDispatcher("classily?page=1&flag=3").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
