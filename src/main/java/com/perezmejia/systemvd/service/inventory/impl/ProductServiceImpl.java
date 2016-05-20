package com.perezmejia.systemvd.service.inventory.impl;

import com.perezmejia.systemvd.entity.inventory.Category;
import com.perezmejia.systemvd.entity.inventory.Product;
import com.perezmejia.systemvd.repository.inventory.CategoryRepository;
import com.perezmejia.systemvd.repository.inventory.ProductRepository;
import com.perezmejia.systemvd.service.inventory.CategoryService;
import com.perezmejia.systemvd.service.inventory.ProductService;
import com.perezmejia.systemvd.view.inventory.CategoryView;
import com.perezmejia.systemvd.view.inventory.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductView> findAll() {
        List<Product> products = (List<Product>) productRepository.findAll();

        return new ProductView().convertViewList(products);
    }

    @Override
    public ProductView findById(Long id) {
        return new ProductView(productRepository.findOne(id));
    }

    @Override
    public void save(ProductView productView) {
        Product product = productView.parse();
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
