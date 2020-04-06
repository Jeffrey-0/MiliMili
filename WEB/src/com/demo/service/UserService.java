package com.demo.service;

import com.demo.bean.PageInfo;

public interface UserService {
    PageInfo queryByPages(Integer currentPage);

    void deleteById(String id);

    void deleteSelectedUser(String[] ids);

    void changeSpeak(String id,String speak);
}
