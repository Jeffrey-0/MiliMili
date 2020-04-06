package servlet.User;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		UserDao userDao = new UserDaoImpl();
		User user = userDao.queryByIdAndPwd(Integer.parseInt(id), password);
		if(user!=null) {
			request.getSession().setAttribute("username", user.getName());
			request.getSession().setAttribute("userId", user.getId());
			request.getSession().setAttribute("loginUser", user);
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		}
		else {
			try {
				   PrintWriter out = response.getWriter();
				   String a = URLEncoder.encode("账号或密码不正确!", "UTF-8"); 
			   out.print("<script language='javascript'>alert(decodeURIComponent('"+a+"'));window.location.href='login.jsp?method=sindex';</script>");
				   out.flush();
				   out.close();
				  } catch (IOException e) {
				   e.printStackTrace();
				  }
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
