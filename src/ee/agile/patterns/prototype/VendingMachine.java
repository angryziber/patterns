package ee.agile.patterns.prototype;

public class VendingMachine {
    private ItemForSale item;
    private int count;

    public VendingMachine(ItemForSale item, int count) {
        this.item = item;
        this.count = count;
    }

    public int itemsLeft() {
        return count;
    }

    public ItemForSale dispense() {
        if (count == 0) throw new IllegalStateException("No more " + item + "s  left");
        count--;
        return item.clone();
    }
}
