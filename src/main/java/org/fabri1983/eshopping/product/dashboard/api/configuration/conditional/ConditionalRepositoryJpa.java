package org.fabri1983.eshopping.product.dashboard.api.configuration.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalRepositoryJpa implements Condition {
	
	private final Profiles profiles = Profiles.of("repository-jpa");
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return !context.getEnvironment().acceptsProfiles(profiles);
	}

}
