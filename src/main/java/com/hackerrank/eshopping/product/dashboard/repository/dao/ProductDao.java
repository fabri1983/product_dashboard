package com.hackerrank.eshopping.product.dashboard.repository.dao;

import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<ProductEntity, Long> {

	// TODO [Complete] This query is not finished. Missing Order Clause 
	@Query("FROM Product WHERE category = ?1")
    List<ProductEntity> findByCategory(String category);
	
	// TODO [Complete] This query is not finished. Missing Order Clause
	@Query("FROM Product WHERE category = ?1 AND avalibility = ?2")
    List<ProductEntity> findByCategoryAndAvailability(String category, Boolean availability);
	
}
