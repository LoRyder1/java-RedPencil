import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RedPencilTest {

    private RedPencil promo = new RedPencil();
    private Product prod;

    @Test
    public void promoPriceBetween5and30Percent() {
        assertEquals(true, promo.isBetween5and30Percent(100, 90));
    }

    @Test
    public void promoIsInvalidIfNotBetween5And30Percent() {
        assertEquals(false, promo.isBetween5and30Percent(100, 96));
    }

    @Test
    public void priceStablityLessThan30ReturnsFalse() {
        assertEquals(false, promo.isPriceStable(24));
    }

    @Test
    public void priceStabilityGreaterThan30ReturnsTrue() {
        assertEquals(true, promo.isPriceStable(31));
    }

    @Test
    public void invalidPromoLengthReturnsFalse() {
        assertEquals(false, promo.isPromoLengthUnderMax(32));
    }

    @Test
    public void validPromoLengthUnder30ReturnsTrue() {
        assertEquals(true, promo.isPromoLengthUnderMax(24));
    }

    @Test
    public void whenPriceIsIncreasedReturnsTrue() {
        assertEquals(true, promo.isPriceIncreased(60, 50));
    }

    @Test
    public void whenPriceIsNotIncreasedReturnsFalse() {
        assertEquals(false, promo.isPriceIncreased(50, 50));
    }

    public void createProd(double price, double promoPrice, int stability, int length) {
        prod = new Product(price, promoPrice, stability, length);
    }

    @Test
    public void invalidPromo() {
        createProd(100, 90, 30, 31);
        assertEquals(false, promo.isPromoValid(prod));
    }

    @Test
    public void validPromo() {
        createProd(100, 75, 30, 30);
        assertEquals(true, promo.isPromoValid(prod));
    }

    @Test
    public void increasingPriceInvalidatesPromo() {
        createProd(100, 75, 30, 30);
        prod.increasePrice(10);
        assertEquals(false, promo.isPromoValid(prod));
    }

    @Test
    public void reducingPricePastMaxInvalidatesPromo() {
        createProd(100, 75, 30, 30);
        prod.reducePrice(10);
        assertEquals(false, promo.isPromoValid(prod));
    }

    @Test
    public void reducingPriceNotPastMaxReturnsTruePromo() {
        createProd(100, 75, 30, 30);
        prod.reducePrice(5);
        assertEquals(true, promo.isPromoValid(prod));
    }
}
