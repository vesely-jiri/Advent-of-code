package cz.jpcz.utils;

public class ZeroIterationResolver {

    private int actualPosition;
    private int passThruZero = 0;

    public ZeroIterationResolver(int startingPosition){
        this.actualPosition = startingPosition;
    };

    public int resolve(String input) {
        Direction direction = getDirection(input);
        int parsedInt = parse(input);
        return getRotatedPosition(parsedInt, direction);
    }

    public int getPassThruZeroCount() {
        return passThruZero;
    }

    private Direction getDirection(String in) {
        return (in.startsWith("L")) ? Direction.LEFT : Direction.RIGHT;
    }

    private int getRotatedPosition(int number, Direction direction) {
        if (direction == Direction.LEFT) {
            // Number is going over 0
            if ((actualPosition - number) < 0) {
                int remaining = number - actualPosition;
                if (actualPosition != 0) passThruZero++;
                actualPosition = 100;
                return getRotatedPosition(remaining, direction);
            } else {
                return actualPosition -= number;
            }
        } else {
            // Number is going over 99
            if ((actualPosition + number) > 99) {
                if ((actualPosition + number) != 100 && actualPosition != 100) passThruZero++;
                int remaining = 100 - actualPosition;
                actualPosition = 0;
                return getRotatedPosition(number - remaining, direction);
            } else {
                return actualPosition += number;
            }
        }
    }

    private int parse(String input) {
        String sub = input.substring(1);
        return Integer.parseInt(sub);
    }

    private enum Direction {
        LEFT, // Rotating for smaller position
        RIGHT // Rotating for higher position
    }
}
