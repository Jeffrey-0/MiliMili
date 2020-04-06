package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.domain.Posting;

import java.util.List;

public interface PostingService {
    List<Posting> queryAllPosting();

    PageInfo queryByPages(Integer currentPage);

    void deleteSelectPosting(String[] ids);
}
