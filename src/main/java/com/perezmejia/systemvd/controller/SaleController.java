package com.perezmejia.systemvd.controller;

import com.perezmejia.systemvd.config.template.Layout;
import com.perezmejia.systemvd.config.template.Script;
import com.perezmejia.systemvd.entity.sale.Sale;
import com.perezmejia.systemvd.helper.DateUtils;
import com.perezmejia.systemvd.service.ClientService;
import com.perezmejia.systemvd.service.inventory.ProductService;
import com.perezmejia.systemvd.service.sale.SaleService;
import com.perezmejia.systemvd.service.security.UserService;
import com.perezmejia.systemvd.service.security.impl.UserServiceImpl;
import com.perezmejia.systemvd.view.ClientView;
import com.perezmejia.systemvd.view.inventory.ProductView;
import com.perezmejia.systemvd.view.inventory.WarehouseDetailView;
import com.perezmejia.systemvd.view.sale.SaleDetailView;
import com.perezmejia.systemvd.view.sale.SaleView;
import com.perezmejia.systemvd.view.security.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guil on 4/29/2016.
 */

@Controller
public class SaleController {
    private final String REL_PATH = "/venta";
    private final String SELL_PATH = REL_PATH + "/vender";
    private final String QUERY_PATH = REL_PATH + "/consultar";
    private final String SHORT_SALE_PATH = REL_PATH + "/detalle";

    private final String REL_VIEW_PATH = "secured/sale";
    private final String QUERY_VIEW_PATH = REL_VIEW_PATH + "/query";
    private final String SELL_VIEW_PATH = REL_VIEW_PATH + "/sell";
    private final String SHORT_SALE_VIEW_PATH = REL_VIEW_PATH + "/short_sale";

    @Autowired
    private SaleService saleService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @ModelAttribute("allProducts")
    public List<ProductView> populateProductList() {
        return productService.findAll();
    }

    @Script("/static/js/views/sale/sell.js")
    @Layout("table")
    @RequestMapping(value = SELL_PATH, method = RequestMethod.GET)
    public String sell(Model model, @RequestParam(value = "name", required = false) String name, Principal principal) {
        boolean enable = false;
        SaleView sale = new SaleView();

        if (name != null && !name.isEmpty()) {
            enable = true;
            sale = (SaleView) model.asMap().getOrDefault("sale", new SaleView());
            ClientView client = clientService.findClientByName(name);

            sale.setUser(userService.findUserByName(principal.getName()));
            sale.setCreateDate(new Timestamp(DateUtils.getNow()));
            sale.setClient(client);
        }

        model.addAttribute("name", name);
        model.addAttribute("sale", sale);
        model.addAttribute("enable", enable);

        return SELL_VIEW_PATH;
    }

    @Script("/static/js/views/sale/sell.js")
    @Layout("table")
    @RequestMapping(value = SELL_PATH, params = "addDetail", method = RequestMethod.POST)
    public String addDetail(Model model, @RequestParam Long productId, @RequestParam Long quantity,
                            final SaleView sale, final BindingResult result) {

        boolean enable = false;

        if (!result.hasErrors()) {
            enable = true;
            SaleDetailView saleDetail = new SaleDetailView();
            ProductView product = productService.findById(productId);

            float unitPrice = product.getPrice();
            float totalPrice = unitPrice * quantity;

            saleDetail.setProduct(product);
            saleDetail.setQuantity(quantity);
            saleDetail.setTotalPrice(totalPrice);
            saleDetail.setSale(sale);

            sale.getDetails().add(saleDetail);
        }

        model.addAttribute("sale", sale);
        model.addAttribute("enable", enable);

        return SELL_VIEW_PATH;
    }

    @Script("/static/js/views/sale/sell.js")
    @Layout("table")
    @RequestMapping(value = SELL_PATH, params = "removeDetail", method = RequestMethod.POST)
    public String removeDetail(Model model, final SaleView sale, final BindingResult result,
                               final HttpServletRequest request) {

        boolean enable = false;
        final Integer detailId = Integer.valueOf(request.getParameter("removeDetail"));

        if (!result.hasErrors()) {
            enable = true;
            sale.getDetails().remove(detailId.intValue());
        }

        model.addAttribute("sale", sale);
        model.addAttribute("enable", enable);

        return SELL_VIEW_PATH;
    }

    @Script("/static/js/views/sale/sell.js")
    @RequestMapping(value = SELL_PATH, method = RequestMethod.POST)
    public String save(@ModelAttribute("sale") @Valid SaleView sale, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return SELL_VIEW_PATH;
        }
        saleService.save(sale);

        return String.format("redirect:%s?id=%s", SHORT_SALE_PATH, sale.getId());
    }

    @Script("/static/js/views/sale/query.js")
    @RequestMapping(QUERY_PATH)
    @Layout("table")
    public String query(Model model) {
        List<SaleView> sales = saleService.findAll();

        model.addAttribute("sales", sales);

        return QUERY_VIEW_PATH;
    }

    @Script("/static/js/views/sale/sell.js")
    @RequestMapping(value = SHORT_SALE_PATH, method = RequestMethod.GET)
    public String shortSale(Model model, @RequestParam(value = "id", required = true) Long id) {
        SaleView sale = saleService.findById(id);

        model.addAttribute("sale", sale);

        return SHORT_SALE_VIEW_PATH;
    }

}
