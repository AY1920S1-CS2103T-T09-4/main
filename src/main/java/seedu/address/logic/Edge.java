package seedu.address.logic;

import seedu.address.logic.parser.Prefix;

class Edge {

    private final Prefix weight;
    private final Node<?> source;
    private final Node<?> destination;

    Edge(Prefix weight, Node<?> source, Node<?> destination) {
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    Prefix getWeight() {
        return weight;
    }

    Node<?> getSource() {
        return source;
    }

    Node<?> getDestination() {
        return destination;
    }

}
