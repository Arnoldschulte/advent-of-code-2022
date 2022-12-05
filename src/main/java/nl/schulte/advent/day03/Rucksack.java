package nl.schulte.advent.day03;

public class Rucksack {

    private final String line;
    private final char[] compartmentOne;
    private final char[] compartmentTwo;

    public Rucksack(String textLine) {
        this.line = textLine;
        final int mid = textLine.length() / 2;
        this.compartmentOne = textLine.substring(0, mid).toCharArray();
        this.compartmentTwo = textLine.substring(mid).toCharArray();
    }

    public String getLine() {
        return line;
    }

    public Character findDuplicateItem() {
        for (char c1 : compartmentOne) {
            for (char c2 : compartmentTwo) {
                if (c1 == c2) {
                    return c1;
                }
            }
        }
        return null;
    }
}
