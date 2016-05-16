package com.perezmejia.systemvd.entity.sale;

import com.perezmejia.systemvd.entity.inventory.Product;

import javax.persistence.*;

/**
 * Created by Guil on 5/14/2016.
 */

@Entity
@Table(name = "sale_detail", schema = "systemvd")
public class SaleDetail {
    private Long id;
    private Long quantity;
    private float totalPrice;
    private Product product;
    private Sale sale;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "total_price")
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float total_price) {
        this.totalPrice = total_price;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "sale_id")
    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleDetail that = (SaleDetail) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (sale != null ? !sale.equals(that.sale) : that.sale != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (id != null ? id.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (sale != null ? sale.hashCode() : 0);
        return result;
    }
}
