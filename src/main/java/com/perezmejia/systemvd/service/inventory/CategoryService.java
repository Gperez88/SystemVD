package com.perezmejia.systemvd.service.inventory;

import com.perezmejia.systemvd.entity.inventory.Category;
import com.perezmejia.systemvd.helper.mapperobject.MapperObject;
import com.perezmejia.systemvd.helper.mapperobject.TypeToken;
import com.perezmejia.systemvd.repository.inventory.CategoryRepository;
import com.perezmejia.systemvd.service.BaseService;
import com.perezmejia.systemvd.view.inventory.CategoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class CategoryService implements BaseService<CategoryView> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryView> findAll() {
        Type categoryListType = new TypeToken<List<CategoryView>>() {}.getType();
        List<Category> categories = (List<Category>) categoryRepository.findAll();

        return MapperObject.getInstance().map(categories, categoryListType);
    }

    @Override
    public CategoryView findById(Integer id) {
        return new CategoryView(categoryRepository.findById(id));
    }

    @Override
    public void save(CategoryView categoryView) {
        Category category = categoryView.parse();
        categoryRepository.save(category);
    }
}
