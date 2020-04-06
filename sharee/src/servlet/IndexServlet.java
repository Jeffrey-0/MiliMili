package servlet;

import com.alibaba.fastjson.JSON;
import dao.ResDao;
import model.Resource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    ResDao rd = new ResDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //将最新的五条数据放上去
        if(request.getSession().getAttribute("adRes")==null){
            request.getSession().setAttribute("adRes",rd.queryRanRes(5));
        }
        request.setAttribute("newRes",rd.queryNewRes());
        //将随机的八条数据放上去
        if(request.getSession().getAttribute("ranRes")==null){
            request.getSession().setAttribute("ranRes",rd.queryRanRes(8));
        }
        //放上新番放送的五条
        request.setAttribute("fanRes", rd.queryResIndexCategory("新番放送"));
        request.setAttribute("cnRes", rd.queryResIndexCategory("国产动漫"));
        request.setAttribute("theaterRes", rd.queryResIndexCategory("剧场动画"));
        request.setAttribute("movieRes", rd.queryResIndexCategory("影视"));
        request.setAttribute("shareRes", rd.queryResIndexCategory("用户分享"));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
