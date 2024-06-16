package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Category;
import com.blogs.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	//depcy
	@Autowired
	private CategoryService categoryService;
	
	public CategoryController() {
		System.out.println("in ctor " + getClass());
	}
	/* 
	 * desc - get all categories
	 * URL - http://host:port/categories
	 * Method - GET
	 * payload - None
	 * Resp - JSON represention of List<Category>
	 */
	@GetMapping
	public List<Category> getCategories() {
		System.out.println("in get categories");
		return categoryService.getAllCategories();
	}
	/*
	 * Desc - add new category
	 * URL - http://host:port/categories
	 * Method - POST
	 * payload - JSON represention of a new category(nm,desc)
	 * Resp - Saved Category (along with id update create nm,desc)
	 */
	@PostMapping
	public Category addNewCategory(@RequestBody  
			Category category)
	{
		System.out.println("in add category "+category);
		return categoryService.addNewCategory(category);
	}
	
}
