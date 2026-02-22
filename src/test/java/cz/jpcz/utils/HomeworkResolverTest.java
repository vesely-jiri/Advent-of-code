package cz.jpcz.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HomeworkResolverTest {

    @Test
    void basicAdditionTest() {
        long result;

        List<String> lines = new ArrayList<>();
        lines.add("64 ");
        lines.add("23 ");
        lines.add("314");
        lines.add("+  ");

        HomeworkResolver resolver = new HomeworkResolver(lines);

        result = resolver.resolve();

        assertEquals(1058, result);
    }

    @Test
    void sampleTest() {
        long result;

        List<String> lines = new ArrayList<>();
        lines.add("123 328  51 64 ");
        lines.add(" 45 64  387 23 ");
        lines.add("  6 98  215 314");
        lines.add("*   +   *   +  ");

        HomeworkResolver resolver = new HomeworkResolver(lines);

        result = resolver.resolve();

        assertEquals(3263827, result);
    }
}
