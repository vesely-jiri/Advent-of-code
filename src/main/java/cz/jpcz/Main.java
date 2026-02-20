package cz.jpcz;

import cz.jpcz.utils.FoodContainer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println("https://adventofcode.com/2025/day/5");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                Main.class.getResourceAsStream("/data.txt")
                        )
                )
        )) {

            List<String> lines = reader.lines().toList();

            FoodContainer container = new FoodContainer(lines);

            int result = container.getFreshFoodCount();
            System.out.println("There are " + result + " fresh ingredients");

            long result2 = container.getFreshSpace();
            System.out.println("There is total of " + result2 + " space for fresh food");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}