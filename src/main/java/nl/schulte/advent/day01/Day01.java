package nl.schulte.advent.day01;

import nl.schulte.advent.util.TextParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day01 {

    public static void main(String[] args) throws IOException {
        final List<String> textLines = TextParser.getTextLines("input/day01.txt");

        final List<Integer> sortedElvesTotalCalories = getElvesWithFood(textLines).stream()
                .map(Elf::getTotalCaloriesInInventory)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Maximum calories: " + sortedElvesTotalCalories.get(0));

        int topThreeElvesCalories = sortedElvesTotalCalories.get(0) + sortedElvesTotalCalories.get(1) + sortedElvesTotalCalories.get(2);
        System.out.println("Top three Elves total calories: " + topThreeElvesCalories);
    }

    private static List<Elf> getElvesWithFood(List<String> textLines) {
        final List<Elf> elvesWithFood = new ArrayList<>(List.of(new Elf()));

        int index = 0;
        for (String textLine : textLines) {
            if (textLine.isBlank()) {
                elvesWithFood.add(new Elf());
                index++;
            } else {
                elvesWithFood.get(index).addFoodToInventory(Integer.parseInt(textLine));
            }
        }
        return elvesWithFood;
    }
}
