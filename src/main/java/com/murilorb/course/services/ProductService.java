package com.murilorb.course.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilorb.course.entities.Category;
import com.murilorb.course.entities.Product;
import com.murilorb.course.entities.dtos.ProductDTO;
import com.murilorb.course.repositories.CategoryRepository;
import com.murilorb.course.repositories.ProductRepository;
import com.murilorb.course.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryService categoryService;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Product insert(Product obj) {
		obj = repository.save(obj);
		saveCategory(obj);
		return obj;
	}

	public Product fromDTO(ProductDTO objDto) {
		Product obj = new Product(null, objDto.getName(), objDto.getDescription(), objDto.getPrice(),
				objDto.getImgUrl());

		for (Long id : objDto.getCategories()) {
			Category category = categoryService.findById(id);
			obj.getCategories().add(category);
			category.getProducts().add(obj);
		}
		return obj;
	}

	private void saveCategory(Product obj) {
		Set<Category> list = obj.getCategories();

		if (!list.isEmpty()) {
			for (Category category : list) {
				categoryRepository.save(category);
			}
		}
	}

}
