package nl.schulte.advent.day02;

import nl.schulte.advent.util.TextParser;

import java.io.IOException;
import java.util.List;

public class Day02 {

    public static void main(String[] args) throws IOException {
        final List<String> textLines = TextParser.getTextLines("input/day02.txt");

        final int totalPoints = textLines.stream()
                .map((String line) -> new RpsBattle(line, false))
                .mapToInt(RpsBattle::calculatePoints)
                .sum();

        System.out.println("Number of points: " + totalPoints);

        final int totalPointsDecrypting = textLines.stream()
                .map((String line) -> new RpsBattle(line, true))
                .mapToInt(RpsBattle::calculatePoints)
                .sum();

        System.out.println("Number of points: " + totalPointsDecrypting);
    }
}
