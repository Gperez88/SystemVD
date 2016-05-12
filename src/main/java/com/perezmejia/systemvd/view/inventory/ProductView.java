package com.perezmejia.systemvd.view.inventory;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.inventory.Category;
import com.perezmejia.systemvd.entity.inventory.Product;

import java.sql.Timestamp;

/**
 * Created by Guil on 5/10/2016.
 */

@EntityMapper
public class ProductView extends ParsableObject<Product, ProductView> {
    @Mapping
    private Long id;
    @Mapping
    private String name;
    @Mapping
    private String description;
    @Mapping
    private int inventoryMin;
    @Mapping
    private float price;
    @Mapping
    private String unit;
    @Mapping(otherType = true)
    private CategoryView category;
    @Mapping
    private Timestamp createDate;
    @Mapping
    private Timestamp modifyDate;
    @Mapping
    private int active;

    public ProductView() {
    }

    public ProductView(Product product) {
        load(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventoryMin() {
        return inventoryMin;
    }

    public void setInventoryMin(int inventoryMin) {
        this.inventoryMin = inventoryMin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public CategoryView getCategory() {
        return category;
    }

    public void setCategory(CategoryView category) {
        this.category = category;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public Class<Product> getDomainClass() {
        return Product.class;
    }
}
