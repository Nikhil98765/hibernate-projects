package com.example.controller;


import com.example.model.Account;
import com.example.model.Branch;
import com.example.model.Customer;
import com.example.service.AccountService;
import com.example.service.BranchService;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bank")
public class BankController {

    @Autowired
    CustomerService customerService;
    @Autowired
    BranchService branchService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value="/addcustomer", method=RequestMethod.GET)
    public ModelAndView add(){
        ModelAndView model = new ModelAndView("customer/form");
        Customer customer  = new Customer();
        model.addObject("customerForm", customer);
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customerForm") Customer customer){

        customerService.saveOrUpdate(customer);

        return new ModelAndView("redirect:/customer/list");
    }

    @RequestMapping(value="/addbranch", method=RequestMethod.GET)
    public ModelAndView addBranch(){
        ModelAndView model = new ModelAndView("branch/form");
        Branch branch  = new Branch();
        model.addObject("branchForm", branch);
        return model;
    }

    @RequestMapping(value="/saveBranch", method=RequestMethod.POST)
    public ModelAndView saveBranch(@ModelAttribute("branchForm") Branch branch){

        branchService.saveOrUpdate(branch);

        return new ModelAndView("redirect:/branch/list");
    }

    @RequestMapping(value="/addaccount", method=RequestMethod.GET)
    public ModelAndView addAccount(){
        ModelAndView model = new ModelAndView("account/form");
        Account account = new Account();
        model.addObject("accountForm", account);
        return model;
    }

    @RequestMapping(value="/saveAccount", method=RequestMethod.POST)
    public ModelAndView saveAccount(@ModelAttribute("accountForm") Account account){

        accountService.saveOrUpdate(account);

        return new ModelAndView("redirect:/branch/list");
    }




}
