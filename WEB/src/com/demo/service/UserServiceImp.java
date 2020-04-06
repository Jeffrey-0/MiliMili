package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImp;

public class UserServiceImp implements UserService{
    UserDao dao = new UserDaoImp();
    @Override
    public PageInfo queryByPages(Integer currentPage) {
        return dao.queryByPages(currentPage);
    }

    @Override
    public void deleteById(String id) {
        dao.deleteById(id);
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            dao.deleteUserById(ids[i]);
        }
    }

    @Override
    public void changeSpeak(String id,String speak) {
        dao.changeSpeak(id,speak);
    }
}
