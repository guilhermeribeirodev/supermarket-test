package kata.supermarket;

import java.math.BigDecimal;

public class TwoForOnePoundDiscount implements Discount{

    @Override
    public BigDecimal apply(BigDecimal price) {
        return new BigDecimal("1.00");
    }
}
