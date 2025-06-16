package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The class is the unit tests for GroceryCounter.
 */
class GroceryCounterTest {

    /**
     * Demonstrates a sequence of operations on GroceryCounter and
     * provides expected total and overflow counts for each step.
     */
    @Test
    void demoSequenceBehavesAsExpected() {
        GroceryCounter counter = new GroceryCounter();

        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());

        counter.tens();
        counter.tens();
        counter.hundreths();
        assertEquals("$20.01", counter.total());
        assertEquals(0, counter.overflows());

        for (int i = 0; i < 35; i++) {
            counter.ones();
        }
        assertEquals("$55.01", counter.total());
        assertEquals(0, counter.overflows());

        for (int i = 0; i < 100; i++) {
            counter.ones();
        }
        assertEquals("$55.01", counter.total());
        assertEquals(1, counter.overflows());

        counter.clear();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }
}