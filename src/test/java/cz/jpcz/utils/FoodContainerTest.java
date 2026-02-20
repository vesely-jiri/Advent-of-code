package cz.jpcz.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FoodContainerTest {

    @Test
    void getFreshFoodCount_basicMatch() {
        FoodContainer container = new FoodContainer(List.of(
                "100-200",
                "",
                "150"
        ));
        assertEquals(1, container.getFreshFoodCount());
    }

    @Test
    void getFreshFoodCount_noMatch() {
        FoodContainer container = new FoodContainer(List.of(
                "100-200",
                "",
                "300"
        ));
        assertEquals(0, container.getFreshFoodCount());
    }

    @Test
    void getFreshFoodCount_boundaryValues() {
        FoodContainer container = new FoodContainer(List.of(
                "100-200",
                "",
                "100",
                "200"
        ));
        assertEquals(2, container.getFreshFoodCount());
    }

    @Test
    void getFreshSpace_singleRange() {
        FoodContainer container = new FoodContainer(List.of(
                "100-104"
        ));
        assertEquals(5, container.getFreshSpace());
    }

    @Test
    void getFreshSpace_overlappingRanges() {
        FoodContainer container = new FoodContainer(List.of(
                "100-200",
                "150-300"
        ));
        assertEquals(201, container.getFreshSpace());
    }

    @Test
    void getFreshSpace_nonOverlappingRanges() {
        FoodContainer container = new FoodContainer(List.of(
                "100-200",
                "300-400"
        ));
        assertEquals(202, container.getFreshSpace());
    }
}