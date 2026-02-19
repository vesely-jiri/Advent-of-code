package cz.jpcz.utils;

public class JoltageFinder {

    public long findLargest(String input, int size) {
        char[] sequence = input.toCharArray();
        StringBuilder result = new StringBuilder();

        int firstSearchIndex = 0;
        for (int resultIndex = 0; resultIndex < size; resultIndex++) {
            int lastSearchIndex = (sequence.length - size + resultIndex);
            int max = -1;
            for (int j = firstSearchIndex; j <= lastSearchIndex; j++) {
                int parsed = sequence[j] - '0';
                if (parsed > max) {
                    max = parsed;
                    firstSearchIndex = j;
                }
            }
            result.append(sequence[firstSearchIndex]);
            firstSearchIndex++;
        }

        return Long.parseLong(result.toString());
    }
}
