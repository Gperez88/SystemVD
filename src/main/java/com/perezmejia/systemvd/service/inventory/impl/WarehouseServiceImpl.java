package com.perezmejia.systemvd.service.inventory.impl;

import com.perezmejia.systemvd.entity.inventory.Warehouse;
import com.perezmejia.systemvd.repository.inventory.SaleRepositoruy;
import com.perezmejia.systemvd.service.inventory.WarehouseService;
import com.perezmejia.systemvd.view.inventory.WarehouseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private SaleRepositoruy warehouseRepository;

    @Override
    public List<WarehouseView> findAll() {
        List<Warehouse> warehouses = (List<Warehouse>) warehouseRepository.findAll();
        return new WarehouseView().convertViewList(warehouses);
    }

    @Override
    public WarehouseView findById(Long id) {
        return new WarehouseView(warehouseRepository.findOne(id));
    }

    @Override
    public void save(WarehouseView warehouseView) {
        Warehouse warehouse = warehouseView.parse();
        warehouseRepository.save(warehouse);
    }

    @Override
    public void delete(Long id) {

    }
}
