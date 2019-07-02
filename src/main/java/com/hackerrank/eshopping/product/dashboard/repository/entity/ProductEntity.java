package com.hackerrank.eshopping.product.dashboard.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity( name = "Product" )
@Table( name = "tbl_product" )
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column( nullable = false )
	private String name;
	@Column( nullable = false )
	private String category;
	@Column( nullable = false )
	private Double retailPrice;
	@Column( nullable = false )
	private Double discountedPrice;
	@Column( nullable = false )
	private Boolean availability;
	@Formula( "ROUND( ((retailPrice - discountedPrice) / retailPrice) * 100 )" )
	private Integer discountedPercentage;
	
	public ProductEntity() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@Transient
	public Integer getDiscountedPercentage() {
		return discountedPercentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((discountedPrice == null) ? 0 : discountedPrice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((retailPrice == null) ? 0 : retailPrice.hashCode());
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
		ProductEntity other = (ProductEntity) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (discountedPrice == null) {
			if (other.discountedPrice != null)
				return false;
		} else if (!discountedPrice.equals(other.discountedPrice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (retailPrice == null) {
			if (other.retailPrice != null)
				return false;
		} else if (!retailPrice.equals(other.retailPrice))
			return false;
		return true;
	}

}
