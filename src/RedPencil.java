
public class RedPencil {

    public boolean isPromoValid(Product prod) {
        return isBetween5and30Percent(prod.price, prod.promoPrice) && isPriceStable(prod.stability) && isPromoLengthUnderMax(prod.length) && !isPriceIncreased(prod.newPrice, prod.promoPrice);
    }

    public boolean isBetween5and30Percent(double price, double promoPrice) {
        double priceDiff = (price - promoPrice);
        double percentDiff = (priceDiff / price) * 100;

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

    public boolean isPriceIncreased(double newPrice, double promoPrice) {
        return newPrice > promoPrice;
    }
}
