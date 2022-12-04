package nl.schulte.advent.day02;

import java.util.EnumSet;

public enum Shape {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    private final String symbolOpponent;
    private final String symbolPlayer;
    private final int points;

    Shape(String symbolOpponent, String symbolPlayer, int points) {
        this.symbolOpponent = symbolOpponent;
        this.symbolPlayer = symbolPlayer;
        this.points = points;
    }

    public String getSymbolOpponent() {
        return symbolOpponent;
    }

    public String getSymbolPlayer() {
        return symbolPlayer;
    }

    public int getPoints() {
        return points;
    }

    public static Shape getShapeByTextOpponent(String text) {
        return EnumSet.allOf(Shape.class).stream()
                .filter(shape -> text.equals(shape.getSymbolOpponent()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No shape found for opponent for text: " + text));
    }

    public static Shape getShapeByTextPlayer(String text) {
        return EnumSet.allOf(Shape.class).stream()
                .filter(shape -> text.equals(shape.getSymbolPlayer()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No shape found for player for text: " + text));
    }

    public static Shape decryptShapeByOpponentAndOutcome(Shape opponent, Outcome outcome) {
        switch (outcome) {
            case WIN -> {
                return getWinShape(opponent);
            }
            case LOSE -> {
                return getLoseShape(opponent);
            }
            case DRAW -> {
                return opponent;
            }
            default ->
                    throw new IllegalArgumentException(String.format("Cannot decrypt shape by opponent %s and outcome %s", opponent, outcome));
        }
    }

    private static Shape getWinShape(Shape shape) {
        switch (shape) {
            case PAPER -> {
                return SCISSORS;
            }
            case ROCK -> {
                return PAPER;
            }
            case SCISSORS -> {
                return ROCK;
            }
            default -> throw new IllegalArgumentException("No winning shape found for shape: " + shape);
        }
    }

    private static Shape getLoseShape(Shape shape) {
        switch (shape) {
            case PAPER -> {
                return ROCK;
            }
            case ROCK -> {
                return SCISSORS;
            }
            case SCISSORS -> {
                return PAPER;
            }
            default -> throw new IllegalArgumentException("No losing shape found for shape: " + shape);
        }
    }
}
