package com.perezmejia.systemvd.view.inventory;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.inventory.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Created by Guil on 5/8/2016.
 */
@EntityMapper
public class CategoryView extends ParsableObject<Category, CategoryView> {
    @Mapping
    private Long id;
    @Mapping
    @NotNull
    @Size(max = 100)
    private String name;
    @Mapping
    @NotNull
    @Size(max = 100)
    private String description;
    @Mapping
    private Timestamp createDate;
    @Mapping
    private Timestamp modifyDate;

    public CategoryView() {
    }

    public CategoryView(Category category) {
        load(category);
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

    @Override
    public Class<Category> getDomainClass() {
        return Category.class;
    }
}
