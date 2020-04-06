package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.PostingDao;
import dao.Impl.PostingDaoImpl;
import model.Posting;
import model.User;

/**
 * Servlet implementation class PostContent
 */
@WebServlet("/PostContent")
public class PostContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		String content = request.getParameter("Content");
			
		User user = (User) request.getSession().getAttribute("loginUser");
		
		
		
		
		PostingDao postingdao =new PostingDaoImpl();
		Posting posting = new Posting(user.getId(),content,user.getName());
		postingdao.save(posting);
				
		List<Posting> list = postingdao.queryPosting(1);
		
		String str = JSON.toJSONString(list);
		request.setAttribute("str", str);		
				
		request.getRequestDispatcher("/communication.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
