package com.ssafy.example.controller;

import com.ssafy.example.entity.Customer;
import com.ssafy.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RequestMapping("/customer")
@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String customerList(String success, Model model) {
        log.info("[GET] CustomerController.customerList");
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customers", customerList);
        model.addAttribute("success", success);
        return "list";
    }

    @GetMapping("/regist")
    public String registCustomerForm(Model model) {
        log.info("[GET] CustomerController.customerList");
        model.addAttribute("customer", new Customer());
        return "insert";
    }

    @PostMapping("/regist")
    public String registCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        log.info("[POST] CustomerController.registCustomer");
        customerService.regist(customer);
        redirectAttributes.addAttribute("id", customer.getId());
        redirectAttributes.addAttribute("success",  customer.getName() + " 고객정보 등록이 완료되었습니다.");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String searchForm(String id) {
        log.info("[GET] CustomerController.searchForm");
        return "search";
    }

    @PostMapping("/search")
    public String searchCustomer(String id, RedirectAttributes redirectAttributes) {
        log.info("[POST] CustomerController.searchCustomer");
        redirectAttributes.addAttribute("id", id);
        return "redirect:/customer/{id}";
    }

    @GetMapping("/{id}")
    public String customerDetail(@PathVariable String id, Model model) {
        log.info("[GET] CustomerController.searchCustomer, id = {}", id);
        Customer result = customerService.search(id);
        model.addAttribute("customer", result);
        return "customer_detail";
    }
}
