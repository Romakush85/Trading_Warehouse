package ua.kushnir.petproject.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kushnir.petproject.models.order.Order;
import ua.kushnir.petproject.models.order.OrderType;
import ua.kushnir.petproject.services.OrdersService;
import ua.kushnir.petproject.services.ProductsService;

import java.util.UUID;

@Controller
@Data
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;
    private final ProductsService productsService;

    @Autowired
    public OrdersController(OrdersService ordersService, ProductsService productsService) {
        this.ordersService = ordersService;
        this.productsService = productsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("orders", ordersService.findAll());
        return "orders/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("order", ordersService.findOne(id));
        return "orders/show";
    }

    @PostMapping("/new")
    public String newPurchaseOrder(@RequestParam("supplierId") UUID supplierId,
                                   Model model) {
        model.addAttribute("order", ordersService.createPurchaseOrder(supplierId));
        model.addAttribute("products", productsService.findAllBySupplierId(supplierId));
        return "redirect:/orders/";
    }

    @PostMapping()
    public String create() {
        return "redirect:/products";
    }

}
