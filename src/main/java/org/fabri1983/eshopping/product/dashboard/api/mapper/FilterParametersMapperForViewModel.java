package org.fabri1983.eshopping.product.dashboard.api.mapper;

import org.fabri1983.eshopping.product.dashboard.model.ProductFilterParameters;
import org.fabri1983.eshopping.product.dashboard.view.ProductFilterParametersView;
import org.mapstruct.Mapper;

@Mapper
public interface FilterParametersMapperForViewModel {

	ProductFilterParameters toModel(ProductFilterParametersView filterParametersView);
	
}
