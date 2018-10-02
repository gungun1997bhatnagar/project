package com.niit.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Backend.dao.CategoryRepository;
import com.niit.Backend.dao.ProductRepository;
import com.niit.Backend.model.Category;
import com.niit.Backend.model.Product;

@Controller

public class HomeController {
	@Autowired
	Product product;
	@Autowired
	Category category;
	@Autowired
    CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
   
		@RequestMapping("/")
		public String homePage()
		{
			return "index";
			
		}
		
		@RequestMapping("/login")
		public String loginPage()
		{
			
			return "SignIn";
		}
		@RequestMapping("/Category")
		public String Categorypage(Model model)
		{
			List<Category>allCategories=categoryRepository.getAllCategory();
			model.addAttribute("cat" , category);
			model.addAttribute("categoryList",allCategories);
			return "Category";
			
		}
		@RequestMapping("/Product")
		public String productpage(Model model)
		{
			List<Product>allProduct=productRepository.getAllProduct();
			model.addAttribute("pro",product);
			model.addAttribute("productList",allProduct);
			return"Product";
			
		}
		
}
