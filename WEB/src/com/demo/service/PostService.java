package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> queryAllPost();

    PageInfo queryByPages(Integer currentPage);

    void deleteSelectPost(String[] ids);
}
