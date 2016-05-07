package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class ProviderController {

    @Script("/static/js/views/providers/query.js")
    @RequestMapping("/provedores")
    public String query() {
        return "secured/providers/query";
    }

}
