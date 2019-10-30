package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getAddressBookFilePath();

    Path getCustomerBookFilePath();

    Path getPhoneBookFilePath();

    Path getScheduleBookFilePath();

    Path getOrderBookFilePath();

}