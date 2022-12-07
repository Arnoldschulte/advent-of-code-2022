package nl.schulte.advent.day05;

import nl.schulte.advent.util.TextParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day05 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final List<String> textLines = TextParser.getTextLines("input/day05.txt");

        final int endOfDrawing = textLines.indexOf("");
        final List<String> drawingCargoCrane = textLines.subList(0, endOfDrawing);

        final List<String> instructions = textLines.subList(endOfDrawing + 1, textLines.size() - 1);
    }
}
