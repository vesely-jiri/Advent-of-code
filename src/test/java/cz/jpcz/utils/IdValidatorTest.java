package cz.jpcz.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IdValidatorTest {

    private IdValidator validator;

    @BeforeEach
    void setUp() {
        this.validator = new IdValidator();
    }

    @Test
    void oneInvalidMirrorIdTest() {
        String id = "10-12";
        long result = validator.getNotValidId(id);

        assertEquals(result,11);
    }

    @Test
    void oneInvalidTripleMirrorTest() {
        String id = "101009-101011";
        long result = validator.getNotValidId(id);
        assertEquals(result,101010);
    }
}
