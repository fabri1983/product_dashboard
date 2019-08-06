package org.fabri1983.eshopping.product.dashboard.repository.functional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IFunctional {
	
	default <T> List<T> notNull(List<T> root) {
		return root == null? new ArrayList<T>(1) : root;
	}
	
	default <T> Set<T> notNull(Set<T> root) {
		return root == null? new HashSet<T>(1) : root;
	}
	
	default <T> void addIfNotExist(List<T> list, T elem) {
		if (!list.contains(elem)) {
			list.add(elem);
		}
	}

	default <T> void addIfNotNull(List<T> list, T elem) {
		if (elem != null) {
			list.add(elem);
		}
	}
	
	default <T> void process(Consumer<T> doBefore, Consumer<T> process, T data, Consumer<T> doAfter) {
		doBefore.accept(data);
		process.accept(data);
		doAfter.accept(data);
	}

	@FunctionalInterface
	interface Action {
		public void invoke();
	};

	@FunctionalInterface
	interface ActionParam<One> {
		public void invoke(One element);
	};	
	
	@FunctionalInterface
	interface BiConsumer<One, Two> {
		public void accept(One firstElement, Two secondElement);
	}
	
	default boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	default boolean isNullOrEmpty(List<?> value) {
		return value == null || value.isEmpty();
	}
	
	default boolean isNullOrEmpty(Collection<?> value) {
		return value == null || value.isEmpty();
	}
	
	default boolean isNullOrEmpty(Map<?,?> value) {
		return value == null || value.isEmpty();
	}
	
	default <T> T isNull(T value, T def) {
		if (value == null){
			return def;
		}
		return value;
	}
	
    default <T, X extends Throwable> T tryCatch(Supplier<T> process, Supplier<? extends X> throwOnError) throws X {
        try {
            return process.get();
        } catch (Exception e) {
            throw throwOnError.get();
        }
    }

	default <X extends Throwable> void tryCatch(Runnable process, Supplier<? extends X> throwOnError) throws X {
		try {
			process.run();
		} catch (Exception e) {
			throw throwOnError.get();
		}
	}
	
	default <T> T tryCatchThrowAsRuntimeException(Callable<T> process) throws RuntimeException {
		try {
			return process.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	default <X extends Throwable, S extends Exception> void tryCatchIfMatchException(Runnable process, 
			Supplier<? extends X> throwOnError, Class<S> matchingException) throws X {
		try {
			process.run();
		} catch (Exception e) {
			if (matchingException.isInstance(e)) {
				throw throwOnError.get();
			} else {
				throw e;
			}
		}
	}
	
	default <T> List<T> union(List<T> a, List<T> b) {
		a.addAll(b);	
		return a;
	}
	
	default <T> List<T> except(List<T> a, List<T> except) {
		List<T> list = new ArrayList<T>(a);
		list.removeAll(except);
		return list;
	}
	
	default <T> List<T> newList() {
		return new ArrayList<T>();
	}
	
	default LocalDateTime now() {
		return ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
	}
	
	default LocalDateTime nowTZ(String timeZone) {
	    ZoneId zoneId = ZoneId.of(timeZone);
	    return ZonedDateTime.now(zoneId).toLocalDateTime();
    }
	
	default long nowMillis() {
		return now().toInstant(ZoneOffset.UTC).toEpochMilli();
	}
	
	default int nowSeconds() {
		return (int) (nowMillis() / 1000);
	}

}
