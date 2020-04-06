package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Posting;

import java.util.List;

public interface PostingDao {
    List<Posting> queryAllPosting();

    PageInfo queryByPages(Integer currentPage);

    void deletePostingById(String id);
}
