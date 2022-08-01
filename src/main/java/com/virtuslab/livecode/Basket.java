package com.virtuslab.livecode;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Basket {
    private DiscountService discountService;
    private final List<ProductPosition> products;
    private final Price price; 

    public BigDecimal getPrice() {
        
        BigDecimal totalPrice = products.stream()
                .map(ProductPosition::getPositionPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return discountService.checkDiscount(totalPrice);

    }
}
