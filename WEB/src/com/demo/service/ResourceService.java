package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.domain.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> queryAllResource();

    PageInfo queryByPages(Integer currentPage);

//    boolean deleteResourceByName(String resourceName);

    void deleteSelectResource(String[] ids);
}
