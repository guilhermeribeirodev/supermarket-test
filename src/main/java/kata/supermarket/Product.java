package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Product {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public List<Item> multipleOf(int quantity) {
        List<Item> list = new ArrayList<>();
        IntStream.rangeClosed(1, quantity).forEach(item -> list.add(new ItemByUnit(this)));

        return list;
    }
}
