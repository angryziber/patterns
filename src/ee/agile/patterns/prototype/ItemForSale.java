package ee.agile.patterns.prototype;

import java.math.BigDecimal;

public abstract class ItemForSale {
    public abstract int getPrice();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
