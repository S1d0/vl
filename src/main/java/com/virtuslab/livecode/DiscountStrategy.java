package com.virtuslab.livecode;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(AbstractBasket basket);
}
