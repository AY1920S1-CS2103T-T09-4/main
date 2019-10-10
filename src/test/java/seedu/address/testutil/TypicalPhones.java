package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import seedu.address.model.PhoneBook;
import seedu.address.model.phone.Capacity;
import seedu.address.model.phone.Phone;

/**
 * A utility class containing a list of {@code Phone} objects to be used in tests.
 */
public class TypicalPhones {

    public static final Phone IPHONEONE = new PhoneBuilder().withName("iPhone 11").withBrand("iPhone")
            .withCapacity(Capacity.SIZE_32GB).withColour("White").withCost("$500").withTags("Old").build();

    public static final Phone IPHONETWO = new PhoneBuilder().withName("iPhone X").withBrand("iPhone")
            .withCapacity(Capacity.SIZE_64GB).withColour("Green").withCost("$300").withTags("Spoilt").build();

    public static final Phone ANDROIDONE = new PhoneBuilder().withName("Samsung Galaxy 9").withBrand("Samsung")
            .withCapacity(Capacity.SIZE_32GB).withColour("Black").withCost("$300").withTags("New").build();

    public static final Phone ANDROIDTWO = new PhoneBuilder().withName("Samsung Galaxy 10").withBrand("Samsung")
            .withCapacity(Capacity.SIZE_1024GB).withColour("Pink").withCost("$730").withTags("Fresh").build();

    public static final Phone IPHONEXR = new PhoneBuilder().withName("iPhone XR").withBrand("Apple")
            .withCapacity(Capacity.SIZE_128GB).withColour("Black").withCost("$1000").withTags("Used").build();

    /**
     * Returns an {@code Book} with all the typical phones.
     */
    public static PhoneBook getTypicalPhoneBook() {
        PhoneBook pb = new PhoneBook();
        for (Phone p: getTypicalPhones()) {
            pb.addPhone(p);
        }
        return pb;
    }

    public static List<Phone> getTypicalPhones() {
        return new ArrayList<>(Arrays.asList(IPHONEONE, IPHONETWO, IPHONEXR, ANDROIDONE, ANDROIDTWO));
    }
}
