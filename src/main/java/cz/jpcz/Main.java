package cz.jpcz;

import cz.jpcz.utils.JoltageFinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.out.println("https://adventofcode.com/2025/day/3");

        JoltageFinder finder = new JoltageFinder();

        try (BufferedReader reader  = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/data.txt")))
        )) {

            String line;
            long result = 0;
            while ((line = reader.readLine()) != null) {
                result += finder.findLargest(line,12);
            }

            System.out.println("Sum of largest joltages: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}