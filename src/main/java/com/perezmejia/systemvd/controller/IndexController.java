package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Script;
import com.perezmejia.systemvd.service.ClientService;
import com.perezmejia.systemvd.service.inventory.ProductService;
import com.perezmejia.systemvd.service.inventory.WarehouseService;
import com.perezmejia.systemvd.service.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class IndexController {

    public static final String REAL_VIEW_PATH = "/secured/index";

    @Autowired
    private SaleService saleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseService warehouseService;

    @Script("/static/js/views/index.js")
    @RequestMapping("/inicio")
    public String index(Model model) {
        long saleCount = saleService.count();
        long clientCount = clientService.count();
        long productCount = productService.count();
        long warehouseCount = warehouseService.count();

        model.addAttribute("saleCount", saleCount);
        model.addAttribute("clientCount", clientCount);
        model.addAttribute("productCount", productCount);
        model.addAttribute("warehouseCount", warehouseCount);

        return REAL_VIEW_PATH;
    }

}
