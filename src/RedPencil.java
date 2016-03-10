
public class RedPencil {

    private float price;
    private float promoPrice;
    private int stability;
    private int length;

    public RedPencil() {
    }

    public RedPencil(float price, float promoPrice, int stability, int length) {
        this.price = price;
        this.promoPrice = promoPrice;
        this.stability = stability;
        this.length = length;
    }

    public boolean isBetween5and30Percent(float price, float promoPrice) {
        float priceDiff = (price - promoPrice);
        float percentDiff = (priceDiff / price) *100;

        if (percentDiff >= 5 && percentDiff <= 30) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPriceStable(int stability) {
        return stability >= 30;
    }

    public boolean isPromoLengthUnderMax(int days) {
        return days <= 30;
    }


    public boolean isPriceIncreased(int price, int newPrice) {
        return newPrice > price;
    }
}
