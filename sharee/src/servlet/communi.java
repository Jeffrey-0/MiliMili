package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import utils.JdbcUtils;

/**
 * Servlet implementation class communi
 */
@WebServlet("/communi")
public class communi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String current = request.getParameter("page");
		int current1=Integer.parseInt(current);
		PostingDao postingdao =new PostingDaoImpl();
		List<Posting> list = postingdao.queryPosting(current1);
		
		String str = JSON.toJSONString(list);
		request.setAttribute("str", str);
		 
		request.getRequestDispatcher("/communication.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
