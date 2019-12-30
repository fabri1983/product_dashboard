package org.fabri1983.eshopping.product.dashboard.business.mapper;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.model.UserAuth;
import org.fabri1983.eshopping.product.dashboard.repository.entity.UserAuthEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserAuthMapperForModelEntity {

	UserAuth toModel(UserAuthEntity userAuthEntity);
	
	List<UserAuth> toModelList(List<UserAuthEntity> userAuthEntities);
	
	UserAuthEntity toEntity(UserAuth userAuth);
    
	List<UserAuthEntity> toEntityList(List<UserAuth> userAuths);
	
}
