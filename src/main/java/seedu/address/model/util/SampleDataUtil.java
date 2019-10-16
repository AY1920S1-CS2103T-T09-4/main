package seedu.address.model.util;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import seedu.address.model.CustomerBook;
import seedu.address.model.OrderBook;
import seedu.address.model.PhoneBook;
import seedu.address.model.ReadOnlyDataBook;
import seedu.address.model.customer.ContactNumber;
import seedu.address.model.customer.Customer;
import seedu.address.model.customer.CustomerName;
import seedu.address.model.customer.Email;
import seedu.address.model.order.Order;
import seedu.address.model.order.Price;
import seedu.address.model.order.Status;
import seedu.address.model.phone.Brand;
import seedu.address.model.phone.Capacity;
import seedu.address.model.phone.Colour;
import seedu.address.model.phone.Cost;
import seedu.address.model.phone.IdentityNumber;
import seedu.address.model.phone.Phone;
import seedu.address.model.phone.PhoneName;
import seedu.address.model.phone.SerialNumber;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    /*public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }*/

    public static Customer[] getSampleCustomers() {
        return new Customer[] {
            new Customer(new CustomerName("Alex Yeoh"), new ContactNumber("87438807"),
                  new Email("alexyeoh@example.com"), getTagSet("friends")),
            new Customer(new CustomerName("Bernice Yu"), new ContactNumber("99272758"),
                  new Email("berniceyu@example.com"), getTagSet("colleagues", "friends")),
            new Customer(new CustomerName("Charlotte Oliveiro"), new ContactNumber("93210283"),
                new Email("charlotte@example.com"), getTagSet("neighbours")),
            new Customer(new CustomerName("David Li"), new ContactNumber("91031282"),
                new Email("lidavid@example.com"), getTagSet("family")),
            new Customer(new CustomerName("Irfan Ibrahim"), new ContactNumber("92492021"),
                new Email("irfan@example.com"), getTagSet("classmates")),
            new Customer(new CustomerName("Roy Balakrishnan"), new ContactNumber("92624417"),
                new Email("royb@example.com"), getTagSet("colleagues"))
        };
    }

    public static ReadOnlyDataBook<Customer> getSampleCustomerBook() {
        CustomerBook sampleCustBook = new CustomerBook();
        for (Customer sampleCustomer : getSampleCustomers()) {
            sampleCustBook.addCustomer(sampleCustomer);
        }
        return sampleCustBook;
    }

    public static Phone[] getSamplePhones() {
        return new Phone[] {
            new Phone(new IdentityNumber("990003709954321"),
                new SerialNumber("28xa9q2ns"), new PhoneName("iPhone 11"), new Brand("Apple"),
                Capacity.SIZE_128GB, new Colour("Jet Black"), new Cost("$1100"),
                getTagSet("New")),
            new Phone(new IdentityNumber("990001940227978"),
                new SerialNumber("1d27s9az"), new PhoneName("iPhone 8"), new Brand("Apple"),
                Capacity.SIZE_64GB, new Colour("White"), new Cost("$400"),
                getTagSet("Used")),
            new Phone(new IdentityNumber("352039075644270"),
                new SerialNumber("2ncs81ma"), new PhoneName("Galaxy S11"), new Brand("Samsung"),
                Capacity.SIZE_256GB, new Colour("Black"), new Cost("$1000"),
                getTagSet("New")),
            new Phone(new IdentityNumber("013373005371667"),
                new SerialNumber("29asdn1mx"), new PhoneName("iPhone XR"), new Brand("Apple"),
                Capacity.SIZE_256GB, new Colour("Coral"), new Cost("$750"),
                getTagSet("Used")),
            new Phone(new IdentityNumber("358373060612446"),
                new SerialNumber("129zn28xa"), new PhoneName("Pixel 3"), new Brand("Google"),
                Capacity.SIZE_64GB, new Colour("White"), new Cost("$800"),
                getTagSet("New")),
            new Phone(new IdentityNumber("990002722150925"),
                new SerialNumber("x82n10zm1a"), new PhoneName("iPhone 11"), new Brand("Apple"),
                Capacity.SIZE_256GB, new Colour("Purple"), new Cost("$1300"),
                getTagSet("New"))
        };
    }

    public static ReadOnlyDataBook<Phone> getSamplePhoneBook() {
        PhoneBook samplePhoneBook = new PhoneBook();
        for (Phone samplePhone : getSamplePhones()) {
            samplePhoneBook.addPhone(samplePhone);
        }
        return samplePhoneBook;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static Order[] getSampleOrders() {
        return new Order[] {
            new Order(UUID.randomUUID(),
                   new Customer(new CustomerName("Charlotte Oliveiro"), new ContactNumber("93210283"),
                        new Email("charlotte@example.com"), getTagSet("neighbours")),
                   new Phone(new IdentityNumber("990003709954321"),
                        new SerialNumber("28xa9q2ns"), new PhoneName("iPhone 11"), new Brand("Apple"),
                        Capacity.SIZE_128GB, new Colour("Jet Black"), new Cost("$1100"),
                        getTagSet("New")),
                   new Price("$1000"),
                   Status.UNSCHEDULED,
                   Optional.empty(),
                   getTagSet("Urgent")),
            new Order(UUID.randomUUID(),
                  new Customer(new CustomerName("Alex Yeoh"), new ContactNumber("87438807"),
                        new Email("alexyeoh@example.com"), getTagSet("friends")),
                  new Phone(new IdentityNumber("990001940227978"),
                        new SerialNumber("1d27s9az"), new PhoneName("iPhone 8"), new Brand("Apple"),
                        Capacity.SIZE_64GB, new Colour("White"), new Cost("$400"),
                        getTagSet("Used")),
                  new Price("$1500"),
                  Status.UNSCHEDULED,
                  Optional.empty(),
                    getTagSet("New")),
            new Order(UUID.randomUUID(),
                  new Customer(new CustomerName("David Li"), new ContactNumber("91031282"),
                        new Email("lidavid@example.com"), getTagSet("family")),
                  new Phone(new IdentityNumber("352039075644270"),
                        new SerialNumber("2ncs81ma"), new PhoneName("Galaxy S11"), new Brand("Samsung"),
                        Capacity.SIZE_256GB, new Colour("Black"), new Cost("$1000"),
                        getTagSet("New")),
                  new Price("$1200"),
                  Status.UNSCHEDULED,
                  Optional.empty(), getTagSet("New")),
        };
    }

    public static ReadOnlyDataBook<Order> getSampleOrderBook() {
        OrderBook sampleOrderBook = new OrderBook();
        for (Order sampleOrder : getSampleOrders()) {
            sampleOrderBook.addOrder(sampleOrder);
        }
        return sampleOrderBook;
    }

}
