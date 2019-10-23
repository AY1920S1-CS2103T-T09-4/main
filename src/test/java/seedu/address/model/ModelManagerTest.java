package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CUSTOMERS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalCustomers.DANIEL;
import static seedu.address.testutil.TypicalCustomers.FIONA;
import static seedu.address.testutil.TypicalOrders.ORDERONE;
import static seedu.address.testutil.TypicalOrders.ORDERTHREE;
import static seedu.address.testutil.TypicalOrders.VIPORDER;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPhones.IPHONEONE;
import static seedu.address.testutil.TypicalPhones.IPHONEXR;
import static seedu.address.testutil.TypicalSchedules.CBD_SCHEDULE;
import static seedu.address.testutil.TypicalSchedules.SCHEDULEONE;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.customer.Customer;
import seedu.address.model.customer.predicates.CustomerNameContainsKeywordsPredicate;
import seedu.address.model.order.Order;
import seedu.address.model.phone.Phone;
import seedu.address.model.schedule.Schedule;
import seedu.address.testutil.CustomerBookBuilder;
import seedu.address.testutil.OrderBookBuilder;
import seedu.address.testutil.PhoneBookBuilder;
import seedu.address.testutil.ScheduleBookBuilder;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new AddressBook(), new AddressBook(modelManager.getAddressBook()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAddressBookFilePath(Paths.get("address/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setAddressBookFilePath(Paths.get("new/address/book/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setAddressBookFilePath(null));
    }

    @Test
    public void setAddressBookFilePath_validPath_setsAddressBookFilePath() {
        Path path = Paths.get("address/book/file/path");
        modelManager.setAddressBookFilePath(path);
        assertEquals(path, modelManager.getAddressBookFilePath());
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasPerson(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(modelManager.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        modelManager.addPerson(ALICE);
        assertTrue(modelManager.hasPerson(ALICE));
    }

    @Test
    public void getFilteredPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredPersonList().remove(0));
    }

    @Test
    public void hasCustomer_nullCustomer_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasCustomer(null));
    }

    @Test
    public void hasCustomer_customerNotInCustomerBook_returnsFalse() {
        assertFalse(modelManager.hasCustomer(DANIEL));
    }

    @Test
    public void hasCustomer_customerInCustomerBook_returnsTrue() {
        modelManager.addCustomer(DANIEL);
        assertTrue(modelManager.hasCustomer(DANIEL));
    }

    @Test
    public void getFilteredCustomerList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredCustomerList().remove(0));
    }

    @Test
    public void hasPhone_nullPhone_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasPhone(null));
    }

    @Test
    public void hasPhone_phoneNotInPhoneBook_returnsFalse() {
        assertFalse(modelManager.hasPhone(IPHONEXR));
    }

    @Test
    public void hasPhone_phoneInPhoneBook_returnsTrue() {
        modelManager.addPhone(IPHONEXR);
        assertTrue(modelManager.hasPhone(IPHONEXR));
    }

    @Test
    public void getFilteredPhoneList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredPhoneList().remove(0));
    }

    @Test
    public void hasOrder_nullOrder_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasOrder(null));
    }

    @Test
    public void hasOrder_orderNotInOrderBook_returnsFalse() {
        assertFalse(modelManager.hasOrder(VIPORDER));
    }

    @Test
    public void hasOrder_orderInOrderBook_returnsTrue() {
        modelManager.addOrder(VIPORDER);
        assertTrue(modelManager.hasOrder(VIPORDER));
    }

    @Test
    public void getFilteredOrderList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredOrderList().remove(0));
    }

    @Test
    public void hasSchedule_nullSchedule_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasSchedule(null));
    }

    @Test
    public void hasSchedule_scheduleNotInScheduleBook_returnsFalse() {
        assertFalse(modelManager.hasSchedule(CBD_SCHEDULE));
    }

    @Test
    public void hasSchedule_scheduleInScheduleBook_returnsTrue() {
        modelManager.addSchedule(CBD_SCHEDULE);
        assertTrue(modelManager.hasSchedule(CBD_SCHEDULE));
    }

    @Test
    public void getFilteredScheduleList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredScheduleList().remove(0));
    }

    @Test
    public void setCalendarDate_nullCalendarDate_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setCalendarDate(null));
    }

    @Test
    public void setCalendarDate_validCalendarDate_replacesData() {
        Calendar newCalendar = Calendar.getInstance();
        modelManager.setCalendarDate(newCalendar);
        assertEquals(newCalendar, modelManager.getCalendarDate().getCalendar());
    }

    @Test
    public void equals() {
        //AddressBook addressBook = new AddressBookBuilder().withPerson(ALICE).withPerson(BENSON).build();
        DataBook<Customer> customerBook = new CustomerBookBuilder().withCustomer(DANIEL).withCustomer(FIONA).build();
        DataBook<Phone> phoneBook = new PhoneBookBuilder().withPhone(IPHONEONE).withPhone(IPHONEXR).build();
        DataBook<Order> orderBook = new OrderBookBuilder().withOrder(ORDERONE).withOrder(ORDERTHREE).build();
        DataBook<Schedule> scheduleBook = new ScheduleBookBuilder().withSchedule(CBD_SCHEDULE)
                .withSchedule(SCHEDULEONE).build();

        DataBook<Order> archivedOrderBook = new OrderBookBuilder().withOrder(ORDERONE).withOrder(ORDERTHREE).build();

        DataBook<Customer> differentCustomerBook = new DataBook<>();
        DataBook<Phone> differentPhoneBook = new DataBook<>();
        DataBook<Order> differentOrderBook = new DataBook<>();
        DataBook<Schedule> differentScheduleBook = new DataBook<>();
        DataBook<Order> differentArchivedOrderBook = new DataBook<>();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = new ModelManager(customerBook, phoneBook, orderBook, scheduleBook, archivedOrderBook, userPrefs);
        ModelManager modelManagerCopy = new ModelManager(customerBook, phoneBook, orderBook,
                scheduleBook, archivedOrderBook, userPrefs);
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different customerBook -> returns false
        assertFalse(modelManager.equals(new
                ModelManager(differentCustomerBook, phoneBook, orderBook, scheduleBook, archivedOrderBook, userPrefs)));

        // different phoneBook -> returns false
        assertFalse(modelManager.equals(new
                ModelManager(customerBook, differentPhoneBook, orderBook, scheduleBook, archivedOrderBook, userPrefs)));

        // different orderBook -> returns false
        assertFalse(modelManager.equals(new
                ModelManager(customerBook, phoneBook, differentOrderBook, scheduleBook, archivedOrderBook, userPrefs)));

        // different archiveOrderBook -> returns false
        assertFalse(modelManager.equals(new
                ModelManager(customerBook, phoneBook, orderBook, scheduleBook, differentArchivedOrderBook, userPrefs)));

        // different scheduleBook -> returns false
        assertFalse(modelManager.equals(new
                ModelManager(customerBook, phoneBook, orderBook, differentScheduleBook, archivedOrderBook, userPrefs)));

        // different filteredList -> returns false
        String[] keywords = DANIEL.getCustomerName().fullName.split("\\s+");
        modelManager.updateFilteredCustomerList(new CustomerNameContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelManager(customerBook, phoneBook, orderBook, scheduleBook,
                archivedOrderBook, userPrefs)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredCustomerList(PREDICATE_SHOW_ALL_CUSTOMERS);

        // different userPrefs -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertFalse(modelManager.equals(new
                ModelManager(customerBook, phoneBook, orderBook, scheduleBook,
                archivedOrderBook, differentUserPrefs)));

        // different calendar in calendarDate -> returns true
        Calendar differentCalendar = Calendar.getInstance();
        modelManagerCopy.setCalendarDate(differentCalendar);
        assertTrue(modelManager.equals(modelManagerCopy));

    }
}
