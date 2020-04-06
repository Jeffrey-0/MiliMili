package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Admin;

import java.util.List;

public interface AdminDao {
    Admin login(String username, String password);

    boolean changePassword(Integer id, String newPassword);

    List<Admin> queryAllAdmin();

    PageInfo queryByPages(Integer currentPage);

    boolean editByName(String aname, String adminName);

    boolean deleteAdminByName(String adminName);

    boolean addAdmin(String username, String password);

    void deleteAdminById(String id);
}
