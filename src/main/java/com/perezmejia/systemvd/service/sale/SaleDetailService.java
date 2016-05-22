package com.perezmejia.systemvd.service.sale;

import com.perezmejia.systemvd.service.BaseService;
import com.perezmejia.systemvd.view.inventory.WarehouseDetailView;
import com.perezmejia.systemvd.view.sale.SaleDetailView;

import java.util.Collection;
import java.util.List;

/**
 * Created by Guil on 5/10/2016.
 */
public interface SaleDetailService extends BaseService<SaleDetailView> {
    public void save(List<SaleDetailView> collection);
}
