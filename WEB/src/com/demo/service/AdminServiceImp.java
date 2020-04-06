package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.dao.AdminDao;
import com.demo.dao.AdminDaoImp;
import com.demo.domain.Admin;

import java.util.List;

public class AdminServiceImp implements AdminService {
    private AdminDao dao = new AdminDaoImp();
    @Override
    public Admin login(Admin admin) {
        return dao.login(admin.getUsername(),admin.getPassword());
    }

    @Override
    public boolean changePassword(Integer id, String newPassword2) {
        return dao.changePassword(id, newPassword2);
    }

    @Override
    public List<Admin> queryAllAdmin() {
        return dao.queryAllAdmin();
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        return dao.queryByPages(currentPage);
    }

    @Override
    public boolean editAdmin(String aname, String adminName) {
        return dao.editByName(aname, adminName);
    }

    @Override
    public boolean deleteAdminByName(String adminName) {
        return dao.deleteAdminByName(adminName);
    }

    @Override
    public boolean addAdmin(String aname, String password) {
        return dao.addAdmin(aname, password);
    }

    @Override
    public void deleteSelectAdmin(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            dao.deleteAdminById(ids[i]);
        }
    }
}
