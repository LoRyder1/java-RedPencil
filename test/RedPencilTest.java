import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RedPencilTest {

    private RedPencil promo;

    public void setPromo(int price, int promoPrice, int stability) {
        promo = new RedPencil(price, promoPrice, stability);
    }

    @Test
    public void promoPriceBetween5and30Percent() {
        setPromo(100, 90, 30);
        assertEquals(true, promo.valid());
    }

    @Test
    public void promoIsInvalidIfNotBetween5And30Percent() {
        setPromo(100, 96, 30);
        assertEquals(false, promo.valid());
    }

    @Test
    public void previousPriceMustBeStableForAtLeast30Days() {
        setPromo(100, 90, 29);
        assertEquals(false, promo.valid());
    }
}
