package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.model.Product;
import com.application.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/product")
@Api(value = "Api for manage products")
@CrossOrigin(origins = "*") //Domain access
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/test")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Return \"OK\" if the application is running correctly in server")
	public String test() {
		return "OK";
	}
	
	@GetMapping("/show")
	@ApiOperation(value = "Return a list of product from database configured, in this api is H2")
	public List<Product> showProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/show/{id}")
	@ApiOperation(value = "Return an unique product saved from database configured, it uses the id")
	public Product showProducts(@PathVariable(value = "id") long id) {
		return productRepository.findById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Save a product in database")
	public Product addNewProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value = "Delete a product from database")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "Update a product saved in database")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
