package cz.jpcz;

import cz.jpcz.utils.ZeroIterationResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


public class Main {
    public static void main(String[] args) {
        System.out.println("Task: https://adventofcode.com/2025/day/1");

        ZeroIterationResolver resolver = new ZeroIterationResolver(50);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(Main.class.getResourceAsStream("/data.txt"))
                ))) {

            String line;
            int zeroIterations = 0;
            while ((line = reader.readLine()) != null) {
                int currentIterations = resolver.resolve(line);
                if (currentIterations == 0) zeroIterations++;
            }
            System.out.println("Number zero was called: " + zeroIterations + " times");
            System.out.println("Zero was passed thru: " + resolver.getPassThruZeroCount() + " times");
            System.out.println("Total zero count: " + (zeroIterations + resolver.getPassThruZeroCount()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}