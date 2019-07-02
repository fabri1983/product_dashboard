package com.hackerrank.eshopping.product.dashboard.repository.entity;

import com.hackerrank.eshopping.product.dashboard.repository.functional.IFunctional;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable, IFunctional {

	private static final long serialVersionUID = 1L;

	@Id
	@Column( nullable = false )
	protected Long id;

	@Column( nullable = false,
			// once the entity is persisted this field can not be modified
			updatable = false )
	protected LocalDateTime createdOn;
	
	@Column( nullable = false )
    protected LocalDateTime modifiedAt;

    @PrePersist
    protected void prePersist() {
    	LocalDateTime now = now();
		createdOn = now;
        modifiedAt = now;
    }

    @PreUpdate
    protected void preUpdate() {
    	modifiedAt = now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modifiedAt == null) {
			if (other.modifiedAt != null)
				return false;
		} else if (!modifiedAt.equals(other.modifiedAt))
			return false;
		return true;
	}
    
}