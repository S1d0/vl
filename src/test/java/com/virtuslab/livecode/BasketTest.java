package com.virtuslab.livecode;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @Test
    void getTotalPrice() {
        // given
        List<ProductPosition> productPositions = new ArrayList<>();
        productPositions.add(new ProductPosition(new Product("bread", BigDecimal.valueOf(1.99)), 1));
        productPositions.add(new ProductPosition(new Product("butter", BigDecimal.valueOf(1.99)), 1));
        productPositions.add(new ProductPosition(new Product("milk", BigDecimal.valueOf(1.99)), 1));
        productPositions.add(new ProductPosition(new Product("chocolate", BigDecimal.valueOf(1.99)), 1));
        Basket basket = new Basket(productPositions);

        BigDecimal expectedTotalPrice = BigDecimal.valueOf(7.96);

        //when
        BigDecimal totalPrice = basket.getTotalPrice();

        // then
        assertEquals(0, expectedTotalPrice.compareTo(totalPrice));
    }
}