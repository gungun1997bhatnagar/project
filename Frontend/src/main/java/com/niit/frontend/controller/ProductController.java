package com.niit.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Backend.dao.ProductRepository;
import com.niit.Backend.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	Product product;
	
	
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	
		public String productAdd(@ModelAttribute("pro") Product product)
		{
			if(product.getProductId()==0)
			{
				productRepository.addProduct(product);
			}
			else
			{
					productRepository.updateProduct(product);
			}
				return "redirect:/Product";
		
		}

			@RequestMapping("/deleteProduct/{id}")
			public String productDelete(@PathVariable("id")int ProductId)
					{
						productRepository.deleteProduct(ProductId);
						return "redirect:/Product";
					}
				

							@RequestMapping("/editProduct/{id}")
							
							public String product(@PathVariable("id")int ProductId,Model model)
							{
								Product productData=productRepository.getProductById(ProductId);
								model.addAttribute("pro",productData);
								List<Product>allProduct=productRepository.getAllProduct();
								model.addAttribute("productList",allProduct);
								return "Product";
							}
							
	}

	
	
	
	
	
	
	

