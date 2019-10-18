package org.fabri1983.eshopping.product.dashboard.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductView extends BaseView {

	@JsonProperty("name")
	private String name;
	@JsonProperty("category")
	private String category;
	@JsonProperty("retail_price")
	private Double retailPrice;
	@JsonProperty("discounted_price")
	private Double discountedPrice;
	@JsonProperty("availability")
	private Boolean availability;

	public ProductView() {
	}
	
	public static ProductView from(Long id) {
		ProductView newObj = new ProductView();
		newObj.id = id;
		return newObj;
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
	
}
