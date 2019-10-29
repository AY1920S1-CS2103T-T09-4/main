package seedu.address.logic;

import seedu.address.logic.parser.Prefix;

import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a graph implemented as an {@link Edge} list.
 */
class Graph {

    private static final Pattern prefixPattern = Pattern.compile(" .{1,2}/");

    private final Node<?> startingNode;
    private final List<Edge> edges;

    Graph(Node<?> startingNode, List<Edge> edges) {
        this.startingNode = startingNode;
        this.edges = edges;
    }

    AutoCompleteResult process(String input) {
        String stringToCompare = input;
        Node<?> currentNode = startingNode;
        SortedSet<String> values = new TreeSet<>();
        Matcher matcher = prefixPattern.matcher(input);
        while (matcher.find()) {
            Prefix prefix = new Prefix(matcher.group().trim());
            Optional<Node<?>> nextNode = traverse(currentNode, prefix);
            if (nextNode.isPresent()) {
                currentNode = nextNode.get();
            }
            stringToCompare = input.substring(matcher.end());
        }
        if (input.endsWith(" ")) {
            // prefixes
            for (Edge edge : edges) {
                if (edge.getSource().equals(currentNode)) {
                    values.add(edge.getWeight().toString());
                }
            }
            stringToCompare = "";
        } else {
            values.addAll(currentNode.getValues());
        }
        return new AutoCompleteResult(values, stringToCompare);
    }

    private Optional<Node<?>> traverse(Node<?> currentNode, Prefix prefix) {
        for (Edge edge : edges) {
            if (edge.getWeight().equals(prefix) && edge.getSource().equals(currentNode)) {
                return Optional.of(edge.getDestination());
            }
        }
        return Optional.empty();
    }

}
