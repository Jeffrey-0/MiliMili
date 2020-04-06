package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Category;
import com.demo.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImp implements CategoryDao {
    @Override
    public boolean changeName(Integer id, String newName) {
        String sql = "update category set category_name=? where category_id=?";
        System.out.println(id);
        String[] strs = {newName,id.toString()};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Category> queryAllCategory() {
        ArrayList<Category> categoryList = new ArrayList<>();
        String sql = "select * from category";
        String[] strs ={};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        try {
            if (rs != null){
                while (rs.next()){
                    Category category = new Category();
                    category.setName(rs.getString("category_name"));
                    category.setDescn(rs.getString("category_descn"));
                    System.out.println(category.getName());
                    categoryList.add(category);
                }
                return categoryList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        List<Category> categoryList = new ArrayList<>();
        String sql ="select * from category limit "+(currentPage-1)*10+","+10;
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        System.out.println(rs);
        try {
            if (rs != null)
            {
                while (rs.next()){
                    Category category = new Category();
                    category.setName(rs.getString("category_name"));
                    category.setDescn(rs.getString("category_descn"));
                    category.setId(rs.getInt("category_id"));
                    System.out.println(category.getName());
                    categoryList.add(category);
                }
            }
            String countSql = "select count(category_id) as totalCategory from category";
            ResultSet executeQuery = JDBCUtil.executeQuery(countSql, strs);
            long totalCategory = 0L;
            if (executeQuery.next()){
                totalCategory = executeQuery.getLong("totalCategory");
            }
            PageInfo pageInfo = new PageInfo(categoryList, currentPage, totalCategory,1.0);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public boolean editByName(String aname, String categoryName) {
        String sql = "update category set category_name=? where category_name=?";
        String[] strs = {aname,categoryName};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteCategoryByName(String categoryName) {
        String sql = "delete from category where category_name=?";
        String[] strs = {categoryName};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean addCategory(String category_name, String category_descn) {
        String sql = "insert into category(category_name,category_descn) values(?,?)";
        String[] strs = {category_name,category_descn};
        int eu = JDBCUtil.executeUpdate(sql, strs);
        if (eu > 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void deleteCategoryById(String id) {
        String sql = "delete from category where category_id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }
}
