package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.dao.ProductDao;
import com.jbk.model.Address;
import com.jbk.model.Category;
import com.jbk.model.Product;
import com.jbk.model.Supplier;

@Repository

public class ProductDaoImpl implements ProductDao {

	List<Product> list = new ArrayList<>();

	public ProductDaoImpl() {
		list.add(new Product(1l, "pen", 19.99d, 100, "This is a sample product description.",
				new java.sql.Date(2022, 8, 13), new java.sql.Date(2024, 8, 13),
				new Supplier(1l, "Yash Distributor", "9011223344",
						new Address(1l, "pune", "pune", "Maharashtra", "411052")),
				new Category(2l, "General", "general product", 3, 8, 30d)));

		list.add(new Product(2l, "book", 400d, 100, "This is a sample product description.",
				new java.sql.Date(2022, 8, 13), new java.sql.Date(2024, 8, 13),
				new Supplier(1l, "Yash Distributor", "9011223344",
						new Address(1l, "pune", "pune", "Maharashtra", "411052")),
				new Category(2l, "General", "general product", 3, 8, 30d)));

	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getProductById(long productId) 
	{
		
		for (Product ele : list) 
		{
			if (productId==ele.getProductId())
			{
				return ele;
			}

		}
		return null;

	}

	@Override
	public List<Product> getAllProduct() {

		return list;
	}

	@Override
	public List<Product> deleteProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
