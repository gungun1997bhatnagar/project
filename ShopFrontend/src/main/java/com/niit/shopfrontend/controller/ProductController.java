package com.niit.shopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shopbackend.dao.ProductRepository;
import com.niit.shopbackend.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;

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

public String productDelete(@PathVariable("id") int productId)
{
	productRepository.deleteProduct(productId);
return "redirect:/Product";
}

@RequestMapping("/editProduct/{id}")

public String productUpdate(@PathVariable("id") int productId,Model model)
{
	Product productData=productRepository.getProductById(productId);
model.addAttribute("pro",productData);

List<Product> allProduct= productRepository.getAllProduct();
model.addAttribute("productList",allProduct);
return "Product";
}


}
