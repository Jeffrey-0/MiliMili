package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.dao.ResourceDao;
import com.demo.dao.ResourceDaoImp;
import com.demo.domain.Resource;

import java.util.List;

public class ResourceServiceImp implements ResourceService {
    ResourceDao dao = new ResourceDaoImp();
    @Override
    public List<Resource> queryAllResource() {
        return dao.queryAllResource();
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        return dao.queryByPages(currentPage);
    }

//    @Override
//    public boolean deleteResourceByName(String resourceName) {
//        return dao.deleteResourceByName(resourceName);
//    }

    @Override
    public void deleteSelectResource(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            dao.deleteResourceById(ids[i]);
        }
    }
}
