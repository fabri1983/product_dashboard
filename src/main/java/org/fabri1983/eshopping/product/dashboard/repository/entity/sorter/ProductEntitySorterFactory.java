package org.fabri1983.eshopping.product.dashboard.repository.entity.sorter;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.fabri1983.eshopping.product.dashboard.repository.entity.ProductEntity;

public class ProductEntitySorterFactory implements EntitySorter<ProductEntity> {

	private Comparator<ProductEntity> comparatorChain;
	
	protected void chainComparator(Comparator<ProductEntity> comparator) {
		if (Objects.isNull(comparatorChain)) {
			comparatorChain = comparator;
		} else {
			// FIXME [Correctness] Avoid chain duplicated comparators
			comparatorChain = comparatorChain.thenComparing(comparator);
		}
	}
	
	@Override
	public List<ProductEntity> sort(Collection<ProductEntity> collection) {
		if (Objects.isNull(comparatorChain)) {
			// TODO [Improvement] Test for instance type: if List<> then cast and return
			return collection.stream()
					.collect( Collectors.toList() );
		}
		return collection.stream()
			.sorted( comparatorChain )
			.collect( Collectors.toList() );
	}
	
	public ProductEntitySorterFactory byId(SortingOrder order) {
		chainComparator(ProductViewSorterById.comparator(order));
		return this;
	}

	public ProductEntitySorterFactory byAvailability(SortingOrder order) {
		chainComparator(ProductViewSorterByAvailability.comparator(order));
		return this;
	}

	public ProductEntitySorterFactory byDiscountedPrice(SortingOrder order) {
		chainComparator(ProductViewSorterByDiscountedPrice.comparator(order));
		return this;
	}

	public ProductEntitySorterFactory byDiscountedPercentage(SortingOrder order) {
		chainComparator(ProductViewSorterByDiscountedPercentage.comparator(order));
		return this;
	}
	
	protected static Comparator<ProductEntity> selectComparator(SortingOrder order, 
			Comparator<ProductEntity> comparatorAsc, Comparator<ProductEntity> comparatorDesc) {
		if (SortingOrder.ASC.equals(order)) {
			return comparatorAsc;
		}
		else if (SortingOrder.DESC.equals(order)) {
			return comparatorDesc;
		}
		// no order? then default comparator is in ASC order
		return comparatorAsc;
	}

	public static ProductEntitySorterFactory newDummy() {
		return new ProductEntitySorterFactory();
	}
	
	public static ProductEntitySorterFactory newById(SortingOrder order) {
		return new ProductEntitySorterFactory().byId(order);
	}

	public static ProductEntitySorterFactory newByAvailability(SortingOrder order) {
		return new ProductEntitySorterFactory().byAvailability(order);
	}
	
	public static ProductEntitySorterFactory newByDiscountedPrice(SortingOrder order) {
		return new ProductEntitySorterFactory().byDiscountedPrice(order);
	}
	
	private static class ProductViewSorterById extends ProductEntitySorterFactory {
		
		private static final Comparator<ProductEntity> comparatorASC = 
				Comparator.comparing(ProductEntity::getId);
		private static final Comparator<ProductEntity> comparatorDESC = comparatorASC.reversed();
		
		public static Comparator<ProductEntity> comparator(SortingOrder order) {
			return selectComparator(order, comparatorASC, comparatorDESC);
		}
	}
	
	private static class ProductViewSorterByAvailability extends ProductEntitySorterFactory {
		
		private static final Comparator<ProductEntity> comparatorASC = 
				Comparator.comparing(ProductEntity::getAvailability);
		private static final Comparator<ProductEntity> comparatorDESC = comparatorASC.reversed();
		
		public static Comparator<ProductEntity> comparator(SortingOrder order) {
			return selectComparator(order, comparatorASC, comparatorDESC);
		}
	}
	
	private static class ProductViewSorterByDiscountedPrice extends ProductEntitySorterFactory {
		
		private static final Comparator<ProductEntity> comparatorASC = 
				Comparator.comparing(ProductEntity::getDiscountedPrice);
		private static final Comparator<ProductEntity> comparatorDESC = comparatorASC.reversed();
		
		public static Comparator<ProductEntity> comparator(SortingOrder order) {
			return selectComparator(order, comparatorASC, comparatorDESC);
		}
	}
	
	private static class ProductViewSorterByDiscountedPercentage extends ProductEntitySorterFactory {
		
		private static final Comparator<ProductEntity> comparatorASC = discounterPercentageCompartor();

		private static final Comparator<ProductEntity> comparatorDESC = comparatorASC.reversed();
		
		public static Comparator<ProductEntity> comparator(SortingOrder order) {
			return selectComparator(order, comparatorASC, comparatorDESC);
		}
		
		private static Comparator<ProductEntity> discounterPercentageCompartor() {
			return new Comparator<ProductEntity>() {
				
				@Override
				public int compare(ProductEntity p1, ProductEntity p2) {
					int discPrcntg1 = calculateDiscountedPercentage(p1);
					int discPrcntg2 = calculateDiscountedPercentage(p2);
					if (discPrcntg1 < discPrcntg2) {
						return -1;
					} else if (discPrcntg1 > discPrcntg2) {
						return 1;
					}
					return 0;
				}

				private int calculateDiscountedPercentage(ProductEntity p) {
					// Discount Percentage = ((Retail Price — Discounted Price) ⁄ Retail Price) * 100
					double percentage = ((p.getRetailPrice() - p.getDiscountedPrice()) / p.getRetailPrice()) * 100;
					return (int)Math.round(percentage);
				}
			};
		}
	}

}
