package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * jdbc通用工具类
 */
public class JdbcUtils {
	
	//定义连接参数
	private static	String url = "jdbc:mysql://localhost:3306/webstore?characterEncoding=utf-8";
	private static	String username = "manager";
	private static	String password = "manager";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("注册驱动失败");
		}
	}

	
	
	public static Connection getConnection() throws Exception {
		//获取连接
		return DriverManager.getConnection(url, username, password);
	}
	
	
	
	public static void close(Connection connection,PreparedStatement prepareStatement,ResultSet resultSet) {
		//释放资源
		if(resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(prepareStatement!=null) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
