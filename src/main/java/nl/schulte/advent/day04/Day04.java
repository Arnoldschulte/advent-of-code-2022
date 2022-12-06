package nl.schulte.advent.day04;

import nl.schulte.advent.util.TextParser;

import java.io.IOException;
import java.util.List;

public class Day04 {

    public static void main(String[] args) throws IOException {
        final List<String> textLines = TextParser.getTextLines("input/day04.txt");

        final List<ElvePair> elvePairs = textLines.stream()
                .map(ElvePair::new)
                .toList();

        final List<ElvePair> fullyOverlapElvePairs = elvePairs.stream()
                .filter(ElvePair::hasFullOverlap)
                .toList();
        System.out.println("Assignment pairs fully contain the other: " + fullyOverlapElvePairs.size());

        final List<ElvePair> overlapElvePairs = elvePairs.stream()
                .filter(ElvePair::hasOverlap)
                .toList();
        System.out.println("Assignment pairs overlap the other: " + overlapElvePairs.size());
    }
}
