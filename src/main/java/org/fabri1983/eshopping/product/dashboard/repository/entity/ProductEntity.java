package org.fabri1983.eshopping.product.dashboard.repository.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity(name = "Product")
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "category", nullable = false)
	private String category;

	@Column(name = "retailPrice", nullable = false)
	private Double retailPrice;

	@Column(name = "discountedPrice", nullable = false)
	private Double discountedPrice;

	@Column(name = "availability", nullable = false)
	private Boolean availability;

	@Column(name = "discountedPercentage")
	@Formula("ROUND( ((retailPrice - discountedPrice) / retailPrice) * 100 )")
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
		result = prime * result
				+ Objects.hash(availability, category, discountedPercentage, discountedPrice, name, retailPrice);
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
		return Objects.equals(availability, other.availability) && Objects.equals(category, other.category)
				&& Objects.equals(discountedPercentage, other.discountedPercentage)
				&& Objects.equals(discountedPrice, other.discountedPrice) && Objects.equals(name, other.name)
				&& Objects.equals(retailPrice, other.retailPrice);
	}

}
