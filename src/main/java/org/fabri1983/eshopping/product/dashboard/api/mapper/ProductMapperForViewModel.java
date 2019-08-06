package org.fabri1983.eshopping.product.dashboard.api.mapper;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.model.Product;
import org.fabri1983.eshopping.product.dashboard.model.ProductUpdate;
import org.fabri1983.eshopping.product.dashboard.view.ProductCreateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductUpdateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductView;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapperForViewModel {

	Product toModel(ProductView productView);
	Product toModel(ProductCreateView productCreateView);
	ProductUpdate toModel(ProductUpdateView productUpdateView);
    ProductView toView(Product product);
    List<ProductView> toView(List<Product> products);
    
}
