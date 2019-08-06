package org.fabri1983.eshopping.product.dashboard.repository.dao;

import org.fabri1983.eshopping.product.dashboard.repository.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthDao extends JpaRepository<UserAuthEntity, Long> {

	UserAuthEntity findByUsername(String username);
	
}
