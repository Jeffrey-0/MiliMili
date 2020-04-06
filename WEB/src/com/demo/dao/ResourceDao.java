package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Resource;

import java.util.List;

public interface ResourceDao {
    List<Resource> queryAllResource();

    PageInfo queryByPages(Integer currentPage);

//    boolean deleteResourceByName(String categoryName);

    void deleteResourceById(String id);
}
