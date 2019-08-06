package org.fabri1983.eshopping.product.dashboard.api.controller;

public class BaseController {

	protected final String AUTH_ADMIN_OR_STANDARD = "hasAuthority('ADMIN') or hasAuthority('STANDARD')";
	protected final String AUTH_ADMIN = "hasAuthority('ADMIN')";
	
}
