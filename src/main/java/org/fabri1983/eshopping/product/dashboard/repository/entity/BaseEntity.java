package org.fabri1983.eshopping.product.dashboard.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.fabri1983.eshopping.product.dashboard.repository.functional.IFunctional;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable, IFunctional {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	protected Long id;

	@Version
	@Column(name = "version", nullable = false)
	protected Long version;
	
	@Column(name = "createdOn", nullable = false,
			// once the entity is persisted this field can not be modified
			updatable = false)
	protected LocalDateTime createdOn;
	
	@Column(name = "modifiedAt",  nullable = false)
    protected LocalDateTime modifiedAt;

    @PrePersist
    protected void prePersist() {
    	LocalDateTime now = now();
		createdOn = now;
        modifiedAt = now;
        if (version == null) {
    		version = Long.valueOf(1);
		}
    }

    @PreUpdate
    protected void preUpdate() {
    	modifiedAt = now();
    	if (version == null) {
    		version = Long.valueOf(1);
    	} else {
    		version = Long.valueOf(version.longValue() + 1);
    	}
    }

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

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdOn, id, modifiedAt, version);
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
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(id, other.id)
				&& Objects.equals(modifiedAt, other.modifiedAt) && Objects.equals(version, other.version);
	}

}