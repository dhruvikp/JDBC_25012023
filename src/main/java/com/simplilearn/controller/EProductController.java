package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simplilearn.model.EProduct;
import com.simplilearn.service.EProductService;

@Controller
public class EProductController {

	@Autowired
	EProductService eProductService;
	
	// STEP 1: Handle request
	@GetMapping("/getProducts")
	public String products(Model model) {
		
		// STEP 2: Do business logic
		List<EProduct> products = eProductService.getProducts();
		
		// STEP 3: Populate Model
		model.addAttribute("prodList", products);
		
		//STEP 4: Return view
		return "product-list";
	}
}
