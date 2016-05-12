package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class SaleController {

    @Script("/static/js/views/sale/sell.js")
    @RequestMapping("/venta/vender")
    public String sell() {
        return "secured/sale/sell";
    }

    @Script("/static/js/views/sale/query.js")
    @RequestMapping("/venta/consultar")
    public String query() {
        return "secured/sale/query";
    }

}
