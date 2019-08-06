package org.fabri1983.eshopping.product.dashboard.repository.dao;

import org.fabri1983.eshopping.product.dashboard.repository.entity.RoleAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAuthDao extends JpaRepository<RoleAuthEntity, Long> {

	RoleAuthEntity findByRoleName(String roleName);
	
}
