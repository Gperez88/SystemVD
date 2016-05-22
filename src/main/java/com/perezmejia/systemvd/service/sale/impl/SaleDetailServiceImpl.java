package com.perezmejia.systemvd.service.sale.impl;

import com.perezmejia.systemvd.entity.sale.SaleDetail;
import com.perezmejia.systemvd.repository.sale.SaleDetailRepository;
import com.perezmejia.systemvd.service.sale.SaleDetailService;
import com.perezmejia.systemvd.view.sale.SaleDetailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class SaleDetailServiceImpl implements SaleDetailService {

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    public List<SaleDetailView> findAll() {
        List<SaleDetail> saleDetail = (List<SaleDetail>) saleDetailRepository.findAll();
        return new SaleDetailView().convertViewList(saleDetail);
    }

    @Override
    public SaleDetailView findById(Long id) {
        return new SaleDetailView(saleDetailRepository.findOne(id));
    }

    @Override
    public void save(SaleDetailView saleDetailView) {
        SaleDetail saleDetail = saleDetailView.parse();

        saleDetailRepository.save(saleDetail);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(List<SaleDetailView> collection) {
        List<SaleDetail> saleDetails = new SaleDetailView().convertDomainList(collection);
        saleDetailRepository.save(saleDetails);
    }
}
