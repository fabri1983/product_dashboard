package com.hackerrank.eshopping.product.dashboard.repository.entity.filter;

import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

public interface EntityFiltering<T> {

	List<T> filter(Collection<T> collection);

	boolean test(ProductEntity p);
	
}
