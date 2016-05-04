package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.helper.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/30/2016.
 */

@Controller
public class InventoryController {
    private static final String CONTEXT_VIEW_INVENTORY_PATH = "secured/administration/inventory/";

    @Script("/resources/js/views/inventory/inventory.js")
    @RequestMapping("inventory")
    public String check() {
        return CONTEXT_VIEW_INVENTORY_PATH + "check-inventory";
    }

    @RequestMapping("add-inventory")
    public String add() {
        return CONTEXT_VIEW_INVENTORY_PATH + "add-inventory";
    }

}
