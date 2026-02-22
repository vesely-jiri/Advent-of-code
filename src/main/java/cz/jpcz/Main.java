package cz.jpcz;

import cz.jpcz.utils.HomeworkResolver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println("https://adventofcode.com/2025/day/6");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                Main.class.getResourceAsStream("/data.txt")
                        )
                )
        )) {
            List<String> lines = reader.lines().toList();

            HomeworkResolver resolver = new HomeworkResolver(lines);

            long result = resolver.resolve();

            System.out.println("Result: " + result);


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}