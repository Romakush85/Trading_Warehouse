package ua.kushnir.petproject.controllers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.kushnir.petproject.models.contractor.Contacts;
import ua.kushnir.petproject.models.contractor.Contract;
import ua.kushnir.petproject.models.contractor.supplier.Supplier;
import ua.kushnir.petproject.services.ContactsService;
import ua.kushnir.petproject.services.ContractsService;
import ua.kushnir.petproject.services.SuppliersService;

import javax.validation.Valid;
import java.util.UUID;


@Controller
@RequestMapping("/suppliers")
@Data
public class SuppliersController {
    private final ContractsService contractsService;
    private final ContactsService contactsService;
    private final SuppliersService suppliersService;

    @Autowired
    public SuppliersController(SuppliersService suppliersService,
                               ContractsService contractsService,
                               ContactsService contactsService) {
        this.suppliersService = suppliersService;
        this.contactsService = contactsService;
        this.contractsService = contractsService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("suppliers", suppliersService.findAll());
        return "contractors/suppliers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("supplier", suppliersService.findOne(id));
        return "/contractors/suppliers/show";
    }

    @GetMapping("/new")
    public String newSupplier(@ModelAttribute("supplier") Supplier supplier,
                              @ModelAttribute("contract") Contract contract,
                              @ModelAttribute("contacts") Contacts contacts) {
        return "/contractors/suppliers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("supplier") @Valid Supplier supplier, BindingResult supplierResult,
                              @ModelAttribute("contract") @Valid Contract contract, BindingResult contractResult,
                              @ModelAttribute("contacts") @Valid Contacts contacts, BindingResult contactsResult) {
        if(supplierResult.hasErrors()
            || contractResult.hasErrors()
            || contactsResult.hasErrors())
            return "contractors/suppliers/new";

        supplier.setContacts(contacts);
        supplier.setContract(contract);
        contacts.setContractor(supplier);
        contract.setContractor(supplier);
        suppliersService.save(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") UUID id) {
        model.addAttribute("supplier", suppliersService.findOne(id));
        model.addAttribute("contract", suppliersService.findOne(id).getContract());
        model.addAttribute("contacts", suppliersService.findOne(id).getContacts());
        return "contractors/suppliers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("supplier") @Valid Supplier supplier, BindingResult supplierResult,
                         @ModelAttribute("contract") @Valid Contract contract, BindingResult contractResult,
                         @ModelAttribute("contacts") @Valid Contacts contacts, BindingResult contactsResult,
                         @PathVariable("id") UUID id) {
        if (supplierResult.hasErrors()
                || contractResult.hasErrors()
                || contactsResult.hasErrors())
            return "contractors/suppliers/edit";
        supplier.setContract(contract);
        supplier.setContacts(contacts);
        contract.setContractor(supplier);
        contacts.setContractor(supplier);
        suppliersService.update(id, supplier);
        return "redirect:/suppliers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        suppliersService.delete(id);
        return "redirect:/suppliers";
    }

}
