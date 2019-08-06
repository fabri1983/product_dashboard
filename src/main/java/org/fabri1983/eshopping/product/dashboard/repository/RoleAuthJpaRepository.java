package org.fabri1983.eshopping.product.dashboard.repository;

import org.fabri1983.eshopping.product.dashboard.business.mapper.RoleAuthMapperForModelEntity;
import org.fabri1983.eshopping.product.dashboard.model.RoleAuth;
import org.fabri1983.eshopping.product.dashboard.repository.contract.RoleAuthRepositoryContract;
import org.fabri1983.eshopping.product.dashboard.repository.dao.RoleAuthDao;
import org.fabri1983.eshopping.product.dashboard.repository.entity.RoleAuthEntity;

public class RoleAuthJpaRepository implements RoleAuthRepositoryContract {

	private RoleAuthDao roleAuthDao;
	private RoleAuthMapperForModelEntity roleAuthMapper;
	
	public RoleAuthJpaRepository(RoleAuthDao roleAuthDao, RoleAuthMapperForModelEntity roleAuthMapper) {
		this.roleAuthDao = roleAuthDao;
		this.roleAuthMapper = roleAuthMapper;
	}

	@Override
	public RoleAuth findByRoleName(String roleName) {
		RoleAuthEntity entity = roleAuthDao.findByRoleName(roleName);
		return roleAuthMapper.toModel(entity);
	}

}
