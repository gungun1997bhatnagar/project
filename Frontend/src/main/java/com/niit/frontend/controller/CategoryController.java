package com.niit.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Backend.dao.CategoryRepository;
import com.niit.Backend.model.Category;

@Controller
	public class CategoryController {
		@Autowired
		CategoryRepository categoryRepository;

		@RequestMapping(value="/addCategory",method=RequestMethod.POST)
		public String categoryAdd(@ModelAttribute("cat") Category category)
		{
			if(category.getCategoryId()==0)
			{
			categoryRepository.addCategory(category);
			}
			else
			{
				categoryRepository.updateCategory(category);
			}
			
			return "redirect:/Category";
		}


@RequestMapping("/deleteCategory/{id}")

public String categoryDelete(@PathVariable("id") int categoryId)
{
	categoryRepository.deleteCategory(categoryId);
	return "redirect:/Category";
}

@RequestMapping("/editCategory/{id}")

public String categoryUpdate(@PathVariable("id") int categoryId,Model model)
{
	Category categoryData=categoryRepository.getCategoryById(categoryId);
	model.addAttribute("cat",categoryData);
	List<Category> allCategories= categoryRepository.getAllCategory();
	model.addAttribute("categoryList",allCategories);
	return "Category";
}






}





