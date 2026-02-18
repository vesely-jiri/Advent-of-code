package cz.jpcz.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZeroIterationResolverTest {

    @Test
    void sampleTest() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String[] inputs = { "L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82" };
        int result = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (resolver.resolve(inputs[i]) == 0) result++;
        }

        assertEquals(3, result);
        assertEquals(3, resolver.getPassThruZeroCount());

    }


//--------------------------------------------------------------------------------------------------------------------

    @Test
    void leftFromZeroToZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(0);
        String input = "L100";
        int result = resolver.resolve(input);

        assertEquals(0, result);
    }

    @Test
    void leftRotateMoreThanHundred() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "L150";
        int result = resolver.resolve(input);

        assertEquals(0, result);
    }

    @Test
    void leftToZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(36);
        String input = "L36";
        int result = resolver.resolve(input);

        assertEquals(0, result);
    }

    @Test
    void leftPassThruZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "L55";
        int result = resolver.resolve(input);

        assertEquals(95,result);
        assertEquals(1, resolver.getPassThruZeroCount());
    }

    @Test
    void leftPassThruMultipleZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "L355";
        int result = resolver.resolve(input);

        assertEquals(95,result);
        assertEquals(4, resolver.getPassThruZeroCount());
    }

    @Test
    void leftPassThruZeroThousandTimes() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "L1000";
        int result = resolver.resolve(input);

        assertEquals(50,result);
        assertEquals(10, resolver.getPassThruZeroCount());
    }

//--------------------------------------------------------------------------------------------------------------------

    @Test
    void rightFromZeroToZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(0);
        String input = "R100";
        int result = resolver.resolve(input);

        assertEquals(0, result);
    }

    @Test
    void rightRotateMoreThanHundred() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "R150";
        int result = resolver.resolve(input);

        assertEquals(0, result);
    }

    @Test
    void rightToZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(36);
        String input = "R64";
        int result = resolver.resolve(input);

        assertEquals(0, result);
    }

    @Test
    void rightPassThruZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "R55";
        int result = resolver.resolve(input);

        assertEquals(5, result);
        assertEquals(1, resolver.getPassThruZeroCount());
    }

    @Test
    void rightPassThruMultipleZero() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "R355";
        int result = resolver.resolve(input);

        assertEquals(5,result);
        assertEquals(4, resolver.getPassThruZeroCount());
    }

    @Test
    void rightPassThruZeroThousandTimes() {
        ZeroIterationResolver resolver = new ZeroIterationResolver(50);
        String input = "R1000";
        int result = resolver.resolve(input);

        assertEquals(50,result);
        assertEquals(10, resolver.getPassThruZeroCount());
    }
}
