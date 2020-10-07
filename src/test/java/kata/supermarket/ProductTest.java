package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product(price).oneOf().price());
    }

    @Test
    void multipleItemsHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        final int itemsQuantity = 2;
        assertEquals(price.multiply(new BigDecimal(itemsQuantity)) ,
                new Product(price).multipleOf(itemsQuantity).stream().map(Item::price).reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }
}