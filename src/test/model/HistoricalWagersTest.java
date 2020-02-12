package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HistoricalWagersTest {
    HistoricalWagers historicalWagers;
    Wager wager1;
    Match match1;

    @BeforeEach
    void runBefore() {
        historicalWagers = new HistoricalWagers();
        match1 = new Match("Raptors", "Warriors");
        wager1 = new Wager(match1, 20);
    }

    @Test
    void testConstructor() {
        assertEquals(0, historicalWagers.getNumberOfPreviousWagers());
    }

    @Test
    void testAddWager() {
        historicalWagers.addWager(wager1);

        assertEquals(1, historicalWagers.getNumberOfPreviousWagers());
    }
}
