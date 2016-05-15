package com.perezmejia.systemvd.view.sale;

import com.gp89developers.mapperobject.EntityMapper;
import com.gp89developers.mapperobject.Mapping;
import com.gp89developers.mapperobject.ParsableObject;
import com.perezmejia.systemvd.entity.sale.SaleDetail;
import com.perezmejia.systemvd.view.inventory.ProductView;

/**
 * Created by Guil on 5/14/2016.
 */

@EntityMapper
public class SaleDetailView extends ParsableObject<SaleDetail, SaleDetailView> {
    @Mapping
    private Long id;
    @Mapping
    private Long quantity;
    @Mapping
    private float total_price;
    @Mapping(otherType = true)
    private ProductView product;
    @Mapping(otherType = true)
    private SaleView sale;

    public SaleDetailView() {
    }

    public SaleDetailView(SaleDetail saleDetail) {
        load(saleDetail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public ProductView getProduct() {
        return product;
    }

    public void setProduct(ProductView product) {
        this.product = product;
    }

    public SaleView getSale() {
        return sale;
    }

    public void setSale(SaleView sale) {
        this.sale = sale;
    }

    @Override
    public Class<SaleDetail> getDomainClass() {
        return SaleDetail.class;
    }
}
