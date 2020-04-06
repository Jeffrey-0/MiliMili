package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Admin;
import com.demo.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImp implements AdminDao {
    @Override
    public Admin login(String username, String password) {
        ResultSet eq = null;
        try {
            String sql = "select * from admin where admin_username=? and admin_password=?";
            String[] strs = { username,password };
            eq = JDBCUtil.executeQuery(sql,strs);
            Admin admin = new Admin();
            if (eq != null)
            {
                while (eq.next()){
                    int id = eq.getInt("admin_id");
                    String adminUsername = eq.getString("admin_username");
                    String adminPassword = eq.getString("admin_password");
                    return new Admin(id,adminUsername,adminPassword);
                }
            }
            else{
                return null;
            }
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),eq);
        }
        return null;
    }

    @Override
    public boolean changePassword(Integer id, String newPassword) {
        String sql = "update admin set admin_password=? where admin_id=?";
        System.out.println(id);
        String[] strs = {newPassword,id.toString()};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Admin> queryAllAdmin() {
        List<Admin> adminList = new ArrayList<>();
        String sql = "select * from admin";
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        try {
            if (rs != null)
            {
                while (rs.next()){
                    Admin admin = new Admin();
                    admin.setUsername(rs.getString("admin_username"));
                    System.out.println(admin.getUsername());
                    adminList.add(admin);
                }
                return adminList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        List<Admin> adminList = new ArrayList<>();
        String sql ="select * from admin limit "+(currentPage-1)*10+","+10;
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        System.out.println(rs);
        try {
            if (rs != null)
            {
                while (rs.next()){
                    Admin admin = new Admin();
                    admin.setUsername(rs.getString("admin_username"));
                    admin.setId(rs.getInt("admin_id"));
                    System.out.println(admin.getUsername());
                    adminList.add(admin);
                }
            }
            String countSql = "select count(admin_id) as totalRecord from admin";
            ResultSet executeQuery = JDBCUtil.executeQuery(countSql, strs);
            long total = 0L;
            if (executeQuery.next()){
                total = executeQuery.getLong("totalRecord");
            }
            PageInfo pageInfo = new PageInfo(adminList, currentPage, total);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public boolean editByName(String aname, String adminName) {
        String sql = "update admin set admin_username=? where admin_username=?";
        String[] strs = {aname,adminName};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean deleteAdminByName(String adminName) {
        String sql = "delete from admin where admin_username=?";
        String[] strs = {adminName};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean addAdmin(String username, String password) {
        String sql = "insert into admin(admin_username,admin_password) values(?,?)";
        String[] strs = {username,password};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public void deleteAdminById(String id) {
        String sql = "delete from admin where admin_id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }
}
