package org.fabri1983.eshopping.product.dashboard.model;

import java.util.Objects;

public class ProductFilterParameters {

	private String category;
	private Boolean availability;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public boolean hasNoFilters() {
		return Objects.isNull(getCategory()) && Objects.isNull(getCategory());
	}

	public boolean hasOnlyCategory() {
		return hasCategory() && Objects.isNull(getAvailability());
	}

	public boolean hasCategory() {
		return Objects.nonNull(getCategory());
	}

	public boolean hasAvailability() {
		return Objects.nonNull(getAvailability());
	}

	public boolean hasOnlyCategoryAndAvailability() {
		return hasCategory() && hasAvailability();
	}

	@Override
	public int hashCode() {
		return Objects.hash(availability, category);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductFilterParameters other = (ProductFilterParameters) obj;
		return Objects.equals(availability, other.availability) && Objects.equals(category, other.category);
	}
	
}
