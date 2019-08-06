package org.fabri1983.eshopping.product.dashboard.repository.dao;

import java.util.List;

import org.fabri1983.eshopping.product.dashboard.repository.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity, Long> {

	/**
	 * Return all entities sort by id in the ascending order.
	 * 
	 * @return
	 */
	List<ProductEntity> findByOrderByIdAsc();
	
	/**
	 * Sort rules:
	 * Stock products (availability=true) must be listed before out of stock products (availability=false).
	 * Products with same availability status must be sorted by the discounted price in the ascending order.
	 * Products with same discounted price must be sorted by the ID in the ascending order.
	 * 
	 * @param category
	 * @param sort
	 * @return
	 */
    List<ProductEntity> findByCategory(String category, Sort sort);
	
    /**
	 * Sort rules:
	 * Stock products (availability=true) must be listed before out of stock products (availability=false).
	 * Products with same availability status must be sorted by the discounted price in the ascending order.
	 * Products with same discounted price must be sorted by the ID in the ascending order.
	 * 
	 * @param category
	 * @return
	 */
    List<ProductEntity> findByCategoryOrderByAvailabilityDescDiscountedPriceAscIdAsc(String category);
    
    /**
     * Sort rules:
     * Product sorted by the discount percentage (calculated value) in the descending order.
     * Products with same discount percentage status must be sorted by the discounted price in the ascending order.
     * Products with same discounted price must be sorted by the ID in the ascending order.
     * 
     * @param category
     * @param availability
     * @param sort
     * @return
     */
    List<ProductEntity> findByCategoryAndAvailability(String category, Boolean availability, Sort sort);
    
    /**
     * Sort rules:
     * Product sorted by the discount percentage (calculated value) in the descending order.
     * Products with same discount percentage status must be sorted by the discounted price in the ascending order.
     * Products with same discounted price must be sorted by the ID in the ascending order.
     * 
     * @param category
     * @param availability
     * @param sort
     * @return
     */
    List<ProductEntity> findByCategoryAndAvailabilityOrderByDiscountedPercentageDescDiscountedPriceAscIdAsc(
    		String category, Boolean availability);
	
}
