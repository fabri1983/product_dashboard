package org.fabri1983.eshopping.product.dashboard.business;

import java.util.List;
import java.util.Objects;

import org.fabri1983.eshopping.product.dashboard.business.contract.ProductBusinessContract;
import org.fabri1983.eshopping.product.dashboard.business.validation.ValidationStatus;
import org.fabri1983.eshopping.product.dashboard.model.Product;
import org.fabri1983.eshopping.product.dashboard.model.ProductFilterParameters;
import org.fabri1983.eshopping.product.dashboard.model.ProductUpdate;
import org.fabri1983.eshopping.product.dashboard.repository.contract.ProductRepositoryContract;

public class ProductBusiness implements ProductBusinessContract {

	private ProductRepositoryContract productRepository;
	
	public ProductBusiness(ProductRepositoryContract productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll(ProductFilterParameters filterParameters) {
		return productRepository.findAll(filterParameters);
	}

	@Override
	public Product findById(Long productId) {
		Product product = productRepository.findById(productId);
		productDoesNotExistThenThrow(product);
		return product;
	}

	@Override
	public Product add(Product product) {
		productIdExistsThenThrow(product.getId());
		Product newProduct = productRepository.add(product);
		return newProduct;
	}

	@Override
	public Product update(ProductUpdate productUpdate) {
		productIdDoesNotExistThenThrow(productUpdate.getId());
		Product product = productRepository.update(productUpdate);
		return product;
	}

	@Override
	public void delete(Product product) {
		productIdDoesNotExistThenThrow(product.getId());
		productRepository.delete(product);
	}

	private void productDoesNotExistThenThrow(Product product) {
		if (Objects.isNull(product)) {
			throw ValidationStatus.PRODUCT_DOES_NOT_EXIST._throw();
		}
	}

	private void productIdExistsThenThrow(Long productId) {
		if (productRepository.exist(productId)) {
			throw ValidationStatus.PRODUCT_ID_ALREADY_EXIST._throw();
		}
	}

	private void productIdDoesNotExistThenThrow(Long productId) {
		if (!productRepository.exist(productId)) {
			throw ValidationStatus.PRODUCT_ID_DOES_NOT_EXIST._throw();
		}
	}
	
}
