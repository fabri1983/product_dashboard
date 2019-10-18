package org.fabri1983.eshopping.product.dashboard.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductUpdateView extends BaseView {

	@JsonProperty("retail_price")
	private Double retailPrice;
	@JsonProperty("discounted_price")
	private Double discountedPrice;
	@JsonProperty("availability")
	private Boolean availability;
	
	public ProductUpdateView() {
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
	
}
