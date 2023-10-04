package com.jbk.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exceptions.ProductAlreadyExistsException;
import com.jbk.exceptions.ResourceNotExistsExceptions;
import com.jbk.exceptions.SupplierAlreadyExistsException;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@PostMapping("/save-product")
	public String addProduct(@RequestBody @Valid Product product) throws Exception 
	{
	int stutas = service.saveProduct(product);
	if(stutas==1) {
		return "product added!";
	}else if(stutas==2){
		throw new ProductAlreadyExistsException("product Already Exists");
	}
		return "Invalid data";
	}
	
	
	
	@DeleteMapping("delete-product/{pid}")
	public Object deleteProduct(@PathVariable long pid)
	{
		
	Object obj = service.deleteProduct(pid);
	if(obj==(Object)1) {
		throw new ResourceNotExistsExceptions("Product Not Exists With Id = " + pid +" : /delete-product-by-id/"+pid);
	}else if(obj==(Object)2) {
		throw new ResourceNotExistsExceptions("Product not exist");
	}
		return obj;
		
	}
	
	
	
	@GetMapping("/get-product-by-id/{pid}")
    public ResponseEntity<?> getProductById(@PathVariable long pid)
	{
        Product product = service.getProductById(pid);
        
       System.out.println(product);

        if (product == null) 
        {
            // Return a 404 Not Found response with a custom message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Product ID");
        }

        // Return a 200 OK response with the product
        return ResponseEntity.ok(product);
    }

	
	
	
	@GetMapping("/get-all-product")
	public List<Product> getAllProduct(){
	List<Product> list =service.getAllProduct();
	if(!list.isEmpty()) {
		return list;
	}else {
		throw new ResourceNotExistsExceptions("Product not exist.");
	}
		}
	
	
	
	@PutMapping("/update-product")
	public Product updateProduct(@RequestBody @Valid Product product) {
	Product obj =service.updateProduct(product);
		if(obj==null) {
			throw new ResourceNotExistsExceptions("Product not exists.");
		}
		return obj;
		
	}
	
	@GetMapping("get-final-price/{id}")
	public Product productFinalPrice(@PathVariable long id) {
		return service.;
		
	}

}
