package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Price(null));
    }

    @Test
    public void constructor_invalidPrice_throwsIllegalArgumentException() {
        String invalidPrice = "";
        assertThrows(IllegalArgumentException.class, () -> new Price(invalidPrice));
    }

    @Test
    public void isValidPrice() {
        // null price
        assertThrows(NullPointerException.class, () -> Price.isValidPrice(null));

        // invalid price
        assertFalse(Price.isValidPrice("")); // empty string
        assertFalse(Price.isValidPrice(" ")); // spaces only
        assertFalse(Price.isValidPrice("$91.113")); // more than 2 decimal points
        assertFalse(Price.isValidPrice("$phone")); // non-numeric
        assertFalse(Price.isValidPrice("$9011p041")); // alphabets within digits
        assertFalse(Price.isValidPrice("12.12")); // no leading $
        assertFalse(Price.isValidPrice("$.12")); // no digit before decimal
        assertFalse(Price.isValidPrice("$-1.5")); // negative

        // valid price
        assertTrue(Price.isValidPrice("$911")); // no decimal
        assertTrue(Price.isValidPrice("$123.2")); // 1 decimal
        assertTrue(Price.isValidPrice("$123.12")); // 2 decimal
    }

}
