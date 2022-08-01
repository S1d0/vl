package com.virtuslab.livecode;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class DiscountService {
    private final boolean applyDiscount;
    private final double discount = 0.1;
    private final BigDecimal priceLimit;


    public BigDecimal checkDiscount(BigDecimal totalPrice) {
//        if(!applyDiscount) { eturn
//        if(applyDiscount ) {
//            if (priceLimit.compareTo(totalPrice) == 1) {
//                return totalPrice.multiply(BigDecimal.valueOf(discount));
//            }
//        }
        return null;
    }
}
