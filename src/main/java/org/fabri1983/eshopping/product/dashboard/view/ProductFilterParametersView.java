package org.fabri1983.eshopping.product.dashboard.view;

public class ProductFilterParametersView {

	private String category;
	private Boolean availability;
	
	public static ProductFilterParametersView from(String category, Boolean availability) {
		ProductFilterParametersView newObj = new ProductFilterParametersView();
		newObj.category = category;
		newObj.availability = availability;
		return newObj;
	}

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

}
