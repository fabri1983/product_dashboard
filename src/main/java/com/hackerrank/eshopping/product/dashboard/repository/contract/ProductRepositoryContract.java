package com.hackerrank.eshopping.product.dashboard.repository.contract;

import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;

import java.util.List;

public interface ProductRepositoryContract {

	List<Product> findAll(ProductFilterParameters filterParameters);

	Product findById(Long productId);
	
	void add(Product product);

	Product update(ProductUpdate productUpdate);

	void delete(Product product);
	
	boolean exist(Long productId);

}
