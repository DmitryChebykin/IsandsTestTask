package com.example.isandstesttask.filter.phone;

import com.example.isandstesttask.entity.product.PhoneImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import com.example.isandstesttask.filter.metamodel.BaseProductImpl_;
import com.example.isandstesttask.filter.metamodel.PhoneImpl_;
import com.example.isandstesttask.filter.phone.PhoneSearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

public final class PhoneSpecification {
    private PhoneSpecification() {
    }

    public static Specification<PhoneImpl> createPhoneSpecification(PhoneSearchCriteria phoneSearchCriteria) {
        Specification<PhoneImpl> colorSpec = colorIs(phoneSearchCriteria.getColorName());
        Specification<PhoneImpl> brandSpec = brandIs(phoneSearchCriteria.getBrandName());
        Specification<PhoneImpl> sizeSpec = sizeIs(phoneSearchCriteria.getSize());
        Specification<PhoneImpl> modelNameSpec = modelIs(phoneSearchCriteria.getModelName());
        Specification<PhoneImpl> countrySpec = countryIs(phoneSearchCriteria.getProducingCountry());
        Specification<PhoneImpl> serialSpec = serialIs(phoneSearchCriteria.getSerialNumber());
        Specification<PhoneImpl> minPriceSpec = hasPriceAbove(phoneSearchCriteria.getMinPrice());
        Specification<PhoneImpl> maxPriceSpec = hasPriceUnder(phoneSearchCriteria.getMaxPrice());
        Specification<PhoneImpl> availSpec = availableIs(phoneSearchCriteria.getIsAvailable());
        Specification<PhoneImpl> onlineOrderingSpec = onlineOrderingIs(phoneSearchCriteria.getIsOnlineOrdering());
        Specification<PhoneImpl> soldInstalmentsSpec = soldInstalmentsIs(phoneSearchCriteria.getIsSoldByInstallments());
        Specification<PhoneImpl> memorySizeSpec = memorySizeIs(phoneSearchCriteria.getMemorySize());
        Specification<PhoneImpl> cameraNumbersSpec = camerasNumberIs(phoneSearchCriteria.getCamerasNumber());

        return colorSpec
                .and(brandSpec)
                .and(availSpec)
                .and(onlineOrderingSpec)
                .and(soldInstalmentsSpec)
                .and(countrySpec)
                .and(modelNameSpec)
                .and(serialSpec)
                .and(sizeSpec)
                .and(minPriceSpec)
                .and(maxPriceSpec)
                .and(memorySizeSpec)
                .and(cameraNumbersSpec);
    }

    private static Specification<PhoneImpl> availableIs(Optional<Boolean> isAvailable) {
        return (root, query, builder) -> isAvailable.map(e -> builder.equal(root.get(BaseProductImpl_.AVAILABLE), e)).orElse(null);
    }

    private static Specification<PhoneImpl> onlineOrderingIs(Optional<Boolean> isOnlineOrdering) {
        return (root, query, builder) -> isOnlineOrdering.map(e -> builder.equal(root.get(BaseProductImpl_.IS_ONLINE_ORDERING), e)).orElse(null);
    }

    private static Specification<PhoneImpl> soldInstalmentsIs(Optional<Boolean> isSoldByInstallments) {
        return (root, query, builder) -> isSoldByInstallments.map(e -> builder.equal(root.get(BaseProductImpl_.IS_SOLD_BY_INSTALLMENTS), e)).orElse(null);
    }

    private static Specification<PhoneImpl> sizeIs(Optional<String> size) {
        return (root, query, builder) -> size.map(newSize -> builder.equal(root.get(BaseProductImpl_.SIZE), newSize)).orElse(null);
    }

    public static Specification<PhoneImpl> hasPriceAbove(Optional<BigDecimal> minPrice) {
        return (root, query, builder) -> minPrice.map(min ->
                builder.greaterThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    public static Specification<PhoneImpl> hasPriceUnder(Optional<BigDecimal> maxPrice) {
        return (root, query, builder) -> maxPrice.map(min ->
                builder.lessThanOrEqualTo(root.get(BaseProductImpl_.PRICE), min)).orElse(null);
    }

    private static Specification<PhoneImpl> modelIs(Optional<String> modelName) {
        return (root, query, builder) -> modelName.map(newModel -> builder.equal(
                builder.lower(root.get(BaseProductImpl_.MODEL_NAME)), newModel.toLowerCase())).orElse(null);
    }

    private static Specification<PhoneImpl> serialIs(Optional<String> serial) {
        return (root, query, builder) -> serial.map(newSerial -> builder.equal(root.get(BaseProductImpl_.SERIAL_NUMBER), newSerial)).orElse(null);
    }

    private static Specification<PhoneImpl> countryIs(Optional<String> producingCountry) {
        return (root, query, builder) -> producingCountry.map(new Function<String, Predicate>() {
            @Override
            public Predicate apply(String country) {
                return builder.equal(root.get(BaseProductImpl_.PRODUCING_COUNTRY), country);
            }
        }).orElse(null);
    }

    private static Specification<PhoneImpl> brandIs(Optional<Brand> brandName) {
        return new Specification<PhoneImpl>() {
            @Override
            public Predicate toPredicate(Root<PhoneImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return brandName.map(new Function<Brand, Predicate>() {
                    @Override
                    public Predicate apply(Brand newBrand) {
                        return builder.equal(root.get(BaseProductImpl_.BRAND_NAME), newBrand);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<PhoneImpl> colorIs(Optional<Color> colorName) {
        return new Specification<PhoneImpl>() {
            @Override
            public Predicate toPredicate(Root<PhoneImpl> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return colorName.map(new Function<Color, Predicate>() {
                    @Override
                    public Predicate apply(Color newColor) {
                        return builder.equal(root.get(BaseProductImpl_.COLOR_NAME), newColor);
                    }
                }).orElse(null);
            }
        };
    }

    private static Specification<PhoneImpl> camerasNumberIs(Optional<Integer> camerasNumber) {
        return (root, query, builder) -> camerasNumber.map(newTech -> builder.equal(root.get(PhoneImpl_.CAMERAS_NUMBER), newTech)).orElse(null);
    }

    private static Specification<PhoneImpl> memorySizeIs(Optional<Integer> memorySize) {
        return (root, query, builder) -> memorySize.map(newCategory -> builder.equal(root.get(PhoneImpl_.MEMORY_SIZE), newCategory)).orElse(null);
    }
}