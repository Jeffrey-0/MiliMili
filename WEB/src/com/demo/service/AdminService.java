package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.domain.Admin;

import java.util.List;

public interface AdminService {
    Admin login(Admin admin);

    boolean changePassword(Integer id, String newPassword2);

    List<Admin> queryAllAdmin();

    PageInfo queryByPages(Integer currentPage);

    boolean editAdmin(String aname, String adminName);

    boolean deleteAdminByName(String adminName);

    boolean addAdmin(String aname, String password);

    void deleteSelectAdmin(String[] ids);
}
