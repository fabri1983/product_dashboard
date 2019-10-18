package org.fabri1983.eshopping.product.dashboard.model;

import java.util.List;

public class UserAuth extends BaseModel {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private List<RoleAuth> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<RoleAuth> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleAuth> roles) {
		this.roles = roles;
	}

}
