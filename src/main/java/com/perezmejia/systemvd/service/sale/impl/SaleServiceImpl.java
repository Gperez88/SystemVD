package com.perezmejia.systemvd.service.sale.impl;

import com.perezmejia.systemvd.entity.sale.Sale;
import com.perezmejia.systemvd.repository.sale.SaleRepository;
import com.perezmejia.systemvd.service.sale.SaleDetailService;
import com.perezmejia.systemvd.service.sale.SaleService;
import com.perezmejia.systemvd.view.sale.SaleDetailView;
import com.perezmejia.systemvd.view.sale.SaleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guil on 5/8/2016.
 */

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleDetailService saleDetailService;

    @Override
    public List<SaleView> findAll() {
        List<Sale> sales = (List<Sale>) saleRepository.findAll();
        return new SaleView().convertViewList(sales);
    }

    @Override
    public SaleView findById(Long id) {
        return new SaleView(saleRepository.findOne(id));
    }

    @Override
    public void save(SaleView saleView) {
        Sale sale = saleView.parse();
        sale.getDetails().forEach(saleDetail -> {
            saleDetail.setSale(sale);
        });

        saleView.load(saleRepository.save(sale));

    }

    @Override
    public void delete(Long id) {
        saleRepository.delete(id);
    }
}
