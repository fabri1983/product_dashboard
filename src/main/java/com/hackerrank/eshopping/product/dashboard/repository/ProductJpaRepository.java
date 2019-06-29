package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntity;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;
import com.hackerrank.eshopping.product.dashboard.repository.contract.ProductRepositoryContract;
import com.hackerrank.eshopping.product.dashboard.repository.dao.ProductDao;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.List;
import java.util.Objects;

public class ProductJpaRepository implements ProductRepositoryContract {

	private ProductDao productDao;
	private ProductMapperForModelEntity productMapper;
	
	public ProductJpaRepository(ProductDao productDao, ProductMapperForModelEntity productMapper) {
		this.productDao = productDao;
		this.productMapper = productMapper;
	}
	
	@Override
	public List<Product> findAll(ProductFilterParameters filterParameters) {
		
		// TODO [Complete] Once the ProductDao's Queries are finished then invoke new methods
		
		List<ProductEntity> allValues = productDao.findAll();
		return productMapper.toModel(allValues);
	}

	@Override
	public Product findById(Long productId) {
		ProductEntity productEntity = productDao.findById(productId).orElse(null);
		return productMapper.toModel(productEntity);
	}

	@Override
	public void add(Product product) {
		ProductEntity productEntity = productMapper.toEntity(product);
		productDao.save(productEntity);
	}

	@Override
	public Product update(ProductUpdate productUpdate) {
		Long productId = productUpdate.getId();
		// FIXME [NullPointerException] Even we know the entity already exists it is a must to throw exception if entity is missing
		ProductEntity productEntity = productDao.findById(productId).orElse(null);
		updateFieldsIfPresent(productUpdate, productEntity);
		productDao.save(productEntity);
		return productMapper.toModel(productEntity);
	}

	@Override
	public void delete(Product product) {
		Long productId = product.getId();
		productDao.deleteById(productId);
	}

	@Override
	public boolean exist(Long productId) {
		return productDao.existsById(productId);
	}

	private void updateFieldsIfPresent(ProductUpdate productUpdate, ProductEntity productEntity) {
		if (Objects.nonNull(productUpdate.getRetailPrice())) {
			productEntity.setRetailPrice(productUpdate.getRetailPrice());
		}
		if (Objects.nonNull(productUpdate.getDiscountedPrice())) {
			productEntity.setDiscountedPrice(productUpdate.getDiscountedPrice());
		}
		if (Objects.nonNull(productUpdate.getAvailability())) {
			productEntity.setAvailability(productUpdate.getAvailability());
		}
	}
	
}
