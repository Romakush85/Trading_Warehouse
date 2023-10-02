package ua.kushnir.petproject.controllers;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kushnir.petproject.services.BuyersService;

@Controller
@RequestMapping("/buyers")
@Data
public class BuyersController {
    private final BuyersService buyersService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("buyers", buyersService.findAll());
        return "contractors/buyers/index";
    }

}
