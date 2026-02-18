package cz.jpcz.utils;

public class IdValidator {

    public IdValidator() {}

    public long getNotValidId(String input) {

        String[] split = input.split("-");
        long firstPart = Long.parseLong(split[0]);
        long secondPart = Long.parseLong(split[1]);

        long result = 0;
        long current = firstPart;
        while (current <= secondPart) {
            if (isRepeatedSequence(String.valueOf(current))) {
                result += current;
            }
            current++;
        }
        return result;
    }

    private boolean isRepeatedSequence(String str) {
        int len = str.length();
        for (int block = 1; block <= len / 2; block++) {
            if (len % block != 0) continue;
            String pattern = str.substring(0, block);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len / block; i++) sb.append(pattern);
            if (sb.toString().equals(str)) return true;
        }
        return false;
    }
}
