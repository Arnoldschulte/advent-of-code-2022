package nl.schulte.advent.day02;

import java.util.EnumSet;

public enum Outcome {
    WIN("Z"),
    LOSE("X"),
    DRAW("Y");

    private final String text;

    Outcome(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Outcome getOutcomeByText(String text) {
        return EnumSet.allOf(Outcome.class).stream()
                .filter(outcome -> text.equals(outcome.getText()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No outcome found for text: " + text));
    }
}
