package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.DAO.CustomerDAO;
import com.spring.entity.customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the dao

			List<customer> customers=customerDao.getCustomers();
		
			theModel.addAttribute("custlist",customers);
		// add the customers to the model

		return "list-customers";
	}

	
	@GetMapping("/ShowFormForAdd")
	public String addCustomers(Model theModel) {

		customer cust =new customer();
		
		theModel.addAttribute("custObj",cust);
		return "customer-form";
		
	}

	
	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("custObj") customer cust) {
		
		
		customerDao.saveCustomer(cust);
		
		
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("showFormForUpdate")
	public String updateCustomer(@RequestParam("custId") int theId,Model m) {
		
		customer thecust= customerDao.getCustomers(theId);
		
		m.addAttribute("custObj",thecust);
		
		return "customer-form";
	}
	
	
	@GetMapping("showFormForDelete")
	public String String(
			@RequestParam("custId") int id,Model m) {
		
			customer c = customerDao.deleteCustomer(id);
		
		
			m.addAttribute("custObj",c);
		
		return "redirect:/customer/list";
	}
	
	
}
