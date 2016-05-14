package com.perezmejia.systemvd.view.inventory;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.inventory.WarehouseDetail;

/**
 * Created by Guil on 5/11/2016.
 */

@EntityMapper
public class WarehouseDetailView extends ParsableObject<WarehouseDetail, WarehouseDetailView> {
    @Mapping
    private Long id;
    @Mapping(otherType = true)
    private WarehouseView warehouse;
    @Mapping(otherType = true)
    private ProductView product;
    @Mapping
    private Long stock;

    public WarehouseDetailView(){}

    public WarehouseDetailView(WarehouseDetail warehouseDetail){
        load(warehouseDetail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WarehouseView getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseView warehouse) {
        this.warehouse = warehouse;
    }

    public ProductView getProduct() {
        return product;
    }

    public void setProduct(ProductView product) {
        this.product = product;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    @Override
    public Class<WarehouseDetail> getDomainClass() {
        return WarehouseDetail.class;
    }
}
