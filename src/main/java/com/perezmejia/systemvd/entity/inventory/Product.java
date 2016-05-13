package com.perezmejia.systemvd.entity.inventory;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Guil on 5/7/2016.
 */

@Entity
@Table(name = "product", schema = "systemvd")
public class Product {
    private Long id;
    private String name;
    private String description;
    private int inventoryMin;
    private float price;
    private String unit;
    private Category category;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private int active;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "inventary_min")
    public int getInventoryMin() {
        return inventoryMin;
    }

    public void setInventoryMin(int inventoryMin) {
        this.inventoryMin = inventoryMin;
    }

    @Basic
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date")
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "is_active")
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
