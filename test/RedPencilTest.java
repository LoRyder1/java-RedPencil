import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RedPencilTest {

    private RedPencil promo;

    @Before
    public void setUp() {
        promo = new RedPencil();
    }

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
        assertEquals(true, promo.isPriceIncreased(50, 60));
    }

    @Test
    public void whenPriceIsNotIncreasedReturnsFalse() {
        assertEquals(false, promo.isPriceIncreased(50, 50));
    }
}
