package com.hackerrank.eshopping.product.dashboard.service.contract;

import com.hackerrank.eshopping.product.dashboard.view.ProductFilterParametersView;
import com.hackerrank.eshopping.product.dashboard.view.ProductCreateView;
import com.hackerrank.eshopping.product.dashboard.view.ProductUpdateView;
import com.hackerrank.eshopping.product.dashboard.view.ProductView;

import java.util.List;

public interface ProductServiceContract {

	List<ProductView> findAll(ProductFilterParametersView filterParametersView);
	
	ProductView findById(Long productId);
	
	ProductView add(ProductCreateView productCreateView);

	ProductView update(ProductUpdateView productUpdateView);

	void delete(ProductView productView);
	
}
