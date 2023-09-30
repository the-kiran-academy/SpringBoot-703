package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exceptions.CategoryAlreadyExistsException;
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
}
