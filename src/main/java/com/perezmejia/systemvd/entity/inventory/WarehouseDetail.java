package com.perezmejia.systemvd.entity.inventory;

import javax.persistence.*;

/**
 * Created by Guil on 5/11/2016.
 */

@Entity
@Table(name = "warehouse_detail", schema = "systemvd")
public class WarehouseDetail {
    private Long id;
    private Warehouse warehouse;
    private Product product;
    private Long stock;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Basic
    @Column(name = "stock")
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
