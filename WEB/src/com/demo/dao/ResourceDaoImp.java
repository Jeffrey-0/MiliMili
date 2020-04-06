package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Resource;
import com.demo.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceDaoImp implements ResourceDao {
    @Override
    public List<Resource> queryAllResource() {
        ArrayList<Resource> resourceList = new ArrayList<>();
        String sql = "select * from src";
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        try {
            if (rs != null){
                while (rs.next()){
                    Resource resource = new Resource();
                    resource.setId(rs.getInt("id"));
                    resource.setName(rs.getString("name"));
                    resource.setCategory(rs.getString("category"));
                    resource.setDescn(rs.getString("descn"));
                    resource.setCode(rs.getString("code"));
                    resource.setImg(rs.getString("img"));
                    resource.setDate(rs.getString("date"));
                    resource.setUploader(rs.getInt("uploader"));
                    resource.setLevel(rs.getString("level"));
                    resourceList.add(resource);
                }
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
        List<Resource> resourceList = new ArrayList<>();
        String sql ="select * from src limit "+(currentPage-1)*10+","+10;
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        System.out.println(rs);
        try {
            if (rs != null)
            {
                while (rs.next()){
                    Resource resource = new Resource();
                    resource.setId(rs.getInt("id"));
                    resource.setName(rs.getString("name"));
                    resource.setCategory(rs.getString("category"));
                    resource.setDescn(rs.getString("descn"));
                    resource.setCode(rs.getString("code"));
                    resource.setImg(rs.getString("img"));
                    resource.setDate(rs.getString("date"));
                    resource.setUploader(rs.getInt("uploader"));
                    resource.setLevel(rs.getString("level"));
                    resourceList.add(resource);
                }
            }
            String countSql = "select count(id) as totalResource from src";
            ResultSet executeQuery = JDBCUtil.executeQuery(countSql, strs);
            long totalResource = 0L;
            if (executeQuery.next()){
                totalResource = executeQuery.getLong("totalResource");
            }
            PageInfo pageInfo = new PageInfo(resourceList, currentPage, totalResource,'a');
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

//    @Override
//    public boolean deleteResourceByName(String categoryName) {
//        String sql = "delete from src where resource_name=?";
//        String[] strs = {categoryName};
//        int eu = JDBCUtil.executeUpdate(sql, strs);
//        if (eu > 0){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    @Override
    public void deleteResourceById(String id) {
        String sql = "delete from src where id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }
}
