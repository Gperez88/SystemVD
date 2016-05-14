package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Layout;
import com.perezmejia.systemvd.config.template.Script;
import com.perezmejia.systemvd.service.ClientService;
import com.perezmejia.systemvd.view.ClientView;
import com.perezmejia.systemvd.view.SexView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class ClientController {

    private final String REL_PATH = "/clientes";
    private final String ADD_PATH = REL_PATH + "/agregar";
    private final String EDIT_PATH = REL_PATH + "/editar";

    private final String REL_VIEW_PATH = "secured/clients";
    private final String QUERY_VIEW_PATH = REL_VIEW_PATH + "/query";
    private final String FORM_VIEW_PATH = REL_VIEW_PATH + "/form";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ClientService clientService;

    @ModelAttribute("allSex")
    public List<SexView> populateSexList() {
        return Arrays.asList(SexView.values());
    }

    @Script("/static/js/views/clients/query.js")
    @Layout("table")
    @RequestMapping(value = REL_PATH, method = RequestMethod.GET)
    public String query(Model model) {
        model.addAttribute("clients", clientService.findAll());

        return QUERY_VIEW_PATH;
    }

    @Script("/static/js/views/clients/query.js")
    @RequestMapping(value = ADD_PATH, method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("breadcrumb", messageSource.getMessage("breadcrumb.add", null, Locale.getDefault()));
        model.addAttribute("title", messageSource.getMessage("page.client.add.title", null, Locale.getDefault()));
        model.addAttribute("client", new ClientView());

        return FORM_VIEW_PATH;
    }

    @RequestMapping(value = EDIT_PATH, method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(value = "id", required = true) Long id) {
        ClientView client = clientService.findById(id);

        model.addAttribute("breadcrumb", messageSource.getMessage("breadcrumb.edit", null, Locale.getDefault()));
        model.addAttribute("title", messageSource.getMessage("page.client.edit.title", null, Locale.getDefault()));
        model.addAttribute("client", client);

        return FORM_VIEW_PATH;
    }

    @Script("/static/js/views/clients/query.js")
    @RequestMapping(value = {ADD_PATH, EDIT_PATH}, method = RequestMethod.POST)
    public String save(@ModelAttribute("client") @Valid ClientView client, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return FORM_VIEW_PATH;
        }
        clientService.save(client);

        return "redirect:" + REL_PATH;
    }

}
