package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.entities.BillingAddress;
import com.shoppingcart.entities.Customer;
import com.shoppingcart.entities.ShippingAddress;
import com.shoppingcart.entities.User;
import com.shoppingcart.service.CustomerService;

/**
 * Controller class of User module
 * 
 * @author kenarayan
 *
 */
@Controller
public class UserController {

	@Autowired
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "customer/registration", method = RequestMethod.GET)
	public ModelAndView getUserRegistrationForm() {
		Customer customer = new Customer();
		User user = new User();
		ShippingAddress sAddr = new ShippingAddress();
		BillingAddress bAddr = new BillingAddress();
		customer.setBillingAddress(bAddr);
		customer.setShippingAddress(sAddr);
		customer.setUsers(user);
		return new ModelAndView("userregister", "customer", customer);
	}

	@RequestMapping(value = "customer/registration", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute(value = "customer") Customer customer, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			return "userregister";
		}
		customerService.addCustomer(customer);
		model.addAttribute("regSuccess", "Customer registration successful. Login using the username and password");
		return "login";
	}
}
