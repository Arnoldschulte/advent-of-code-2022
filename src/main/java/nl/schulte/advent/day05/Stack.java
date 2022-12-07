package nl.schulte.advent.day05;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Stack {

    private final Queue<String> stackedCrates = new PriorityQueue<>();

    public Stack(List<String> lines, int position) {
        for (String line : lines) {
            final String crate = line.substring(position, position);
            stackedCrates.add(crate);
        }
    }
}
