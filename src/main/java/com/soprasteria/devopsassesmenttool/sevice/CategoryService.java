package com.soprasteria.devopsassesmenttool.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soprasteria.devopsassesmenttool.model.Category;
import com.soprasteria.devopsassesmenttool.repository.CategoryRepository;
import com.soprasteria.devopsassesmenttool.util.ResourceNotFoundException;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getCategories(String type) {
		return categoryRepository.getCategoryByAssessmentType(type);
	}

	public Category getCategoryById(Long categoryId) {
		if (!categoryRepository.existsByCId(categoryId)) {
			throw new ResourceNotFoundException("Author with id " + categoryId + " not found");
		}
		return categoryRepository.findByCId(categoryId);

	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);

	}

	public Category updateCategoryById(Long categoryId, Category categoryRequest) {
		if (!categoryRepository.existsByCId(categoryId)) {
			throw new ResourceNotFoundException("category with id " + categoryId + " not found");
		}
		Category category = categoryRepository.findByCId(categoryId);

		if (category != null) {
			throw new ResourceNotFoundException("category with id " + categoryId + " not found");
		}

		category.setcId(categoryRequest.getcId());
		category.setCategoryName(categoryRequest.getCategoryName());
		category.setAssessmentType(categoryRequest.getAssessmentType());
		return categoryRepository.save(category);

	}

	public ResponseEntity<Object> deleteCategoryById(Long categoryId) {
		if (!categoryRepository.existsByCId(categoryId)) {
			throw new ResourceNotFoundException("category with id " + categoryId + " not found");
		}

		categoryRepository.deleteByCId(categoryId);

		return ResponseEntity.ok().build();

	}

}
