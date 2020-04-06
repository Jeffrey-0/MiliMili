package com.demo.dao;

import com.demo.bean.PageInfo;
import com.demo.domain.Category;

import java.util.List;

public interface CategoryDao {
    boolean changeName(Integer id,String newName);

    List<Category> queryAllCategory();

    PageInfo queryByPages(Integer currentPage);

    boolean editByName(String aname,String categoryName);

    boolean deleteCategoryByName(String categoryName);

    boolean addCategory(String category_name,String category_descn);

    void deleteCategoryById(String id);
}
