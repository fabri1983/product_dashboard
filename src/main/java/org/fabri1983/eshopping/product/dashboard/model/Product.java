package org.fabri1983.eshopping.product.dashboard.model;

import java.util.Objects;

public class Product extends BaseModel {

	private String name;
	private String category;
	private Double retailPrice;
	private Double discountedPrice;
	private Boolean availability;
	
	public Product() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(availability, category, discountedPrice, name, retailPrice);
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
		Product other = (Product) obj;
		return Objects.equals(availability, other.availability) && Objects.equals(category, other.category)
				&& Objects.equals(discountedPrice, other.discountedPrice) && Objects.equals(name, other.name)
				&& Objects.equals(retailPrice, other.retailPrice);
	}

}
