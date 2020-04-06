package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Post;
import java.util.List;

public interface PostDao {
    List<Post> queryAllPost();

    PageInfo queryByPages(Integer currentPage);

    void deletePostById(String id);
}
