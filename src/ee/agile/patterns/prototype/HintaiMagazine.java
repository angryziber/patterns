package ee.agile.patterns.prototype;

public class HintaiMagazine extends ItemForSale {
    private int price = 700;

    public HintaiMagazine() {
    }

    public HintaiMagazine(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
