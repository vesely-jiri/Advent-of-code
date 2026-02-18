package cz.jpcz;

import cz.jpcz.utils.IdValidator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.out.println("https://adventofcode.com/2025/day/2");

        IdValidator validator = new IdValidator();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(Main.class.getResourceAsStream("/data.txt"))));
        ) {

            String line = reader.readLine();
            String[] split = line.trim().split(",");
            long result = 0;
            for (int i = 0; i < split.length; i++) {
                result += validator.getNotValidId(split[i]);
            }

            System.out.println("Summary of invalid ids is: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}