package org.fabri1983.eshopping.product.dashboard.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class BaseModel {

	protected Long id;
	protected Long version;
	protected LocalDateTime createdOn;
	protected LocalDateTime modifiedOn;
	
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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdOn, id, modifiedOn, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(id, other.id)
				&& Objects.equals(modifiedOn, other.modifiedOn) && Objects.equals(version, other.version);
	}
	
}
