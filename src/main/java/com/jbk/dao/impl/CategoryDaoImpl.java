package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.CategoryDao;
import com.jbk.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	List<Category> list=new ArrayList<>();
	
	public CategoryDaoImpl() {
		list.add(new Category(1, "Electronics", "electronic product", 5, 12, 60));
		list.add(new Category(2, "General", "general product", 3, 8, 30));
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> deleteCategory(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
