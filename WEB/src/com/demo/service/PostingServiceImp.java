package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.dao.PostingDao;
import com.demo.dao.PostingDaoImp;
import com.demo.domain.Posting;

import java.util.List;

public class PostingServiceImp implements PostingService {
    PostingDao dao = new PostingDaoImp();
    @Override
    public List<Posting> queryAllPosting() {
        return dao.queryAllPosting();
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        return dao.queryByPages(currentPage);
    }

    @Override
    public void deleteSelectPosting(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            dao.deletePostingById(ids[i]);
        }
    }
}
