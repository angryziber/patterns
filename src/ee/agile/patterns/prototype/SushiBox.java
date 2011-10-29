package ee.agile.patterns.prototype;

public class SushiBox extends ItemForSale {
    private int price;

    public SushiBox(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
