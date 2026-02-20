package cz.jpcz.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class GridChecker {

    private boolean[][] grid;

    private static final int[] DX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DY = {-1, 0, 1, -1, 1, -1, 0, 1};

    public GridChecker(String resourceName) {
        this.grid = loadGrid(resourceName);
    }

    private boolean[][] loadGrid(String resourceName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                getClass().getResourceAsStream(resourceName))
                )
        )) {

            List<String> lines = reader.lines().toList();

            int height = lines.size();
            int width = lines.get(0).length();

            boolean[][] grid = new boolean[height][width];

            for (int y = 0; y < height; y++) {
                String line = lines.get(y);
                for (int x = 0; x < width; x++) {
                    grid[y][x] = line.charAt(x) == '@';
                }
            }

            return grid;

        } catch (Exception e) {
            throw new IllegalStateException("Failed to load grid", e);
        }
    }

    public int countAllObjects(int surroundingLimit, boolean remove) {
        int result = 0;
        boolean countIncreased;
        do {
            countIncreased = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (!grid[i][j]) continue;
                    int surroundings = countSurroundings(i, j);
                    if (surroundings <= surroundingLimit) {
                        if (remove) grid[i][j] = false;
                        countIncreased = true;
                        result++;
                    }
                }
            }
            if (!remove) return result;
        } while (countIncreased);

        return result;
    }

    private int countSurroundings(int x, int y) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int newX = x + DX[i];
            int newY = y + DY[i];

            if (isInsideGrid(newX, newY) && grid[newX][newY]) {
                count++;
            }
        }

        return count;
    }

    private boolean isInsideGrid(int x, int y) {
        return x >= 0 && y >= 0 &&
                x < grid.length &&
                y < grid[0].length;
    }
}
