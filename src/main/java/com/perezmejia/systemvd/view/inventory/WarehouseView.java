package com.perezmejia.systemvd.view.inventory;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.gp89developers.mapperobject.utils.CollectionUtils;;
import com.perezmejia.systemvd.entity.inventory.Warehouse;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guil on 5/11/2016.
 */

@EntityMapper
public class WarehouseView extends ParsableObject<Warehouse, WarehouseView> {
    @Mapping
    private Long id;
    @Mapping
    @NotNull
    @Size(max = 100)
    private String name;
    @Mapping
    @NotNull
    @Size(max = 300)
    private String description;
    @Mapping
    private Timestamp createDate;
    @Mapping
    private Timestamp modifyDate;
    @Mapping
    private int active;
    //manual mapper
    private List<WarehouseDetailView> warehouseDetails;

    public WarehouseView(){}

    public WarehouseView(Warehouse warehouse){
        load(warehouse);
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

    public List<WarehouseDetailView> getWarehouseDetails() {
        return warehouseDetails;
    }

    public void setWarehouseDetails(List<WarehouseDetailView> warehouseDetails) {
        this.warehouseDetails = warehouseDetails;
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
    public WarehouseView load(Warehouse warehouse) {
        WarehouseView warehouseView = super.load(warehouse);

        if (!CollectionUtils.isEmpty(warehouse.getWarehouseDetails())) {
            List<WarehouseDetailView> warehouseDetailViews = new ArrayList<>();
            warehouse.getWarehouseDetails()
                    .forEach(warehouseDetail -> warehouseDetailViews.add(new WarehouseDetailView(warehouseDetail)));
        }

        return warehouseView;
    }

    @Override
    public Class<Warehouse> getDomainClass() {
        return Warehouse.class;
    }
}
