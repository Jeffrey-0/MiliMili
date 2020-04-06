package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import utils.JdbcUtils;

import dao.PostDao;
import model.Post;
import model.Posting;


public class PostDaoImpl implements PostDao {

	public Posting queryPosting(Integer id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from Posting where post_id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet resultset = prepareStatement.executeQuery();
			//从结果集里面拿数据
			if(resultset.next()) {
				int post_uid = resultset.getInt("post_uid");
				String post_name = resultset.getString("post_name");
				
				String post_title = resultset.getString("post_title");
				Posting posting = new Posting(id,post_uid,post_title,post_name);
				return posting;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}	
		return null;
	}

	@Override
	public List<Post> querypost(Integer post_id) {
	
		List<Post> list = new ArrayList<Post>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from post where post_id=? and post_to_uid is null";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, post_id);
			ResultSet resultset = prepareStatement.executeQuery();
			while(resultset.next()) {
				
				String post_stprey_id=resultset.getString("post_stprey_id");
				String post_from_uid=resultset.getString("post_from_uid");
				String post_from_name=resultset.getString("post_from_name");
				String post_content=resultset.getString("post_content");
				Date post_date=new Date(resultset.getTimestamp("post_date").getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Post post=new Post(Integer.parseInt(post_from_uid),Integer.parseInt(post_stprey_id),post_from_name,post_content,sdf.format(post_date));
				list.add(post);	
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

	@Override
	public List<Post> querypostsss(Integer post_id) {
	
		List<Post> list = new ArrayList<Post>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from post where post_id=? and post_to_uid is not null";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, post_id);
			ResultSet resultset = prepareStatement.executeQuery();
			while(resultset.next()) {
				String post_stprey_id=resultset.getString("post_stprey_id");
				String post_from_name=resultset.getString("post_from_name");
				String post_content=resultset.getString("post_content");
				Date post_date=new Date(resultset.getTimestamp("post_date").getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Post post=new Post(Integer.parseInt(post_stprey_id),post_from_name,post_content,sdf.format(post_date));
				list.add(post);	
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

	@Override
	public Post queryname(Integer post_id, Integer post_stprey_id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from Post where post_id=? and post_stprey_id=? and post_to_uid is null";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, post_id);
			prepareStatement.setInt(2,post_stprey_id);
			ResultSet resultset = prepareStatement.executeQuery();
			//从结果集里面拿数据
			if(resultset.next()) {
				String post_from_name = resultset.getString("post_from_name");
				int post_from_uid = resultset.getInt("post_from_uid");
				Post post = new Post(post_from_uid,post_from_name);
				return post;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}	
		return null;
	}

	@Override
	public void savepost(Post post) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
	
		try {

			connection = JdbcUtils.getConnection();
		
			String sql = "insert into post (post_id,post_stprey_id,post_from_uid,post_from_name,post_to_uid,post_to_name,post_content,post_date) value(?,?,?,?,?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
	
			prepareStatement.setInt(1, post.getPost_id());
			prepareStatement.setInt(2, post.getPost_stprey_id());
			prepareStatement.setInt(3, post.getPost_from_uid());
			prepareStatement.setString(4, post.getPost_from_name());
			prepareStatement.setInt(5,post.getPost_to_uid());
			prepareStatement.setString(6, post.getPost_to_name());
			prepareStatement.setString(7, post.getPost_content());
			prepareStatement.setString(8,post.getPost_date());
			
			
			
		
			//执行sql
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		
	}

	@Override
	public int postnum(Integer post_id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int count=0;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select distinct post_stprey_id from Post where post_id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, post_id);
			ResultSet resultset = prepareStatement.executeQuery();
			//从结果集里面拿数据
			while(resultset.next()) {
				count++;				
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}	
		return count;
	}

	@Override
	public void savegailou(Post post) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
	
		try {

			connection = JdbcUtils.getConnection();
		
			String sql = "insert into post (post_id,post_stprey_id,post_from_uid,post_from_name,post_content,post_date) value(?,?,?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
	
			prepareStatement.setInt(1, post.getPost_id());
			prepareStatement.setInt(2, post.getPost_stprey_id());
			prepareStatement.setInt(3, post.getPost_from_uid());
			prepareStatement.setString(4, post.getPost_from_name());
		
			prepareStatement.setString(5, post.getPost_content());
			prepareStatement.setString(6,post.getPost_date());
			
			
			
		
			//执行sql
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		
	}



}
