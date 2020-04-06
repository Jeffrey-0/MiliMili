package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.JdbcUtils;

import dao.UserDao;
import model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User queryByIdAndPwd(int id, String password) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user where user_id=? and user_password=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, password);
			ResultSet resultset = prepareStatement.executeQuery();
			if(resultset.next()) {			
				String name = resultset.getString("user_name");
				String speak = resultset.getString("user_speak");
				User user = new User(id, name,speak);
				user.setId(id);
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	
	}

	@Override
	public void save(User user) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into user (user_id,user_name,user_password,user_selfdescn,user_speak,user_number) value(?,?,?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setString(4, user.getSelfdescn());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setInt(5, 1);
			prepareStatement.setString(6,user.getPhonenumber());
			prepareStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}		
	}

	@Override
	public User queryById(int id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user where user_id=?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet resultset = prepareStatement.executeQuery();
			if(resultset.next()) {
			
				return new User(id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(connection, prepareStatement, null);
		}
		return null;
	}

}
