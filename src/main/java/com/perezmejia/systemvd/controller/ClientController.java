package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class ClientController {

    @Script("/static/js/views/clients/query.js")
    @RequestMapping("/clientes")
    public String query() {
        return "secured/clients/query";
    }

}
