package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Post;
import com.demo.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImp implements PostDao {
    @Override
    public List<Post> queryAllPost() {
        ArrayList<Post> postList = new ArrayList<>();
        String sql = "select * from Post order by post_id";
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        try {
            if (rs != null){
                while (rs.next()){
                    Post post = new Post();
                    post.setId(rs.getInt("id"));
                    post.setPost_id(rs.getInt("post_id"));
                    post.setPost_stprey_id(rs.getInt("post_stprey_id"));
                    post.setPost_from_uid(rs.getInt("post_from_uid"));
                    post.setPost_to_uid(rs.getInt("post_to_uid"));
                    post.setPost_content(rs.getString("post_content"));
                    post.setPost_date(rs.getDate("post_date").toString());
                    post.setPost_from_name(rs.getString("post_from_name"));
                    post.setPost_to_name(rs.getString("post_to_name"));
                    postList.add(post);
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
        List<Post> postList = new ArrayList<>();
        String sql ="select * from Post limit "+(currentPage-1)*10+","+10;
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        System.out.println(rs);
        try {
            if (rs != null)
            {
                while (rs.next()){
                    Post post = new Post();
                    post.setId(rs.getInt("id"));
                    post.setPost_id(rs.getInt("post_id"));
                    post.setPost_stprey_id(rs.getInt("post_stprey_id"));
                    post.setPost_from_uid(rs.getInt("post_from_uid"));
                    post.setPost_to_uid(rs.getInt("post_to_uid"));
                    post.setPost_content(rs.getString("post_content"));
                    post.setPost_date(rs.getDate("post_date").toString());
                    post.setPost_from_name(rs.getString("post_from_name"));
                    post.setPost_to_name(rs.getString("post_to_name"));
                    postList.add(post);
                }
            }
            String countSql = "select count(id) as totalPost from Post";
            ResultSet executeQuery = JDBCUtil.executeQuery(countSql, strs);
            long totalPost = 0L;
            if (executeQuery.next()){
                totalPost = executeQuery.getLong("totalPost");
            }
            PageInfo pageInfo = new PageInfo(postList, currentPage, totalPost,new Post());
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public void deletePostById(String id) {
        String sql = "delete from Post where id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }
}
