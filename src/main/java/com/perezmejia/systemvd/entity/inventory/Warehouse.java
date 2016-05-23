package com.perezmejia.systemvd.entity.inventory;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Guil on 5/11/2016.
 */

@Entity
@Table(name = "warehouse", schema = "systemvd")
public class Warehouse {
    private Long id;
    private String name;
    private String description;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private int active;
    private List<WarehouseDetail> warehouseDetails;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
    public List<WarehouseDetail> getWarehouseDetails() {
        return warehouseDetails;
    }

    public void setWarehouseDetails(List<WarehouseDetail> warehouseDetails) {
        this.warehouseDetails = warehouseDetails;
    }

    @Basic
    @Column(name = "create_date", nullable = false, updatable=false)
    @CreationTimestamp
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modify_date")
    @UpdateTimestamp
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
