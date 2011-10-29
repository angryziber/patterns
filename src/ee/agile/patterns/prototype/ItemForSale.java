package ee.agile.patterns.prototype;

import java.math.BigDecimal;

public abstract class ItemForSale implements Cloneable {
    public abstract int getPrice();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    protected ItemForSale clone() {
        try {
            return (ItemForSale) super.clone();
        }
        catch (CloneNotSupportedException e) {
            // this can't happen
            return null;
        }
    }
}
