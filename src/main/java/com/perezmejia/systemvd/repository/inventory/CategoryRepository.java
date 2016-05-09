package com.perezmejia.systemvd.repository.inventory;

import com.perezmejia.systemvd.entity.inventory.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Guil on 5/8/2016.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public Category findById(Integer id);
}
