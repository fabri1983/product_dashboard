package com.hackerrank.eshopping.product.dashboard.repository.entity.filter;

import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductEntityFiltering implements EntityFiltering<ProductEntity> {

	private ProductFilterParameters filterParameters;
	
	private ProductEntityFiltering() {
	}
	
	public static ProductEntityFiltering from(ProductFilterParameters filterParameters) {
		ProductEntityFiltering newObj = new ProductEntityFiltering();
		newObj.filterParameters = filterParameters;
		return newObj;
	}

	@Override
	public List<ProductEntity> filter(Collection<ProductEntity> collection) {
		// TODO [Improvement] If no filters were set then return the collection as List
		return collection.stream()
			.filter( p -> test(p) )
			.collect( Collectors.toList() );
	}
	
	@Override
	public boolean test(ProductEntity p) {
		
		// TODO [Maintainability] Encapsulate the conditions in a FilterStrategyExecutor such that every condition is a 
		// strategy and all are chained to be executed sequentially or in parallel with a reduction operation.
		
		boolean testResult = true;
		
		if (filterParameters.hasCategory()) {
			testResult &= satisfyCategory(p);
		}
		if (filterParameters.hasAvailability()) {
			testResult &= satisfyAvailability(p);
		}
		
		return testResult;
	}
	
	private boolean satisfyCategory(ProductEntity p) {
		return filterParameters.getCategory().equals(p.getCategory());
	}

	private boolean satisfyAvailability(ProductEntity p) {
		return filterParameters.getAvailability().equals(p.getAvailability());
	}
	
}
