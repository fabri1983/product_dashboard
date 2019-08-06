package org.fabri1983.eshopping.product.dashboard.repository.contract;

import org.fabri1983.eshopping.product.dashboard.model.RoleAuth;

public interface RoleAuthRepositoryContract {

	RoleAuth findByRoleName(String roleName);
	
}
