package com.virtuslab.livecode.domain;

import java.math.BigDecimal;

public record BasketPosition(Product product, int quantity) {

    public BigDecimal getPositionPrice() {
        return BigDecimal.valueOf(product.price())
                .multiply(BigDecimal.valueOf(quantity));
    }
}