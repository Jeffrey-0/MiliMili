package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.User;
import com.demo.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    @Override
    public PageInfo queryByPages(Integer currentPage) {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user limit " + (currentPage - 1) * 10 + "," + 10;
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        System.out.println(rs);
        long total = 0L;
        try {
            if (rs != null){
                while (rs.next()){
                    User user = new User();
                    user.setName(rs.getString("user_name"));
                    user.setId(rs.getInt("user_id"));
                    user.setSelfdescn(rs.getString("user_selfdescn"));
                    user.setSpeak(rs.getInt("user_speak"));
                    user.setNumber(rs.getString("user_number"));
                    userList.add(user);
                }
            }
            String countSql = "select count(user_id) as totalRecord from user";
            ResultSet executeQuery = JDBCUtil.executeQuery(countSql, strs);
            if (executeQuery.next()){
                total = executeQuery.getLong("totalRecord");
            }
            PageInfo pageInfo = new PageInfo(userList, currentPage, total, 1);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from user where user_id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }

    @Override
    public void deleteUserById(String id) {
        String sql = "delete from user where user_id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql, strs);
    }

    @Override
    public void insertUserByFor(int i) {
        String sql = "insert into user(user_name,user_password,user_selfdescn,user_speak,user_number) values(?,?,?,?,?)";
        String[] strs = {"用户"+i,"用户"+i,"用户"+i,"用户"+i,"用户"+i};
        JDBCUtil.executeUpdate(sql, strs);
    }

    @Override
    public void changeSpeak(String id,String speak) {
        String sql=null;
        System.out.println(speak);
        if (speak.equals("1"))
        {
            sql = "update user set user_speak = 0 where user_id = ?";
        }
        else {
            sql = "update user set user_speak = 1 where user_id = ?";
        }
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }
}
