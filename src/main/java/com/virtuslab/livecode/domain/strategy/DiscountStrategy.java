package com.virtuslab.livecode.domain.strategy;

import java.math.BigDecimal;

import com.virtuslab.livecode.domain.Basket;

public enum DiscountStrategy {
    TOAL_PRICE {
        @Override
        public BigDecimal applyDiscount(Basket basket) {
            BigDecimal discount = BigDecimal.valueOf(0.1);
            BigDecimal discountPriceLimit = BigDecimal.valueOf(50.0);
            return switch (basket.getBasketPrice().compareTo(discountPriceLimit)) {
                case 1 -> basket.getBasketPrice().multiply(discount);
                default -> basket.getBasketPrice();
            };
        }
    },

    NONE {
        @Override
        public BigDecimal applyDiscount(Basket basket) {
            return basket.getBasketPrice();
        }
    };

    public abstract BigDecimal applyDiscount(Basket basket);

}