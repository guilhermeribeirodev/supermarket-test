package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public List<Item> twoOf() {
        List<Item> list = new ArrayList<>();
        list.add(new ItemByUnit(this));
        list.add(new ItemByUnit(this));
        return list;
    }
}
