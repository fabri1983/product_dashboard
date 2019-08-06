package org.fabri1983.eshopping.product.dashboard.api.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.fabri1983.eshopping.product.dashboard.api.exception.ApiUnsupportedEncodingException;
import org.fabri1983.eshopping.product.dashboard.service.contract.ProductServiceContract;
import org.fabri1983.eshopping.product.dashboard.view.ProductCreateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductFilterParametersView;
import org.fabri1983.eshopping.product.dashboard.view.ProductUpdateView;
import org.fabri1983.eshopping.product.dashboard.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
		value = "/products",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductsController extends BaseController {

	@Autowired
	private ProductServiceContract productService;
	
	@RequestMapping(
			value = "", 
			method = RequestMethod.GET)
	@PreAuthorize(AUTH_ADMIN_OR_STANDARD)
	public ResponseEntity<List<ProductView>> findAll(
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "availability", required = false) Boolean availability) {
		
		// NOTE: for some unknown reason @RequestParam is not being decoded
		String categoryDecoded = decode(category);
		
		ProductFilterParametersView filterParameters = ProductFilterParametersView.from(categoryDecoded, availability);
		List<ProductView> allProductViews = productService.findAll(filterParameters);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(allProductViews);
	}

	@RequestMapping(
			value = "/{product_id}", 
			method = RequestMethod.GET)
	@PreAuthorize(AUTH_ADMIN_OR_STANDARD)
	public ResponseEntity<ProductView> findById(
			@PathVariable("product_id") @NotNull Long productId) {
		
		ProductView productView = productService.findById(productId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(productView);
	}
	
	@RequestMapping(
			value = "",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize(AUTH_ADMIN)
	public ResponseEntity<ProductView> add(
			@RequestBody @NotNull ProductCreateView productCreateView) {
		
		ProductView productNewView = productService.add(productCreateView);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(productNewView);
	}
	
	@RequestMapping(
			value = "/{product_id}", 
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize(AUTH_ADMIN)
	public ResponseEntity<ProductView> update(
			@PathVariable("product_id") @NotNull Long productId, 
			@RequestBody @NotNull ProductUpdateView productUpdateView) {
		
		productUpdateView.setId(productId);
		ProductView productUpdatedView = productService.update(productUpdateView);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(productUpdatedView);
	}
	
	@RequestMapping(
			value = "/{product_id}",
			method = RequestMethod.DELETE)
	@PreAuthorize(AUTH_ADMIN)
	public ResponseEntity<?> delete(
			@PathVariable("product_id") @NotNull Long productId) {
		
		ProductView productView = ProductView.from(productId);
		productService.delete(productView);
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}

	private String decode(String s) {
		try {
			if (Objects.isNull(s)) {
				return null;
			}
			return URLDecoder.decode(s, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException ex) {
			throw new ApiUnsupportedEncodingException(ex);
		}
	}
	
}
