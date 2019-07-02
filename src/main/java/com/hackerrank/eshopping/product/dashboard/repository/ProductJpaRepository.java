package com.hackerrank.eshopping.product.dashboard.repository;

import com.hackerrank.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntity;
import com.hackerrank.eshopping.product.dashboard.business.validation.ValidationStatus;
import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;
import com.hackerrank.eshopping.product.dashboard.repository.contract.ProductRepositoryContract;
import com.hackerrank.eshopping.product.dashboard.repository.dao.ProductDao;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.Collections;
import java.util.List;

public class ProductJpaRepository implements ProductRepositoryContract {

	private ProductDao productDao;
	private ProductMapperForModelEntity productMapper;
	
	public ProductJpaRepository(ProductDao productDao, ProductMapperForModelEntity productMapper) {
		this.productDao = productDao;
		this.productMapper = productMapper;
	}
	
	@Override
	public List<Product> findAll(ProductFilterParameters filterParameters) {
		List<ProductEntity> entities = Collections.emptyList();
		
		if (filterParameters.hasNoFilters()) {
			entities = productDao.findByOrderByIdAsc();
//			entities = productDao.findAll(Sort.by(Direction.ASC, "id"));
		}
		else if (filterParameters.hasOnlyCategory()) {
			entities = productDao.findByCategoryOrderByAvailabilityDescDiscountedPriceAscIdAsc(
					filterParameters.getCategory());
//			entities = productDao.findByCategory(
//					filterParameters.getCategory(),
//					Sort.by(Order.desc("availability"), Order.asc("discountedPrice"), Order.asc("id")));
		}
		else if (filterParameters.hasOnlyCategoryAndAvailability()) {
			entities = productDao.findByCategoryAndAvailabilityOrderByDiscountedPercentageDescDiscountedPriceAscIdAsc(
					filterParameters.getCategory(),
					filterParameters.getAvailability());
//			entities = productDao.findByCategoryAndAvailability(
//					filterParameters.getCategory(),
//					filterParameters.getAvailability(),
//					Sort.by(Order.desc("discountedPercentage"), Order.asc("discountedPrice"), Order.asc("id")));
		}
		
		return productMapper.toModel(entities);
	}

	@Override
	public Product findById(Long productId) {
		ProductEntity productEntity = productDao.findById(productId).orElse(null);
		return productMapper.toModel(productEntity);
	}

	@Override
	public Product add(Product product) {
		ProductEntity productEntity = productMapper.toEntity(product);
		ProductEntity savedEntity = productDao.save(productEntity);
		return productMapper.toModel(savedEntity);
	}

	@Override
	public Product update(ProductUpdate productUpdate) {
		Long productId = productUpdate.getId();
		ProductEntity productEntity = productDao.findById(productId)
				.orElseThrow( () -> ValidationStatus.PRODUCT_DOES_NOT_EXIST._throw() );
		updateFieldsIfPresent(productUpdate, productEntity);
		ProductEntity savedEntity = productDao.save(productEntity);
		return productMapper.toModel(savedEntity);
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

}
