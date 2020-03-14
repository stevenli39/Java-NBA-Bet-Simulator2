package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HistoricalWagersTest {
    HistoricalWagers historicalWagers;

    @BeforeEach
    void runBefore() {
        historicalWagers = new HistoricalWagers();
    }

    @Test
    void testConstructor() {
        assertEquals(0, historicalWagers.getNumberOfPreviousWagers());
        assertEquals("No wagers placed in the past", historicalWagers.linesOfWagers());
    }

    @Test
    void testAddWager() {
        historicalWagers.addWager("Match1, 200");
        historicalWagers.addWager("Match2, 300");

        assertEquals(2, historicalWagers.getNumberOfPreviousWagers());
        assertEquals("Match1, 200\nMatch2, 300\n", historicalWagers.linesOfWagers());
        assertEquals("Match1, 200", historicalWagers.getWager(0));
        assertTrue(historicalWagers.containsWager("Match1, 200"));
        assertFalse(historicalWagers.containsWager("fsa"));
    }
}
