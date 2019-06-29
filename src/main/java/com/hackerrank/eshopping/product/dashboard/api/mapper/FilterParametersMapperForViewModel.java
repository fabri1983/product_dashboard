package com.hackerrank.eshopping.product.dashboard.api.mapper;

import com.hackerrank.eshopping.product.dashboard.model.ProductFilterParameters;
import com.hackerrank.eshopping.product.dashboard.view.ProductFilterParametersView;

import org.mapstruct.Mapper;

@Mapper
public interface FilterParametersMapperForViewModel {

	ProductFilterParameters toModel(ProductFilterParametersView filterParametersView);
	
}
