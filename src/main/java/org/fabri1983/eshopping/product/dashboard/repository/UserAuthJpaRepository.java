package org.fabri1983.eshopping.product.dashboard.repository;

import org.fabri1983.eshopping.product.dashboard.business.mapper.UserAuthMapperForModelEntity;
import org.fabri1983.eshopping.product.dashboard.model.UserAuth;
import org.fabri1983.eshopping.product.dashboard.repository.contract.UserAuthRepositoryContract;
import org.fabri1983.eshopping.product.dashboard.repository.dao.UserAuthDao;
import org.fabri1983.eshopping.product.dashboard.repository.entity.UserAuthEntity;

public class UserAuthJpaRepository implements UserAuthRepositoryContract {

	private UserAuthDao userAuthDao;
	private UserAuthMapperForModelEntity userAuthMapper;
	
	public UserAuthJpaRepository(UserAuthDao userAuthDao, UserAuthMapperForModelEntity userAuthMapper) {
		this.userAuthDao = userAuthDao;
		this.userAuthMapper = userAuthMapper;
	}

	@Override
	public UserAuth findByUsername(String username) {
		UserAuthEntity entity = userAuthDao.findByUsername(username);
		return userAuthMapper.toModel(entity);
	}

}
