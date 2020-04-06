package com.demo.dao;

import com.demo.bean.PageInfo;

public interface UserDao {
    PageInfo queryByPages(Integer currentPage);

    void deleteById(String id);

    void deleteUserById(String id);

    void insertUserByFor(int i);

    void changeSpeak(String id,String speak);
}
