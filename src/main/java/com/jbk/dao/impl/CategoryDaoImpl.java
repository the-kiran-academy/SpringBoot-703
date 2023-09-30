package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.CategoryDao;
import com.jbk.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	List<Category> list = new ArrayList<>();

	public CategoryDaoImpl() {
		list.add(new Category(1l, "Electronics", "electronic product", 5, 12, 60d));
		list.add(new Category(2l, "General", "general product", 3, 8, 30d));
	}

	private boolean isExists(Category category) {
		boolean isExists = false;

		for (Category dbCategory : list) {
			if (category.getCategoryName().equalsIgnoreCase(dbCategory.getCategoryName())) {

				isExists = true;
				break;

			}
		}

		return isExists;
	}

	@Override
	public int addCategory(Category category) {

		if (isExists(category) == false) {
			list.add(category);
			return 1;
		} else {

			return 2;
		}

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
