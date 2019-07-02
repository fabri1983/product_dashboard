package com.hackerrank.eshopping.product.dashboard.business.contract;

import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;

import java.util.List;

public interface ProductBusinessContract {
	
	List<Product> findAll(ProductFilterParameters filterParameters);

	Product findById(Long productId);
	
	Product add(Product product);

	Product update(ProductUpdate productUpdate);

	void delete(Product product);
	
}
