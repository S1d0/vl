package com.virtuslab.livecode;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class Product {
    private final String name;
    private final BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }
}
