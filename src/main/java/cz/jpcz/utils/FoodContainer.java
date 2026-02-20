package cz.jpcz.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FoodContainer {

    private final List<Range> ranges = new ArrayList<>();
    private final List<Long> ids = new ArrayList<>();

    public FoodContainer(List<String> inventory) {
        boolean idSection = false;
        for (String s : inventory) {
            if (s == null || s.isEmpty()) {
                idSection = true;
                continue;
            }
            if (idSection) {
                ids.add(Long.parseLong(s));
            } else {
                ranges.add(new Range(s));
            }
        }
    }

    public long getFreshSpace() {
        List<Range> sorted = ranges.stream()
                .sorted(Comparator.comparingLong(r -> r.min))
                .toList();

        List<Range> merged = new ArrayList<>();

        Range current = sorted.get(0);
        for (int i = 1; i < sorted.size(); i++) {
            Range next = sorted.get(i);
            if (next.min <= current.max) {
                current = new Range(current.min, Math.max(current.max, next.max));
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        return merged.stream()
                .mapToLong(r -> r.max - r.min + 1)
                .sum();
    }

    public int getFreshFoodCount() {
        int fresh = 0;
        for (long id : ids) {
            for (Range r : ranges) {
                if (r.isInRange(id)) {
                    fresh++;
                    break;
                }
            }
        }

        return fresh;
    }

    private static class Range {
        long min;
        long max;

        public Range() {}
        public Range(long min, long max) {
            this.min = min;
            this.max = max;
        }
        public Range(String input) {
            String[] split = input.split("-");
            min = Long.parseLong(split[0]);
            max = Long.parseLong(split[1]);
        }

        public boolean isInRange(long input) {
            return input >= min && input <= max;
        }
    }
}
