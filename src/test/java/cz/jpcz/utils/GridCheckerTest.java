package cz.jpcz.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GridCheckerTest {

    private GridChecker checker;

    @Test
    void basicNoRemoveTest() {
        String path = "/data.txt";
        checker = new GridChecker(path);
        int result = checker.countAllObjects(3,false);

        assertEquals(4, result);
    }

    @Test
    void basicRemoveTest() {
        String path = "/data.txt";
        checker = new GridChecker(path);
        int result = checker.countAllObjects(3,true);

        assertEquals(5, result);
    }
}
