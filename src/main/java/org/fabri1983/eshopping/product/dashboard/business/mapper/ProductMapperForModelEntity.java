package org.fabri1983.eshopping.product.dashboard.business.mapper;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.model.Product;
import org.fabri1983.eshopping.product.dashboard.repository.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapperForModelEntity {

	Product toModel(ProductEntity productEntity);
	
	List<Product> toModel(List<ProductEntity> productEntities);
	
	ProductEntity toEntity(Product product);
    
	List<ProductEntity> toEntity(List<Product> products);
	
}
