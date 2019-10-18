package org.fabri1983.eshopping.product.dashboard.model;

import java.util.Objects;

public class RoleAuth extends BaseModel {

	private String roleName;
	private String description;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description, roleName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleAuth other = (RoleAuth) obj;
		return Objects.equals(description, other.description) && Objects.equals(roleName, other.roleName);
	}

}
