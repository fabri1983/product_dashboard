package org.fabri1983.eshopping.product.dashboard.model;

import java.util.Objects;

public class ProductUpdate extends BaseModel {

	private Double retailPrice;
	private Double discountedPrice;
	private Boolean availability;

	public ProductUpdate() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(availability, discountedPrice, retailPrice);
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
		ProductUpdate other = (ProductUpdate) obj;
		return Objects.equals(availability, other.availability)
				&& Objects.equals(discountedPrice, other.discountedPrice)
				&& Objects.equals(retailPrice, other.retailPrice);
	}

}
