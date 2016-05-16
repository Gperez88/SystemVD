package com.perezmejia.systemvd.service.inventory.impl;

import com.perezmejia.systemvd.entity.inventory.WarehouseDetail;
import com.perezmejia.systemvd.repository.inventory.WarehouseDetailRepository;
import com.perezmejia.systemvd.service.inventory.WarehouseDetailService;
import com.perezmejia.systemvd.view.inventory.WarehouseDetailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class WarehouseDetailServiceImpl implements WarehouseDetailService {

    @Autowired
    private WarehouseDetailRepository warehouseDetailRepository;

    @Override
    public List<WarehouseDetailView> findAll() {
        List<WarehouseDetail> warehouseDetails = (List<WarehouseDetail>) warehouseDetailRepository.findAll();
        return new WarehouseDetailView().convertViewList(warehouseDetails);
    }

    @Override
    public WarehouseDetailView findById(Long id) {
        return new WarehouseDetailView(warehouseDetailRepository.findOne(id));
    }

    @Override
    public void save(WarehouseDetailView warehouseDetailView) {
        WarehouseDetail warehouseDetail = warehouseDetailView.parse();

        warehouseDetailRepository.save(warehouseDetail);
    }

    @Override
    public void delete(Long id) {

    }
}
