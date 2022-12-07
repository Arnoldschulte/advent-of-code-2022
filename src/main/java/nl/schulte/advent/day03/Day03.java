package nl.schulte.advent.day03;

import nl.schulte.advent.util.TextParser;
import org.apache.commons.collections4.ListUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

public class Day03 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final List<String> textLines = TextParser.getTextLines("input/day03.txt");

        final List<Rucksack> rucksacks = textLines.stream()
                .map(Rucksack::new)
                .toList();

        final int sumOfPriorities = rucksacks.stream()
                .map(Rucksack::findDuplicateItem)
                .mapToInt(AlphabetUtil::getPriority)
                .sum();

        System.out.println("Sum of priorities of duplicate rucksack items: " + sumOfPriorities);

        final List<List<Rucksack>> groupOfElves = ListUtils.partition(rucksacks, 3);

        final int sumOfGroupPriorities = groupOfElves.stream()
                .map(RucksackUtil::findDuplicate)
                .filter(Objects::nonNull)
                .mapToInt(AlphabetUtil::getPriority)
                .sum();

        System.out.println("Sum of priorities of duplicate rucksack items per group: " + sumOfGroupPriorities);
    }
}
