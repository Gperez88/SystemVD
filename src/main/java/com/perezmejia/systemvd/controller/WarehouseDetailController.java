package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Layout;
import com.perezmejia.systemvd.config.template.Script;
import com.perezmejia.systemvd.service.inventory.ProductService;
import com.perezmejia.systemvd.service.inventory.WarehouseDetailService;
import com.perezmejia.systemvd.service.inventory.WarehouseService;
import com.perezmejia.systemvd.view.inventory.ProductView;
import com.perezmejia.systemvd.view.inventory.WarehouseDetailView;
import com.perezmejia.systemvd.view.inventory.WarehouseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class WarehouseDetailController {
    private final String REL_PATH = "/inventario/almacenes";
    private final String DETAIL_PATH = REL_PATH + "/detalle";
    private final String ADD_DETAIL_PATH = DETAIL_PATH + "/agregar";


    private final String REL_VIEW_PATH = "secured/inventory/warehouses";
    private final String QUERY_DETAIL_VIEW_PATH = REL_VIEW_PATH + "/detail_query";

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private WarehouseDetailService warehouseDetailService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("allProducts")
    public List<ProductView> populateProductList() {
        return productService.findAll();
    }

    @Script("/static/js/views/warehouses/detail-query.js")
    @Layout("table")
    @RequestMapping(value = DETAIL_PATH, method = RequestMethod.GET)
    public String queryDetails(Model model, @RequestParam(value = "id", required = true) Long id) {
        WarehouseView warehouse = warehouseService.findById(id);

        WarehouseDetailView warehouseDetail = new WarehouseDetailView();
        warehouseDetail.setWarehouse(warehouse);

        model.addAttribute("warehouseDetail", warehouseDetail);
        model.addAttribute("warehouse", warehouse);

        return QUERY_DETAIL_VIEW_PATH;
    }

    @Script("/static/js/views/warehouses/detail-query.js")
    @Layout("table")
    @RequestMapping(value = ADD_DETAIL_PATH, method = RequestMethod.POST)
    public String saveDetail(@ModelAttribute("warehouseDetail") @Valid WarehouseDetailView warehouseDetail,
                             BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if (bindingResult.hasErrors()) {
            redirectAttrs.addFlashAttribute("warehouseDetail", warehouseDetail);
            redirectAttrs.addFlashAttribute("warehouse", warehouseDetail.getWarehouse());
        }

        warehouseDetailService.save(warehouseDetail);

        return String.format("redirect:%s?id=%s", DETAIL_PATH, warehouseDetail.getWarehouse().getId());
    }
}
