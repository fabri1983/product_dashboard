package com.hackerrank.eshopping.product.dashboard.repository.entity.sorter;

import java.util.Collection;

public interface EntitySorter<T> {

	Collection<T> sort(Collection<T> collection);
	
}
