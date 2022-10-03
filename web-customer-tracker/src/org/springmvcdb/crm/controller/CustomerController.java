package org.springmvcdb.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvcdb.crm.entity.Customer;
import org.springmvcdb.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	@RequestMapping("/list")
	public String listCustomers(Model model) {
//		customerService.insertData();
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customers", customers);
		return "customer-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-add";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "customer-add";
		}
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute(customer);
		return "customer-add";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id, Model model) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
}
