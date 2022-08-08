package com.virtuslab.livecode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.virtuslab.livecode.domain.BasketPosition;
import com.virtuslab.livecode.domain.Product;
import com.virtuslab.livecode.domain.strategy.DiscountStrategy;

class BasketTest {
    private BasketFacade facade;
    private List<BasketPosition> positions;
    private Product bread;
    private Product butter;
    private Product milk;
    private Product chocolate;
    

    @BeforeEach
    void setupBeforeEach() {
        this.bread = new Product("bread", 1.99);
        this.butter = new Product("butter", 3.2);
        this.milk = new Product("milk", 2.4);
        this.chocolate = new Product("chocolate", 5.15);
        
        positions = getBasePositions();
    }

    private List<BasketPosition> getBasePositions() {
        return List.of(
                new BasketPosition(bread, 1),
                new BasketPosition(butter, 1),
                new BasketPosition(milk, 1),
                new BasketPosition(chocolate, 1));
    }

    @Test
    void should_return_total_price_of_basket() {
        // given 4 product position
        // bread [1.99], butter [3.2], milk [2.4], chocolate [5.15]
        BigDecimal expectedBasketPrice = BigDecimal.valueOf(12.74);
        facade = new BasketFacade(DiscountStrategy.NONE);

        // then total price of basket is calculated
        BigDecimal actualPrice = facade.getBasketTotalPrice(positions);
        assertEquals(expectedBasketPrice.doubleValue(), actualPrice.doubleValue());
    }

    @Test
    void should_apply_total_price_discount() {
        // given basket with total price above 50 
        List<BasketPosition> positions = List.of(BasketPostionProvider.getBasketPosition(chocolate, 10));
        facade = new BasketFacade(DiscountStrategy.TOAL_PRICE);
        BigDecimal expectedPrice = BigDecimal.valueOf(5.15)
            .multiply(BigDecimal.valueOf(10))
            // Apply Discount
            .multiply(BigDecimal.valueOf(0.1));

        // then discount should be applied
        BigDecimal actualPrice = facade.getBasketTotalPrice(positions);

        assertEquals(0, expectedPrice.compareTo(actualPrice));
    }

    @Test
    void should_not_apply_total_price_discount() {
        // given basket with total price above 50 
        facade = new BasketFacade(DiscountStrategy.TOAL_PRICE);
        BigDecimal expectedBasketPrice = BigDecimal.valueOf(12.74);


        // then discount should be applied
        BigDecimal actualPrice = facade.getBasketTotalPrice(positions);

        assertEquals(0, expectedBasketPrice.compareTo(actualPrice));
    }
}

class BasketPostionProvider{ 

    static BasketPosition getBasketPosition(Product product ,int quantity) { 
        return new BasketPosition(product, quantity);
    }
}