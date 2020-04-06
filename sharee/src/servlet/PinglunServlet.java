package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;
import dao.Impl.PostDaoImpl;
import model.Post;
import model.User;

/**
 * Servlet implementation class PinglunServlet
 */
@WebServlet("/PinglunServlet")
public class PinglunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String post_id = request.getParameter("post_id");
		String post_stprey_id = request.getParameter("floor_id");
		String post_content = request.getParameter("content");
		int idd=Integer.parseInt(post_id);
		PostDao postdao = new PostDaoImpl();
		Post post = postdao.queryname(Integer.parseInt(post_id), Integer.parseInt(post_stprey_id));
		
		int post_to_uid = post.getPost_from_uid();
		String post_to_name = post.getPost_from_name();
		
		User user = (User) request.getSession().getAttribute("loginUser");
		
		int post_from_uid = user.getId();
		String post_from_name = user.getName();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		Post pinlunpost = new Post(Integer.parseInt(post_id),Integer.parseInt(post_stprey_id),post_from_uid,post_from_name,post_to_uid,post_to_name,post_content,formatter.format(date));
		postdao.savepost(pinlunpost);
		
		

		
		request.getRequestDispatcher("/PostServlet?id="+idd).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
