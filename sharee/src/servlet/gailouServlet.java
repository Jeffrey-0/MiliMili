package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class gailouServlet
 */
@WebServlet("/gailouServlet")
public class gailouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String post_id = request.getParameter("post_id");
		String post_content = request.getParameter("content");
		int idd=Integer.parseInt(post_id);
		User user = (User) request.getSession().getAttribute("loginUser");
		
		int post_from_uid = user.getId();
		String post_from_name = user.getName();
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		PostDao postdao = new PostDaoImpl();
		int count = postdao.postnum(Integer.parseInt(post_id));
		count=count+1;
		Post pinlunpost = new Post(Integer.parseInt(post_id),count,post_from_uid,post_from_name,post_content,formatter.format(date));
		postdao.savegailou(pinlunpost);
		
		
		System.out.println(true);
		request.getRequestDispatcher("/PostServlet?id="+idd).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
