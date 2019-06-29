package com.hackerrank.eshopping.product.dashboard;

import com.hackerrank.eshopping.product.dashboard.api.mapper.FilterParametersMapperForViewModel;
import com.hackerrank.eshopping.product.dashboard.api.mapper.FilterParametersMapperForViewModelImpl;
import com.hackerrank.eshopping.product.dashboard.api.mapper.ProductMapperForViewModel;
import com.hackerrank.eshopping.product.dashboard.api.mapper.ProductMapperForViewModelImpl;
import com.hackerrank.eshopping.product.dashboard.business.ProductBusiness;
import com.hackerrank.eshopping.product.dashboard.business.contract.ProductBusinessContract;
import com.hackerrank.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntity;
import com.hackerrank.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntityImpl;
import com.hackerrank.eshopping.product.dashboard.repository.ProductInMemoryRepository;
import com.hackerrank.eshopping.product.dashboard.repository.contract.ProductRepositoryContract;
import com.hackerrank.eshopping.product.dashboard.service.ProductService;
import com.hackerrank.eshopping.product.dashboard.service.contract.ProductServiceContract;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductDashboardConfiguration {

	@Bean
	public ProductMapperForViewModel productMapperForViewModel() {
		return new ProductMapperForViewModelImpl();
	}
	
	@Bean
	public ProductMapperForModelEntity productMapperForModelEntity() {
		return new ProductMapperForModelEntityImpl();
	}
	
	@Bean
	public FilterParametersMapperForViewModel filterParamatersMapperForViewModel() {
		return new FilterParametersMapperForViewModelImpl();
	}
	
	@Bean
	public ProductServiceContract productService(ProductBusinessContract productBusiness,
			ProductMapperForViewModel productMapper, FilterParametersMapperForViewModel filterParamatersMapper) {
		return new ProductService(productBusiness, productMapper, filterParamatersMapper);
	}

	@Bean
	public ProductBusinessContract productBusiness(ProductRepositoryContract productRepository) {
		return new ProductBusiness(productRepository);
	}
	
	@Bean
	public ProductRepositoryContract productRepository(ProductMapperForModelEntity productMapper) {
		return new ProductInMemoryRepository(productMapper);
	}
	
//	@Bean
//	public ProductRepositoryContract productRepository(ProductMapperForModelEntity productMapper,
//			@Autowired ProductDao productDao) {
//		return new ProductJpaRepository(productDao, productMapper);
//	}
	
}
