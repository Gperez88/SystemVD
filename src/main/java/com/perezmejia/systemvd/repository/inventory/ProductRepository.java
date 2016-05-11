package com.perezmejia.systemvd.repository.inventory;

import com.perezmejia.systemvd.entity.inventory.Category;
import com.perezmejia.systemvd.entity.inventory.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Guil on 5/8/2016.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
