package org.fabri1983.eshopping.product.dashboard.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseView {

	@JsonProperty("id")
	protected Long id;
	@JsonProperty("version")
	protected Long version;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
}
