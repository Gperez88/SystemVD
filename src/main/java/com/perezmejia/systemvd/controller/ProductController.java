package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Layout;
import com.perezmejia.systemvd.config.template.Script;
import com.perezmejia.systemvd.service.inventory.CategoryService;
import com.perezmejia.systemvd.service.inventory.ProductService;
import com.perezmejia.systemvd.view.inventory.CategoryView;
import com.perezmejia.systemvd.view.inventory.ProductView;
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
import java.util.List;
import java.util.Locale;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class ProductController {

    private final String REL_PATH = "/inventario/productos";
    private final String ADD_PATH = REL_PATH + "/agregar";
    private final String EDIT_PATH = REL_PATH + "/editar";

    private final String REL_VIEW_PATH = "secured/inventory/products";
    private final String QUERY_VIEW_PATH = REL_VIEW_PATH + "/query";
    private final String FORM_VIEW_PATH = REL_VIEW_PATH + "/form";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("allCategory")
    public List<CategoryView> populateCategoryList() {
        return categoryService.findAll();
    }

    @Script("/static/js/views/products/query.js")
    @Layout("table")
    @RequestMapping(value = REL_PATH, method = RequestMethod.GET)
    public String query(Model model) {
        model.addAttribute("products", productService.findAll());

        return QUERY_VIEW_PATH;
    }

    @Script("/static/js/views/products/query.js")
    @RequestMapping(value = ADD_PATH, method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("breadcrumb", messageSource.getMessage("breadcrumb.add", null, Locale.getDefault()));
        model.addAttribute("title", messageSource.getMessage("page.product.add.title", null, Locale.getDefault()));
        model.addAttribute("productView", new ProductView());

        return FORM_VIEW_PATH;
    }

    @RequestMapping(value = EDIT_PATH, method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(value = "id", required = true) Long id) {
        ProductView productView = productService.findById(id);

        model.addAttribute("breadcrumb", messageSource.getMessage("breadcrumb.edit", null, Locale.getDefault()));
        model.addAttribute("title", messageSource.getMessage("page.product.edit.title", null, Locale.getDefault()));
        model.addAttribute("productView", productView);

        return FORM_VIEW_PATH;
    }

    @Script("/static/js/views/products/query.js")
    @RequestMapping(value = {ADD_PATH, EDIT_PATH}, method = RequestMethod.POST)
    public String save(@ModelAttribute("productView") @Valid ProductView productView, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return FORM_VIEW_PATH;
        }
        productService.save(productView);

        return "redirect:" + REL_PATH;
    }

}
