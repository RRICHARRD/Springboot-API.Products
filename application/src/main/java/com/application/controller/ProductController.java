package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Product;
import com.application.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/test")
	public String test() {
		return "OK";
	}
	
	@GetMapping("/show")
	public List<Product> showProducts() {
		return productRepository.findAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Product addNewProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	
}
