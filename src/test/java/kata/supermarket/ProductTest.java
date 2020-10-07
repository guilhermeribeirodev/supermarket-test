package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product(price).oneOf().price());
    }

    @Test
    void doubleItemsHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price.multiply(new BigDecimal("2")) , new Product(price).twoOf().stream().map(Item::price).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }
}