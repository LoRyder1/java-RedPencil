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
        assertEquals(true, promo.between5and30Percent(100, 90));
    }

    @Test
    public void promoIsInvalidIfNotBetween5And30Percent() {
        assertEquals(false, promo.between5and30Percent(100, 96));
    }

    @Test
    public void previousPriceMustBeStableForAtLeast30Days() {
        assertEquals(false, promo.priceStable(24));
    }

    @Test
    public void promoLengthMax30days() {
        assertEquals(false, promo.promoLengthUnderMax(32));
    }
}
