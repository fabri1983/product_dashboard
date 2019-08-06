package org.fabri1983.eshopping.product.dashboard.service.contract;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.view.ProductCreateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductFilterParametersView;
import org.fabri1983.eshopping.product.dashboard.view.ProductUpdateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductView;

public interface ProductServiceContract {

	List<ProductView> findAll(ProductFilterParametersView filterParametersView);
	
	ProductView findById(Long productId);
	
	ProductView add(ProductCreateView productCreateView);

	ProductView update(ProductUpdateView productUpdateView);

	void delete(ProductView productView);
	
}
