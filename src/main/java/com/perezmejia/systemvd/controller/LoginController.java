package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Layout;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Guil on 5/1/2016.
 */

@Controller
public class LoginController {

    @Layout("blank")
    @RequestMapping({"/", "/login"})
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {

        model.addAttribute("loginError", error != null);
        model.addAttribute("logoutMessage", logout != null);

        return "login";
    }
}
