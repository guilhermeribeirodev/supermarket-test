package kata.supermarket;

import java.math.BigDecimal;

public class TwoByOneDiscount implements Discount{

    public static final BigDecimal TWO = new BigDecimal(2);

    @Override
    public BigDecimal apply(BigDecimal price) {
        return price.divide(TWO);
    }
}
