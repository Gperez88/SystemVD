package com.perezmejia.systemvd.service.inventory.impl;

import com.perezmejia.systemvd.entity.inventory.Category;
import com.perezmejia.systemvd.repository.inventory.CategoryRepository;
import com.perezmejia.systemvd.service.BaseService;
import com.perezmejia.systemvd.service.inventory.CategoryService;
import com.perezmejia.systemvd.view.inventory.CategoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryView> findAll() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();

        return new CategoryView().convertViewList(categories);
    }

    @Override
    public CategoryView findById(Long id) {
        return new CategoryView(categoryRepository.findOne(id));
    }

    @Override
    public void save(CategoryView categoryView) {
        Category category = categoryView.parse();
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
