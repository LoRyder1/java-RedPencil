
public class RedPencil {

    private float price;
    private float promoPrice;
    private int stability;

    public RedPencil(float price, float promoPrice, int stability) {
        this.price = price;
        this.promoPrice = promoPrice;
        this.stability = stability;
    }

    public boolean valid() {
        float priceDiff = price - promoPrice;
        float percentDiff = ((priceDiff / price) * 100);
        if (percentDiff < 30 && percentDiff > 5 && stability >= 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean stable(int days) {
        if (days >= 30) {
            return true;
        } else {
            return false;
        }
    }
}
