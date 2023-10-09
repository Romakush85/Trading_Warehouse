package ua.kushnir.petproject.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.kushnir.petproject.models.contractor.Contacts;
import ua.kushnir.petproject.models.contractor.Contract;
import ua.kushnir.petproject.models.contractor.buyer.Buyer;
import ua.kushnir.petproject.services.BuyersService;
import ua.kushnir.petproject.services.ContactsService;
import ua.kushnir.petproject.services.ContractsService;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/buyers")
@Data
public class BuyersController {
    private final BuyersService buyersService;
    private final ContractsService contractsService;
    private final ContactsService contactsService;

    @Autowired
    public BuyersController(BuyersService buyersService,
                            ContractsService contractsService,
                            ContactsService contactsService) {
        this.buyersService = buyersService;
        this.contractsService = contractsService;
        this.contactsService = contactsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("buyers", buyersService.findAll());
        return "contractors/buyers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("buyer", buyersService.findOne(id));
        return "contractors/buyers/show";
    }

    @GetMapping("/new")
    public String newBuyer(@ModelAttribute("buyer") Buyer buyer,
                           @ModelAttribute("contract") Contract contract,
                           @ModelAttribute("contacts") Contacts contacts) {
        return "contractors/buyers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("buyer") @Valid  Buyer buyer, BindingResult buyerResult,
                         @ModelAttribute("contract") @Valid Contract contract, BindingResult contractResult,
                         @ModelAttribute("contacts") @Valid Contacts contacts, BindingResult contactsResult) {
        if (buyerResult.hasErrors()
                || contractResult.hasErrors()
                || contactsResult.hasErrors())
            return "contractors/buyers/new";
        buyer.setContacts(contacts);
        buyer.setContract(contract);
        contacts.setContractor(buyer);
        contract.setContractor(buyer);
        buyersService.save(buyer);
        return "redirect:/buyers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("buyer", buyersService.findOne(id));
        model.addAttribute("contract", buyersService.findOne(id).getContract());
        model.addAttribute("contacts", buyersService.findOne(id).getContacts());
        return "contractors/buyers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("buyer") @Valid  Buyer buyer, BindingResult buyerResult,
                         @ModelAttribute("contract") @Valid Contract contract, BindingResult contractResult,
                         @ModelAttribute("contacts") @Valid Contacts contacts, BindingResult contactsResult,
                         @PathVariable("id") UUID id) {
        if (buyerResult.hasErrors()
                || contractResult.hasErrors()
                || contactsResult.hasErrors())
            return "contractors/buyers/edit";
        buyer.setContacts(contacts);
        buyer.setContract(contract);
        contacts.setContractor(buyer);
        contract.setContractor(buyer);
        buyersService.update(id, buyer);
        return "redirect:/buyers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        buyersService.delete(id);
        return "redirect:/buyers";
    }

}
