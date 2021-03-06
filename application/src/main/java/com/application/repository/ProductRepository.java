package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public abstract Product findById(long id);
		
}
