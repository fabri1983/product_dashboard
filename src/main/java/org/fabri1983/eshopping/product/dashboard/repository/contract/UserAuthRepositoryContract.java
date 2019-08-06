package org.fabri1983.eshopping.product.dashboard.repository.contract;

import org.fabri1983.eshopping.product.dashboard.model.UserAuth;

public interface UserAuthRepositoryContract {

	UserAuth findByUsername(String username);

}
