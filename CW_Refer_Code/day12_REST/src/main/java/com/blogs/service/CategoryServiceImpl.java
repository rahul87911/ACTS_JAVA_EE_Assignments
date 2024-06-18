package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.entities.Category;
import com.blogs.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	//depcy - dao
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category addNewCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);//rets persistent
	}//rets DETACHED entity to the caller 
	/*
	 * returning from @Transactional
	 * -> session.flush -> insert -> session.close 
	 */
	

}
