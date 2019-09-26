package seedu.address.model.schedule;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.order.Order;
import seedu.address.model.tag.Tag;

/**
 * Represents a Schedule, with the Order, Date, Time and Location of the meetup.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Schedule {

    // Identity fields
    private final Order order;

    // Data fields
    private final DateTime dateTime;
    private final Venue venue;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Schedule(Order order, DateTime dateTime, Venue venue, Set<Tag> tags) {
        requireAllNonNull(order, dateTime, venue, tags);
        this.order = order;
        this.dateTime = dateTime;
        this.venue = venue;
        this.tags.addAll(tags);
    }

    public Order getOrder() {
        return order;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public Venue getVenue() {
        return venue;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both schedules have the identity field.
     * This defines a weaker notion of equality between two schedules.
     */
    public boolean isSameSchedule(Schedule otherSchedule) {
        if (otherSchedule == this) {
            return true;
        }

        return otherSchedule != null
                && otherSchedule.getOrder().equals(getOrder());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two schedules.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Schedule)) {
            return false;
        }

        Schedule otherSchedule = (Schedule) other;
        return otherSchedule.getOrder().equals(getOrder())
                && otherSchedule.getDateTime().equals(getDateTime())
                && otherSchedule.getVenue().equals(getVenue())
                && otherSchedule.getTags().equals((getTags()));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(order, dateTime, venue, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Order: ")
                .append(getOrder())
                .append(" Date and Time: ")
                .append(getDateTime())
                .append(" Venue: ")
                .append(getVenue())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}