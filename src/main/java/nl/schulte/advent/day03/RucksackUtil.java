package nl.schulte.advent.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RucksackUtil {

    public static Character findDuplicate(List<Rucksack> rucksacks) {
        final List<String> lines = rucksacks.stream()
                .map(Rucksack::getLine)
                .toList();

        final HashMap<Character, Integer> numberOfCharacters = new HashMap<>();
        for (String line : lines) {
            final List<Character> uniqueCharacters = line.chars().mapToObj(c -> (char) c).distinct().toList();
            for (Character character : uniqueCharacters) {
                final boolean present = numberOfCharacters.get(character) == null;
                numberOfCharacters.put(character, present ? 1 : numberOfCharacters.get(character) + 1);
            }
        }
        final Set<Map.Entry<Character, Integer>> entries = numberOfCharacters.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == rucksacks.size()) {
                return entry.getKey();
            }
        }
        return null;
    }
}
