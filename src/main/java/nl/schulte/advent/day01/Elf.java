package nl.schulte.advent.day01;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    private final List<Integer> foodInventory = new ArrayList<>();

    public void addFoodToInventory(int calories) {
        foodInventory.add(calories);
    }

    public Integer getTotalCaloriesInInventory() {
        return foodInventory.stream().mapToInt(Integer::intValue).sum();
    }
}
