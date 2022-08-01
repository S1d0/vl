package com.virtuslab.livecode;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class Basket {
    private DiscountService discountService;
    private final List<ProductPosition> products;

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = products.stream()
                .map(ProductPosition::getPositionPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

       return discountService.checkDiscount(totalPrice);

    }
}
