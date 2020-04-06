package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class Communication
 */
@WebServlet("/Communication")
public class Communication extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType ("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PostingDao postingdao =new PostingDaoImpl();
		List<Posting> list = postingdao.queryPosting(1);
		
		String str = JSON.toJSONString(list);
		request.setAttribute("str", str);
					
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			//查询总记录数//这里
			String countSql = "select count(post_id) as totalRecord from posting";
			PreparedStatement prepareStatement2 = connection.prepareStatement(countSql);
			ResultSet resultset2 = prepareStatement2.executeQuery();
			long total = 0L;
			if(resultset2.next()) {
				total = resultset2.getLong("totalRecord");
			}	
			
			//System.out.print(b);
			request.getSession().setAttribute("total", Long.toString(total));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}




//		response.sendRedirect("/resource.jsp");
		request.getRequestDispatcher("/communication.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
