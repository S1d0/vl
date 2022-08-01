package com.virtuslab.livecode;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class ProductPosition {
    private final Product product;
    private final int quantity;

    public BigDecimal getPositionPrice() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
