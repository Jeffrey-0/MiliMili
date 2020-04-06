package com.demo.utils;

import java.sql.*;

public class JDBCUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/webstore?/useUnicode=true&characterEncoding=utf-8";// day0824要操作的数据库
    private static final String USER = "manager";
    private static final String PASSWORD = "manager";// 没有密码就写个双引号
    private static Connection ct = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    // 1.因为加载驱动只用加载一次，所有直接放到static代码块里面
    static {
        // 1.加载驱动
        try {
            Class.forName(DRIVER);
            System.out.println("加载驱动");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnnection() {

        Connection ct = null;
        try {
            ct = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ct;

    }

    // 3.封装一个方法可以完成查询:select * from user;
    public static ResultSet executeQuery(String sql, String[] strs) {
        // 1.获得连接
        try {
            ct = getConnnection();
            ps = ct.prepareStatement(sql);

            // 2.处理占位符问题：将占位符中的数据填充到sql语句中
            if (strs != null) {
                for (int i = 0; i < strs.length; i++) {
                    ps.setString(i + 1, strs[i]);
                }

            }
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

    public static int executeUpdate(String sql, String[] strs) {
        int in = 0;
        // 1.获得连接
        try {
            ct = getConnnection();
            ps = ct.prepareStatement(sql);
            // 2.处理占位符问题：将占位符中的数据填充到sql语句中
            if (strs != null) {
                for (int i = 0; i < strs.length; i++) {
                    ps.setString(i + 1, strs[i]);
                }

            }
            in = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            close(ct, ps, rs);
        }

        return in;

    }

    public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (ct != null) {
                ct.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }


    // 6.编写方法可以放回对象
    public static Connection getCt() {
        return ct;
    }

    public static PreparedStatement getPs() {
        return ps;
    }
}
