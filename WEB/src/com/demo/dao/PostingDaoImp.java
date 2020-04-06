package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Post;
import com.demo.domain.Posting;
import com.demo.utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostingDaoImp implements PostingDao{

    @Override
    public List<Posting> queryAllPosting() {
        ArrayList<Posting> postingList = new ArrayList<>();
        String sql = "select * from Posting order by post_title";
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        try {
            if (rs != null){
                while (rs.next()){
                    Posting posting = new Posting();
                    posting.setPost_id(rs.getInt("post_id"));
                    posting.setPost_title(rs.getString("post_title"));
                    posting.setPost_uid(rs.getInt("post_uid"));
                    posting.setPost_name(rs.getString("post_name"));
                    System.out.println(posting.getPost_title());
                    postingList.add(posting);
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
        List<Posting> postingList = new ArrayList<>();
        String sql ="select * from Posting limit "+(currentPage-1)*10+","+10;
        String[] strs = {};
        ResultSet rs = JDBCUtil.executeQuery(sql, strs);
        System.out.println(rs);
        try {
            if (rs != null)
            {
                while (rs.next()){
                    Posting posting = new Posting();
                    posting.setPost_id(rs.getInt("post_id"));
                    posting.setPost_title(rs.getString("post_title"));
                    posting.setPost_uid(rs.getInt("post_uid"));
                    posting.setPost_name(rs.getString("post_name"));
                    System.out.println(posting.getPost_title());
                    postingList.add(posting);
                }
            }
            String countSql = "select count(post_id) as totalPosting from Posting";
            ResultSet executeQuery = JDBCUtil.executeQuery(countSql, strs);
            long totalPosting = 0L;
            if (executeQuery.next()){
                totalPosting = executeQuery.getLong("totalPosting");
            }
            PageInfo pageInfo = new PageInfo(postingList, currentPage, totalPosting,true);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(JDBCUtil.getConnnection(),JDBCUtil.getPs(),rs);
        }
        return null;
    }

    @Override
    public void deletePostingById(String id) {
        String sql = "delete from Posting where post_id=?";
        String[] strs = {id};
        JDBCUtil.executeUpdate(sql,strs);
    }
}
