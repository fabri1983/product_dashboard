package org.fabri1983.eshopping.product.dashboard.util;

import org.fabri1983.eshopping.product.dashboard.view.ProductCreateView;

public class ProductsOnPhaseUpdate {

	public static ProductCreateView product1() {
		return ProductCreateView.builder()
    			.id(8L)
        		.version(1L)
    			.name("Kaftan")
    			.category("Accessories")
    			.retailPrice(237.0)
    			.discountedPrice(215.67)
    			.availability(true)
    			.build();
	}
	
	public static ProductCreateView product6() {
		return ProductCreateView.builder()
				.id(6L)
	    		.version(2L)
				.name("Shawl")
				.category("Accessories")
				.retailPrice(325.45)
				.discountedPrice(260.36)
				.availability(true)
				.build();
	}

	public static ProductCreateView product7() {
		return ProductCreateView.builder()
				.id(7L)
	    		.version(1L)
				.name("Belt")
				.category("Accessories")
				.retailPrice(471.0)
				.discountedPrice(419.19)
				.availability(true)
				.build();
	}

	public static ProductCreateView product10() {
		return ProductCreateView.builder()
    			.id(10L)
        		.version(2L)
    			.name("Cufflinks")
    			.category("Accessories")
    			.retailPrice(284.0)
    			.discountedPrice(227.2)
    			.availability(true)
    			.build();
	}
	
	public static ProductCreateView product12() {
		return ProductCreateView.builder()
    			.id(12L)
        		.version(2L)
    			.name("Poncho")
    			.category("Accessories")
    			.retailPrice(350.0)
    			.discountedPrice(283.5)
    			.availability(true)
    			.build();
	}
	
	public static ProductCreateView product13() {
		return ProductCreateView.builder()
    			.id(13L)
        		.version(2L)
    			.name("Cummerbund")
    			.category("Accessories")
    			.retailPrice(500.0)
    			.discountedPrice(450.0)
    			.availability(false)
    			.build();
	}
	
	public static ProductCreateView product16() {
		return ProductCreateView.builder()
    			.id(16L)
        		.version(1L)
    			.name("Tracksuit")
    			.category("Full Body Outfits")
    			.retailPrice(471.0)
    			.discountedPrice(423.9)
    			.availability(false)
    			.build();
	}
	
	public static ProductCreateView product19() {
		return ProductCreateView.builder()
    			.id(19L)
        		.version(2L)
    			.name("Suit")
    			.category("Full Body Outfits")
    			.retailPrice(125.0)
    			.discountedPrice(100.0)
    			.availability(false)
    			.build();
	}
	
	public static ProductCreateView product20() {
        return ProductCreateView.builder()
    			.id(20L)
        		.version(2L)
    			.name("Catsuit")
    			.category("Full Body Outfits")
    			.retailPrice(158.0)
    			.discountedPrice(200.0)
    			.availability(false)
    			.build();
	}
	
	public static ProductCreateView product21() {
		return ProductCreateView.builder()
    			.id(21L)
        		.version(1L)
    			.name("Dungarees")
    			.category("Full Body Outfits")
    			.retailPrice(437.0)
    			.discountedPrice(362.71)
    			.availability(false)
    			.build();
	}
	
}
