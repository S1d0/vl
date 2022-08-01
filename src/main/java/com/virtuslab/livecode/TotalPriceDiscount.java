package com.virtuslab.livecode;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;

public class TotalPriceDiscount implements DiscountStrategy {
    // This one would be set from applicaton properties, as a @Value element
    @Value("discount.price.limit")
    private double limit; 


    @Override
    public BigDecimal applyDiscount(AbstractBasket basket) {
        return basket.getTotalPrice();
    }
    
}
