package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WagerTest {
    Wager wager;
    Match match1;

    @BeforeEach
    void runBefore() {
        match1 = new Match("Raptors", "Lakers");
        wager = new Wager(match1, 200);
    }

    @Test
    void testWagerFunctions() {
        assertEquals(match1, wager.getMatchWagered());
        assertEquals(200, wager.getAmountWagered());
    }
}
