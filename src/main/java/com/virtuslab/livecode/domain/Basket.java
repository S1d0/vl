package com.virtuslab.livecode.domain;

import java.math.BigDecimal;
import java.util.List;

public class Basket {
    private final List<BasketPosition> positions;

    public Basket(List<BasketPosition> positions) {
        this.positions = positions;
    }

    public BigDecimal getBasketPrice() {
        return positions.stream()
                .map(BasketPosition::getPositionPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
