import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RedPencilTest {

    @Test
    public void promoPriceBetween5and30Percent() {
        RedPencil promo = new RedPencil(100, 90);
        assertEquals(true, promo.valid());
    }

    @Test
    public void promoIsInvalidIfNotBetween5And30Percent() {
        RedPencil promo = new RedPencil(100, 96);
        assertEquals(false, promo.valid());
    }
}
