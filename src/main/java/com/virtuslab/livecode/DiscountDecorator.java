package com.virtuslab.livecode;

import java.math.BigDecimal;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscountDecorator extends AbstractBasket{
    private final AbstractBasket basket;
    private final DiscountStrategy discount; 

    @Override
    public BigDecimal getTotalPrice() {
        return isDiscountApplicable() 
        ? applyDiscount() 
        : basket.getTotalPrice();
    }

    private boolean isDiscountApplicable() {
        return basket.getTotalPrice().compareTo(BigDecimal.valueOf(50)) == 1;
    }

    private BigDecimal applyDiscount() {
        return basket.getTotalPrice().multiply(BigDecimal.valueOf(0.10));
    }


}
