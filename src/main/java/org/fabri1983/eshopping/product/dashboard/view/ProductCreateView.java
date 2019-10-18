package org.fabri1983.eshopping.product.dashboard.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCreateView extends BaseView {

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

	public ProductCreateView() {
	}
	
	public static ProductCreateView from(Long id) {
		ProductCreateView newObj = new ProductCreateView();
		newObj.id = id;
		return newObj;
	}

	public static ProductCreateViewBuilder builder() {
		return new ProductCreateViewBuilder();
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
	
	public static class ProductCreateViewBuilder {

		ProductCreateView prodView;
		
		public ProductCreateViewBuilder() {
			prodView = new ProductCreateView();
		}
		
		public ProductCreateViewBuilder id(Long id) {
			prodView.setId(id);
			return this;
		}

		public ProductCreateViewBuilder version(Long version) {
			prodView.setVersion(version);
			return this;
		}
		
		public ProductCreateViewBuilder name(String name) {
			prodView.setName(name);
			return this;
		}
		
		public ProductCreateViewBuilder category(String category) {
			prodView.setCategory(category);
			return this;
		}

		public ProductCreateViewBuilder retailPrice(Double retailPrice) {
			prodView.setRetailPrice(retailPrice);
			return this;
		}
		
		public ProductCreateViewBuilder discountedPrice(Double discountedPrice) {
			prodView.setDiscountedPrice(discountedPrice);
			return this;
		}
		
		public ProductCreateViewBuilder availability(Boolean availability) {
			prodView.setAvailability(availability);
			return this;
		}
		
		public ProductCreateView build() {
			return prodView;
		}
		
	}
	
}
