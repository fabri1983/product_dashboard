package org.fabri1983.eshopping.product.dashboard.api.configuration;

import org.fabri1983.eshopping.product.dashboard.api.configuration.conditional.ConditionalRepositoryInMemory;
import org.fabri1983.eshopping.product.dashboard.api.configuration.conditional.ConditionalRepositoryJpa;
import org.fabri1983.eshopping.product.dashboard.api.mapper.FilterParametersMapperForViewModel;
import org.fabri1983.eshopping.product.dashboard.api.mapper.FilterParametersMapperForViewModelImpl;
import org.fabri1983.eshopping.product.dashboard.api.mapper.ProductMapperForViewModel;
import org.fabri1983.eshopping.product.dashboard.api.mapper.ProductMapperForViewModelImpl;
import org.fabri1983.eshopping.product.dashboard.business.ProductBusiness;
import org.fabri1983.eshopping.product.dashboard.business.UserAuthBusiness;
import org.fabri1983.eshopping.product.dashboard.business.contract.ProductBusinessContract;
import org.fabri1983.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntity;
import org.fabri1983.eshopping.product.dashboard.business.mapper.ProductMapperForModelEntityImpl;
import org.fabri1983.eshopping.product.dashboard.business.mapper.RoleAuthMapperForModelEntity;
import org.fabri1983.eshopping.product.dashboard.business.mapper.RoleAuthMapperForModelEntityImpl;
import org.fabri1983.eshopping.product.dashboard.business.mapper.UserAuthMapperForModelEntity;
import org.fabri1983.eshopping.product.dashboard.business.mapper.UserAuthMapperForModelEntityImpl;
import org.fabri1983.eshopping.product.dashboard.repository.ProductInMemoryRepository;
import org.fabri1983.eshopping.product.dashboard.repository.ProductJpaRepository;
import org.fabri1983.eshopping.product.dashboard.repository.RoleAuthJpaRepository;
import org.fabri1983.eshopping.product.dashboard.repository.UserAuthJpaRepository;
import org.fabri1983.eshopping.product.dashboard.repository.contract.ProductRepositoryContract;
import org.fabri1983.eshopping.product.dashboard.repository.contract.RoleAuthRepositoryContract;
import org.fabri1983.eshopping.product.dashboard.repository.contract.UserAuthRepositoryContract;
import org.fabri1983.eshopping.product.dashboard.repository.dao.ProductDao;
import org.fabri1983.eshopping.product.dashboard.repository.dao.RoleAuthDao;
import org.fabri1983.eshopping.product.dashboard.repository.dao.UserAuthDao;
import org.fabri1983.eshopping.product.dashboard.service.ProductService;
import org.fabri1983.eshopping.product.dashboard.service.contract.ProductServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

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
	public UserAuthMapperForModelEntity userAuthMapperForModelEntity() {
		return new UserAuthMapperForModelEntityImpl();
	}
	
	@Bean
	public RoleAuthMapperForModelEntity roleAuthMapperForModelEntity() {
		return new RoleAuthMapperForModelEntityImpl();
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
	public UserDetailsService UserAuthBusiness(UserAuthRepositoryContract userAuthRepository) {
		return new UserAuthBusiness(userAuthRepository);
	}
	
	@Bean
	@Conditional(ConditionalRepositoryInMemory.class)
	public ProductRepositoryContract productRepository(ProductMapperForModelEntity productMapper) {
		return new ProductInMemoryRepository(productMapper);
	}
	
	@Bean
	@Conditional(ConditionalRepositoryJpa.class)
	public ProductRepositoryContract productRepository(ProductMapperForModelEntity productMapper,
			@Autowired ProductDao productDao) {
		return new ProductJpaRepository(productDao, productMapper);
	}
	
	@Bean
	public UserAuthRepositoryContract userAuthRepository(UserAuthMapperForModelEntity userAuthMapper,
			@Autowired UserAuthDao userAuthDao) {
		return new UserAuthJpaRepository(userAuthDao, userAuthMapper);
	}
	
	@Bean
	public RoleAuthRepositoryContract roleAuthRepository(RoleAuthMapperForModelEntity roleAuthMapper,
			@Autowired RoleAuthDao roleAuthDao) {
		return new RoleAuthJpaRepository(roleAuthDao, roleAuthMapper);
	}
	
}
