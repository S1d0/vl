package com.virtuslab.livecode;

import java.math.BigDecimal;
import java.util.List;

import com.virtuslab.livecode.domain.Basket;
import com.virtuslab.livecode.domain.BasketPosition;
import com.virtuslab.livecode.domain.strategy.DiscountStrategy;

public class BasketFacade {
    private final DiscountStrategy discountStrategy;

    public BasketFacade(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public BigDecimal getBasketTotalPrice(List<BasketPosition> positions) {
        return discountStrategy.applyDiscount(new Basket(positions));
    }
}
