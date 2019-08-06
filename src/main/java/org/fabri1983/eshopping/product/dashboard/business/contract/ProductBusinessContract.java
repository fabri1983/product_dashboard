package org.fabri1983.eshopping.product.dashboard.business.contract;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.model.Product;
import org.fabri1983.eshopping.product.dashboard.model.ProductFilterParameters;
import org.fabri1983.eshopping.product.dashboard.model.ProductUpdate;

public interface ProductBusinessContract {
	
	List<Product> findAll(ProductFilterParameters filterParameters);

	Product findById(Long productId);
	
	Product add(Product product);

	Product update(ProductUpdate productUpdate);

	void delete(Product product);
	
}
