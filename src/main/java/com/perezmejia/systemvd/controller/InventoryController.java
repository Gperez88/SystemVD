package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.helper.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/30/2016.
 */

@Controller
public class InventoryController {

    @Script("/resources/js/views/inventory/inventory.js")
    @RequestMapping("inventory")
    public String check() {
        return "secured/administration/inventory/check-inventory";
    }

    @RequestMapping("add-inventory")
    public String add() {
        return "secured/administration/inventory/add-inventory";
    }

}
