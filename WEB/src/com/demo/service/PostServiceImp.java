package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.dao.PostDao;
import com.demo.dao.PostDaoImp;
import com.demo.domain.Post;

import java.util.List;

public class PostServiceImp implements PostService{
    PostDao dao = new PostDaoImp();
    @Override
    public List<Post> queryAllPost() {
        return dao.queryAllPost();
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        return dao.queryByPages(currentPage);
    }

    @Override
    public void deleteSelectPost(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            dao.deletePostById(ids[i]);
        }
    }
}
