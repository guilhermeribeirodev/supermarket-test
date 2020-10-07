package kata.supermarket;

import java.math.BigDecimal;

interface Discount {
    BigDecimal apply(BigDecimal price);
}
