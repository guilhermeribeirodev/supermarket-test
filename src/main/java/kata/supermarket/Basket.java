package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Basket {
    private final List<Item> items;

    private final List<Discount> discounts;

    public Basket() {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public Basket(List<Discount> discounts) {
        this.items = new ArrayList<>();
        this.discounts = discounts;
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator().calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;

        TotalCalculator() {
            this.items = items();
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        /**
         * TODO: This could be a good place to apply the results of
         *  the discount calculations.
         *  It is not likely to be the best place to do those calculations.
         *  Think about how Basket could interact with something
         *  which provides that functionality.
         */
        private BigDecimal discounts() {
            float total = 0.0f;
            for(Item item : items){
                total += discounts.stream()
                        .filter(Objects::nonNull)
                        .map(discount -> discount.apply(item.price()))
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO)
                        .floatValue();
            }
            return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
