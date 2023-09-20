package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exceptions.SupplierAlreadyExistsException;
import com.jbk.model.Supplier;
import com.jbk.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService service;
	
	
	@PostMapping("/add-supplier")
	public String addSupplier(@RequestBody @Valid Supplier supplier) {
		
		int status = service.addSupplier(supplier);
		
		if(status==1) {
			return "Supplier Added !!";
		}else if(status==2) {
			throw new SupplierAlreadyExistsException("Supplier Already Exists");
		}else {
			return "Invalid Data";
		}
	}

}
