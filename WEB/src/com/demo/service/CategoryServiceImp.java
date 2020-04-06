package com.demo.service;

import com.demo.bean.PageInfo;
import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImp;
import com.demo.domain.Category;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    private CategoryDao dao = new CategoryDaoImp();
    @Override
    public boolean changeName(Integer id, String newName) {
        return dao.changeName(id, newName);
    }

    @Override
    public List<Category> queryAllCategory() {
        return dao.queryAllCategory();
    }

    @Override
    public PageInfo queryByPages(Integer currentPage) {
        return dao.queryByPages(currentPage);
    }

    @Override
    public boolean editCategory(String aname, String categoryName) {
        return dao.editByName(aname, categoryName);
    }

    @Override
    public boolean deleteCategoryByName(String categoryName) {
        return dao.deleteCategoryByName(categoryName);
    }

    @Override
    public boolean addCategory(String category_name, String category_descn) {
        return dao.addCategory(category_name, category_descn);
    }

    @Override
    public void deleteSelectCategory(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            dao.deleteCategoryById(ids[i]);
        }
    }
}
