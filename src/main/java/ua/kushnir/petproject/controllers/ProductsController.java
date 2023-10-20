package ua.kushnir.petproject.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.kushnir.petproject.models.contractor.supplier.Supplier;
import ua.kushnir.petproject.models.product.Product;
import ua.kushnir.petproject.services.ProductsService;
import ua.kushnir.petproject.services.SuppliersService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@Data
public class ProductsController {
    private final SuppliersService suppliersService;
    private final ProductsService productsService;

    @Autowired
    public ProductsController(SuppliersService suppliersService, ProductsService productsService) {
        this.suppliersService = suppliersService;
        this.productsService = productsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("product", productsService.findOne(id));
        return "products/show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product")Product product,
                             Model model) {
        model.addAttribute("suppliers", suppliersService.findAll());
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product,
                         BindingResult bindingResult,
                         @ModelAttribute("supplier") UUID supplierId) {
        if (bindingResult.hasErrors())
            return "products/new";
        Supplier supplier = suppliersService.findOne(supplierId);
        if(productsService.isProductAllreadyAdded(supplier, product))
            {
                bindingResult.rejectValue("name", "Product with this name already exists for this supplier");
                return "products/new";
            }
        product.setSupplier(supplier);
        supplier.addProduct(product);
        productsService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("product", productsService.findOne(id));
        model.addAttribute("suppliers", suppliersService.findAll());
        return "products/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") @Valid Product product,
                         BindingResult bindingResult,
                         @ModelAttribute("supplier") UUID supplierId,
                         @PathVariable("id") UUID id) {
        if (bindingResult.hasErrors())
            return "products/edit";
        Supplier supplier = suppliersService.findOne(supplierId);
        if(productsService.isProductAllreadyAdded(supplier, product))
        {
            bindingResult.rejectValue("name", "Product with this name already exists for this supplier");
            return "products/edit";
        }
        product.setSupplier(supplier);
        productsService.update(id, product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        productsService.delete(id);
        return "redirect:/products";
    }

}
