package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketWithDiscountTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValueWithDiscount(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket(Arrays.asList(new TwoByOneDiscount()));
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValueWithDiscount() {
        return Stream.of(

                twoByOneDiscountOnPricedPerUnit()
        );
    }


    private static Arguments twoByOneDiscountOnPricedPerUnit() {
        return Arguments.of("two by one discount on priced per unit", "1.55",
                Arrays.asList(aPackOfDigestives(), aPackOfDigestives()));
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).oneOf();
    }

}
