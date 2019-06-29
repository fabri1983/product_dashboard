package com.hackerrank.eshopping.product.dashboard.repository.entity.sorter;

import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ProductEntitySorter implements EntitySorter<ProductEntity> {

	private ProductFilterParameters filterParameters;
	
	private ProductEntitySorter() {
	}
	
	public static ProductEntitySorter from(ProductFilterParameters filterParameters) {
		ProductEntitySorter newObj = new ProductEntitySorter();
		newObj.filterParameters = filterParameters;
		return newObj;
	}
	
	@Override
	public List<ProductEntity> sort(Collection<ProductEntity> collection) {
		
		// TODO [Maintainability] Encapsulate the conditions in a SortingStrategyExecutor such that every condition is a 
		// strategy and all are chained in a specific order. The first strategy that applies returns the sorter object (circuit-breaker).
		
		// chain different sorting algorithms according the existent parameters
		ProductEntitySorterFactory sorter = ProductEntitySorterFactory.newDummy();
		
		if (hasNoFilters()) {
			sorter
				.byId(SortingOrder.ASC);
		}
		else if (hasOnlyCategory()) {
			sorter
				// stock products (availability=true) must be listed before out of stock products (availability=false)
				.byAvailability(SortingOrder.DESC)
				// products with same availability status must be sorted by the discounted price in the ascending order
				.byDiscountedPrice(SortingOrder.ASC)
				// products with same discounted price must be sorted by the ID in the ascending order
				.byId(SortingOrder.ASC);
		}
		else if (hasOnlyCategoryAndAvailability()) {
			sorter
				// product sorted by the discount percentage in the descending order
				.byDiscountedPercentage(SortingOrder.DESC)
				// products with same discount percentage status must be sorted by the discounted price in the ascending order
				.byDiscountedPrice(SortingOrder.ASC)
				// products with same discounted price must be sorted by the ID in the ascending order
				.byId(SortingOrder.ASC);
		}
		
		return sorter.sort(collection);
	}
	
	private boolean hasNoFilters() {
		return Objects.isNull(filterParameters.getCategory()) 
				&& Objects.isNull(filterParameters.getCategory());
	}

	private boolean hasOnlyCategory() {
		return Objects.nonNull(filterParameters.getCategory()) 
				&& Objects.isNull(filterParameters.getAvailability());
	}

	private boolean hasOnlyCategoryAndAvailability() {
		return Objects.nonNull(filterParameters.getCategory()) 
				&& Objects.nonNull(filterParameters.getAvailability());
	}

}
