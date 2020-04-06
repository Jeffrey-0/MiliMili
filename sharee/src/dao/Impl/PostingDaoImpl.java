package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import dao.PostingDao;
import model.Posting;
import utils.JdbcUtils;

public class PostingDaoImpl implements PostingDao {


	
	public List<Posting> queryPosting(Integer current) {
		List<Posting> list = new ArrayList<Posting>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			
				connection = JdbcUtils.getConnection();
				String sql = "select * from posting LIMIT ?,?";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setInt(1, (current-1)*10);
				prepareStatement.setInt(2, 10);
				ResultSet resultset = prepareStatement.executeQuery();
				//从结果集里面拿数据
				while(resultset.next()) {
		
					int post_id = resultset.getInt("post_id");
					int post_uid = resultset.getInt("post_uid");
					String post_title = resultset.getString("post_title");
					String post_name = resultset.getString("post_name");
					 Posting posting = new Posting(post_id, post_uid, post_title, post_name);
					list.add(posting);
				
				}
				
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return list;
	}

	@Override
	public void save(Posting posting) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into Posting (post_uid,post_title,post_name) value(?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, posting.getPost_uid());
			prepareStatement.setString(2, posting.getPost_title());
			prepareStatement.setString(3, posting.getPost_name());
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}		
	
		
	}

}


