package org.fabri1983.eshopping.product.dashboard.business.mapper;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.model.RoleAuth;
import org.fabri1983.eshopping.product.dashboard.model.UserAuth;
import org.fabri1983.eshopping.product.dashboard.repository.entity.RoleAuthEntity;
import org.fabri1983.eshopping.product.dashboard.repository.entity.UserAuthEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleAuthMapperForModelEntity {

	RoleAuth toModel(RoleAuthEntity roleAuthEntity);
	
	List<RoleAuth> toModel(List<RoleAuthEntity> roleAuthEntities);
	
	UserAuthEntity toEntity(RoleAuth roleAuth);
    
	List<RoleAuthEntity> toEntity(List<UserAuth> roleAuths);
	
}
