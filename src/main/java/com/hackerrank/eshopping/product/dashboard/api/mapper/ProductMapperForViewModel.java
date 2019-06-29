package com.hackerrank.eshopping.product.dashboard.api.mapper;

import com.hackerrank.eshopping.product.dashboard.model.Product;
import com.hackerrank.eshopping.product.dashboard.model.ProductUpdate;
import com.hackerrank.eshopping.product.dashboard.view.ProductCreateView;
import com.hackerrank.eshopping.product.dashboard.view.ProductUpdateView;
import com.hackerrank.eshopping.product.dashboard.view.ProductView;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ProductMapperForViewModel {

	Product toModel(ProductView productView);
	Product toModel(ProductCreateView productCreateView);
	ProductUpdate toModel(ProductUpdateView productUpdateView);
    ProductView toView(Product product);
    List<ProductView> toView(List<Product> products);
    
}
