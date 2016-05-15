package com.perezmejia.systemvd.view.sale;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.gp89developers.mapperobject.utils.CollectionUtils;
import com.perezmejia.systemvd.entity.sale.Sale;
import com.perezmejia.systemvd.view.ClientView;
import com.perezmejia.systemvd.view.security.UserView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Guil on 5/14/2016.
 */

@EntityMapper
public class SaleView extends ParsableObject<Sale, SaleView> {
    @Mapping
    private Long id;
    @Mapping(otherType = true)
    private ClientView client;
    @Mapping(otherType = true)
    private UserView user;
    @Mapping
    private Timestamp createDate;
    @Mapping
    private Timestamp modifyDate;
    //manual mapping
    private List<SaleDetailView> details;

    public SaleView() {
    }

    public SaleView(Sale sale) {
        load(sale);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientView getClient() {
        return client;
    }

    public void setClient(ClientView client) {
        this.client = client;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
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

    public List<SaleDetailView> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetailView> details) {
        this.details = details;
    }

    @Override
    public SaleView load(Sale sale) {
        SaleView saleView = super.load(sale);

        if (!CollectionUtils.isEmpty(sale.getDetails())) {
            List<SaleDetailView> saleDetailViews = new ArrayList<>();
            sale.getDetails().forEach(saleDetail -> saleDetailViews.add(new SaleDetailView(saleDetail)));
            saleView.setDetails(saleDetailViews);
        }

        return saleView;
    }

    @Override
    public Class<Sale> getDomainClass() {
        return Sale.class;
    }
}
