package com.blogs.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dtos.ApiResponse;
import com.blogs.dtos.CategoryDTO;
import com.blogs.entities.Category;
import com.blogs.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	// depcy - dao
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category addNewCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);// rets persistent
	}// rets DETACHED entity to the caller
	/*
	 * returning from @Transactional -> session.flush -> insert -> session.close
	 */

	@Override
	public CategoryDTO getCategoryById(Long id) {

		 Category category = categoryRepository.findById(id) // Optional<Category>
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category Id !!!!"));
		 return mapper.map(category, CategoryDTO.class);
	}

	@Override
	public ApiResponse updateCategoryDetails(Long id, Category category) {
		String mesg = "Updation failed!!!!";
		// validate id
		if (categoryRepository.existsById(id)) {
			// category id valid
			categoryRepository.save(category);
			mesg = "Updated category details !";
		} else
			throw new ResourceNotFoundException("Invalid Category ID !!!");
		return new ApiResponse(mesg);
	}

	@Override
	public ApiResponse deleteCategoryDetails(Long id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!"));
		//id valid
		categoryRepository.delete(category);
		return new ApiResponse("Category deleted : id "+id);
	}

}
