package org.fabri1983.eshopping.product.dashboard.service;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.api.mapper.FilterParametersMapperForViewModel;
import org.fabri1983.eshopping.product.dashboard.api.mapper.ProductMapperForViewModel;
import org.fabri1983.eshopping.product.dashboard.business.contract.ProductBusinessContract;
import org.fabri1983.eshopping.product.dashboard.model.Product;
import org.fabri1983.eshopping.product.dashboard.model.ProductFilterParameters;
import org.fabri1983.eshopping.product.dashboard.model.ProductUpdate;
import org.fabri1983.eshopping.product.dashboard.service.contract.ProductServiceContract;
import org.fabri1983.eshopping.product.dashboard.view.ProductCreateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductFilterParametersView;
import org.fabri1983.eshopping.product.dashboard.view.ProductUpdateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductView;

public class ProductService implements ProductServiceContract {

	private ProductBusinessContract productBusiness;
	private ProductMapperForViewModel productMapper;
	private FilterParametersMapperForViewModel filterParamatersMapper;
	
	public ProductService(ProductBusinessContract productBusiness, ProductMapperForViewModel productMapper, 
			FilterParametersMapperForViewModel filterParamatersMapper) {
		this.productBusiness = productBusiness;
		this.productMapper = productMapper;
		this.filterParamatersMapper = filterParamatersMapper;
	}

	@Override
	public List<ProductView> findAll(ProductFilterParametersView filterParametersView) {
		ProductFilterParameters filterParameters = filterParamatersMapper.toModel(filterParametersView);
		List<Product> products = productBusiness.findAll(filterParameters);
		List<ProductView> productViews = productMapper.toViewList(products);
		return productViews;
	}

	@Override
	public ProductView findById(Long productId) {
		Product product = productBusiness.findById(productId);
		ProductView productView = productMapper.toView(product);
		return productView;
	}

	@Override
	public ProductView add(ProductCreateView productCreateView) {
		Product product = productMapper.toModel(productCreateView);
		Product newProduct = productBusiness.add(product);
		ProductView productView = productMapper.toView(newProduct);
		return productView;
	}

	@Override
	public ProductView update(ProductUpdateView productUpdateView) {
		ProductUpdate productUpdate = productMapper.toModel(productUpdateView);
		Product product = productBusiness.update(productUpdate);
		ProductView productView = productMapper.toView(product);
		return productView;
	}

	@Override
	public void delete(ProductView productView) {
		Product product = productMapper.toModel(productView);
		productBusiness.delete(product);
	}

}
