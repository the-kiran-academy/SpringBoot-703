package com.jbk.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exceptions.ResourceNotExistsExceptions;
import com.jbk.exceptions.SupplierAlreadyExistsException;
import com.jbk.model.Product;
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

		if (status == 1) {
			return "Supplier Added !!";
		} else if (status == 2) {
			throw new SupplierAlreadyExistsException("Supplier Already Exists");
		} else {
			return "Invalid Data";
		}
	}

	@GetMapping("/get-supplier-by-id/{supplierId}")
	public Supplier getSupplierById(@PathVariable long supplierId) {

		Supplier supplier = service.getSupplierById(supplierId);
		if (supplier != null) {
			return supplier;
		} else {
			throw new ResourceNotExistsExceptions("Supplier Not Exists With Id = " + supplierId +" : /get-supplier-by-id/"+supplierId);
		}

	}

	@GetMapping("/get-all-supplier")
	public List<Supplier> getAllSupplier() {
		List<Supplier> list = service.getAllSupplier();

		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotExistsExceptions("Supplier Not Exists");
		}
	}
	
	
	@DeleteMapping("/delete-supplier/{supplierId}")
	public Object deleteSupplier(@PathVariable long supplierId){
		Object obj = service.deleteSupplier(supplierId);
		if(obj == (Object)1) {
			throw new ResourceNotExistsExceptions("Supplier Not Exists With Id = " + supplierId +" : /delete-supplier-by-id/"+supplierId);
		}else if(obj==(Object)2) {
			throw new ResourceNotExistsExceptions("Supplier Not Exists");
		}
		return obj;
		
	}
	
	
	
	
	
	@PutMapping("/update-supplier")
	public Supplier updateSupplier(@RequestBody @Valid Supplier supplier) {
	Supplier supplier1 = service.updateSupplier(supplier);
		if(supplier1==null) {
			throw new ResourceNotExistsExceptions("Supplier Not Exists");
	}return supplier1;
	}
	
	 

}
