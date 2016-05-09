package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Layout;
import com.perezmejia.systemvd.config.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class ProductController {

    @Script("/static/js/views/products/query.js")
    @Layout("table")
    @RequestMapping("/inventario/productos")
    public String query() {
        return "secured/inventory/products/query";
    }

    @Script("/static/js/views/products/query.js")
    @RequestMapping("/inventario/productos/nuevo")
    public String add() {
        return "secured/inventory/products/add";
    }

}
