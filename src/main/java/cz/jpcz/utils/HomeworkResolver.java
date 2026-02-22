package cz.jpcz.utils;

import java.util.ArrayList;
import java.util.List;

public class HomeworkResolver {

    List<CodeBlock> codeBlocks = new ArrayList<>();

    public HomeworkResolver(List<String> input) {

        // loop columns(characters) from end
        CodeBlock codeBlock = new CodeBlock();
        for (int col = input.getLast().length() - 1; col >= 0; col--) {

            StringBuilder str = new StringBuilder();

            char currentChar = ' ';
            // loop through rows from up to down
            for (int row = 0; row < input.size(); row++) {
                currentChar = input.get(row).charAt(col);
                if (currentChar == '+' || currentChar == '*') {
                    codeBlock.symbol = currentChar;
                    codeBlocks.add(codeBlock);

                    // skip empty column
                    col--;
                } else if (Character.isDigit(currentChar)){
                    str.append(currentChar);
                }
            }
            codeBlock.blocks.add(str.toString());
            if (col >= 0 && (currentChar == '*' || currentChar == '+')) codeBlock = new CodeBlock();

        }
    }

    public long resolve() {
        long result = 0;

        for (CodeBlock cb : codeBlocks) {
            result += cb.calculateBlocks();

        }

        return result;
    }

    private static class CodeBlock {
        char symbol;
        List<String> blocks = new ArrayList<>();

        public CodeBlock() {}

        public long calculateBlocks() {
            long result = (symbol == '*') ? 1 : 0;

            for (String s : blocks) {
                int value = Integer.parseInt(s);
                switch (symbol) {
                    case '+':
                        result += value;
                        break;
                    case '*':
                        result *= value;
                        break;
                }
            }

            return result;
        }
    }
}
