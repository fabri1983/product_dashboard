package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntity;
import com.hackerrank.eshopping.product.dashboard.business.validation.ValidationStatus;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;
import com.hackerrank.eshopping.product.dashboard.repository.contract.ProductRepositoryContract;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;
import com.hackerrank.eshopping.product.dashboard.repository.entity.filter.ProductEntityFiltering;
import com.hackerrank.eshopping.product.dashboard.repository.entity.sorter.ProductEntitySorter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductInMemoryRepository implements ProductRepositoryContract {

	private ProductMapperForModelEntity productMapper;
	
	/**
	 * ConcurrentMap: thread-safety with high throughput under high concurrency, and memory-consistent atomic operations.
	 */
	private final Map<Long, ProductEntity> database = new ConcurrentHashMap<>();
	
	public ProductInMemoryRepository(ProductMapperForModelEntity productMapper) {
		this.productMapper = productMapper;
	}
	
	@Override
	public List<Product> findAll(ProductFilterParameters filterParameters) {
		Collection<ProductEntity> allValues = database.values();
		
		ProductEntityFiltering filtering = ProductEntityFiltering.from(filterParameters);
		List<ProductEntity> filteredEntities = filtering.filter(allValues);
		
		ProductEntitySorter sorter = ProductEntitySorter.from(filterParameters);
		List<ProductEntity> sortedEntities = sorter.sort(filteredEntities);
		
		return productMapper.toModel(sortedEntities);
	}

	@Override
	public Product findById(Long productId) {
		ProductEntity productEntity = database.get(productId);
		return productMapper.toModel(productEntity);
	}

	@Override
	public Product add(Product product) {
		Long productId = product.getId();
		ProductEntity productEntity = productMapper.toEntity(product);
		prePersist(productEntity);
		database.put(productId, productEntity);
		return productMapper.toModel(productEntity);
	}

	@Override
	public Product update(ProductUpdate productUpdate) {
		Long productId = productUpdate.getId();
		ProductEntity productEntity = database.get(productId);
		validateEntityIsValidOrThrow(productEntity);
		updateFieldsIfPresent(productUpdate, productEntity);
		preUpdate(productEntity);
		database.put(productId, productEntity);
		return productMapper.toModel(productEntity);
	}

	@Override
	public void delete(Product product) {
		Long productId = product.getId();
		database.remove(productId);
	}

	@Override
	public boolean exist(Long productId) {
		return database.containsKey(productId);
	}

	private void prePersist(ProductEntity productEntity) {
		LocalDateTime now = now();
		productEntity.setCreatedOn(now);
		productEntity.setModifiedAt(now);
	}

	private void preUpdate(ProductEntity productEntity) {
		LocalDateTime now = now();
		productEntity.setModifiedAt(now);
	}

	private void validateEntityIsValidOrThrow(ProductEntity entity) {
		if (entity == null) {
			ValidationStatus.PRODUCT_DOES_NOT_EXIST._throw();
		}
	}

}
