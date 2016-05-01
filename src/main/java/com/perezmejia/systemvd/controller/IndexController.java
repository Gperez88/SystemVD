package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.helper.template.Script;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class IndexController {

    @Script("/resources/js/views/index.js")
    @RequestMapping("/index")
    public String index() {
        return "secured/index";
    }

}
