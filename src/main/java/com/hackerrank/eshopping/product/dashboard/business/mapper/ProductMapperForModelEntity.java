package com.hackerrank.eshopping.product.dashboard.business.mapper;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.repository.entity.ProductEntity;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ProductMapperForModelEntity {

	Product toModel(ProductEntity productEntity);
	List<Product> toModel(List<ProductEntity> productEntities);
	ProductEntity toEntity(Product product);
    List<ProductEntity> toEntity(List<Product> products);
    
}
