package org.fabri1983.eshopping.product.dashboard.repository.entity.filter;

import java.util.Collection;
import java.util.List;

import org.fabri1983.eshopping.product.dashboard.repository.entity.ProductEntity;

public interface EntityFiltering<T> {

	List<T> filter(Collection<T> collection);

	boolean test(ProductEntity p);
	
}
