package com.jbk.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exceptions.CategoryAlreadyExistsException;
import com.jbk.exceptions.ResourceNotExistsExceptions;
import com.jbk.model.Category;
import com.jbk.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping("/add-category")
	public String addCategory(@RequestBody @Valid Category category) {

		int status = service.addCategory(category);

		if (status == 1) {

			return "Data Added Successfully.";
		} else if (status == 2) {
			throw new CategoryAlreadyExistsException("Category Already Exists.");
		} else {
			return "Invalid Data";
		}
		}

	
	@GetMapping("/get-category-by-id/{id}")
	public Category getCategoryById(@PathVariable long id) {
		
	Category category=	service.getCategoryById(id);
	if(category==null) {
		throw new ResourceNotExistsExceptions("Category Not Exists With Id =" + id  );
	}return category;
	}
	
	
	@GetMapping("get-all-category")
	public List<Category> getAllCategory(){
		List<Category> list = service.getAllCategory();
		return list;
	}
	
	
	
	@DeleteMapping("delete-category-by-id/{id}")
	public Object deleteCategoryById(@PathVariable long id){
		//List<Category> list = new ArrayList<Category>();
		Object	obj = service.deleteCategory(id);
	if(obj==(Object)1) {
		throw new ResourceNotExistsExceptions("Category Not Exists With Id =" + id  );
	}else if(obj==(Object)2) {
		throw new ResourceNotExistsExceptions("Category Not Exists.");
	}
		return obj;
		
	}
	
	
	
	@PutMapping("update-category")
		public Category updateCategory(@RequestBody Category category) {
	Category cate =	service.updateCategory(category);
	if(cate==null) {
		throw new ResourceNotExistsExceptions("Category Not Exists");
	}
			return cate;
		
	}
	
	
	
	
	
	
	
	
}
