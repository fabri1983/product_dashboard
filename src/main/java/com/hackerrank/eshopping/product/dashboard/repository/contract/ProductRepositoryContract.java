package com.hackerrank.eshopping.product.dashboard.repository.contract;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;
import com.hackerrank.eshopping.product.dashboard.repository.functional.IFunctional;

import java.util.List;
import java.util.Objects;

public interface ProductRepositoryContract extends IFunctional {

	List<Product> findAll(ProductFilterParameters filterParameters);

	Product findById(Long productId);
	
	Product add(Product product);

	Product update(ProductUpdate productUpdate);

	void delete(Product product);
	
	boolean exist(Long productId);

	default void updateFieldsIfPresent(ProductUpdate productUpdate, ProductEntity productEntity) {
		if (Objects.nonNull(productUpdate.getRetailPrice())) {
			productEntity.setRetailPrice(productUpdate.getRetailPrice());
		}
		if (Objects.nonNull(productUpdate.getDiscountedPrice())) {
			productEntity.setDiscountedPrice(productUpdate.getDiscountedPrice());
		}
		if (Objects.nonNull(productUpdate.getAvailability())) {
			productEntity.setAvailability(productUpdate.getAvailability());
		}
	}
	
}
