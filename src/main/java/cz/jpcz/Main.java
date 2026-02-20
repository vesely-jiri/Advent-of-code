package cz.jpcz;

import cz.jpcz.utils.GridChecker;


public class Main {

    private static final String  SAMPLE_FILE = "/data.txt";
    private static final int SURROUNDING_LIMIT = 3;
    private static final boolean REMOVE_OBJECTS = true;

    public static void main(String[] args) {
        System.out.println("https://adventofcode.com/2025/day/4");
        GridChecker checker = new GridChecker(SAMPLE_FILE);
        int result = checker.countAllObjects(SURROUNDING_LIMIT, REMOVE_OBJECTS);
        if (REMOVE_OBJECTS) {
            System.out.println("There are " + result + " objects, that can be removed");
        } else {
            System.out.println("There are " + result + " objects, that have less than " + (SURROUNDING_LIMIT + 1) + " surroundings");
        }
    }
}