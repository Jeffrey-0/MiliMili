package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.PostDao;
import dao.Impl.PostDaoImpl;
import model.Post;
import model.Posting;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String post_id = request.getParameter("id");
		PostDao postdao = new PostDaoImpl();
		Posting posting = postdao.queryPosting(Integer.parseInt(post_id));
		//主标题
		String str = JSON.toJSONString(posting);
		request.setAttribute("str", str);
		
		//楼层首评论
		List<Post> list = postdao.querypost(Integer.parseInt(post_id));		
		String str1 = JSON.toJSONString(list);
		request.setAttribute("str1", str1);
		//楼层评论
		List<Post> list1 = postdao.querypostsss(Integer.parseInt(post_id));		
		String str2 = JSON.toJSONString(list1);
		request.setAttribute("str2", str2);
		
		
		
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
