package com.soprasteria.devopsassesmenttool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.devopsassesmenttool.model.Category;
import com.soprasteria.devopsassesmenttool.sevice.CategoryService;
import com.soprasteria.devopsassesmenttool.sevice.QuestionService;

@RestController
@RequestMapping("/devops")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/getAllCategories", method = RequestMethod.GET)
	public List<Category> getCategories( @RequestParam(defaultValue="DEVOPS") String type) {
		return categoryService.getCategories(type);
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public Category getCategoryById(@PathVariable(value = "categoryId") Long categoryId) {
		return categoryService.getCategoryById(categoryId);
	}

	@RequestMapping(value = "/category", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId,
			@RequestBody Category category) {
		return categoryService.updateCategoryById(categoryId, category);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCategoryById(@PathVariable(value = "categoryId") Long categoryId) {
		return categoryService.deleteCategoryById(categoryId);
	}

}
