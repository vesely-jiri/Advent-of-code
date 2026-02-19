package cz.jpcz.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoltageFinderTest {

    private JoltageFinder finder;

    @BeforeEach
    void setUp() {
        this.finder = new JoltageFinder();
    }

    @Test
    void basicTest1() {
        String input = "987654321111111";
        long result = finder.findLargest(input,2);

        assertEquals(98, result);
    }

    @Test
    void basicTest2() {
        String input = "81119";
        long result = finder.findLargest(input,2);

        assertEquals(89, result);
    }

    @Test
    void basicTest3() {
        String input = "234234234234278";
        long result = finder.findLargest(input,2);

        assertEquals(78, result);
    }

    @Test
    void basicTest4() {
        String input = "818181911112111";
        long result = finder.findLargest(input,2);

        assertEquals(92, result);
    }

//------------------------------------------------------------------------------------------------------------------

    @Test
    void advancedTest1() {
        String input = "4426546555433545424424345444644242452452532444564422646557424354153538454225332755435544545533324152";
        long result = finder.findLargest(input, 12);

        assertEquals(875555555452L, result);
    }

}
