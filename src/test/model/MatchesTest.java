package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchesTest {
    Matches matches;
    Match match1;
    Match match2;
    Match match3;

    @BeforeEach
    void runBefore() {
        matches = new Matches();
        match1 = new Match("Raptors", "Warriors");
        match2 = new Match("Lakers", "Clippers");
        match3 = new Match("Blazers", "Kings");
    }

    @Test
    void testConstructor() {
        assertEquals(0, matches.getNumberOfMatches());
        assertFalse(matches.containsMatch(match1));
        assertEquals("No matches today", matches.linesOfMatches());
    }

    @Test
    void testAddMultipleMatches() {
        matches.addMatch(match1);
        matches.addMatch(match2);

        assertEquals(2, matches.getNumberOfMatches());
        assertTrue(matches.containsMatch(match1));
        assertFalse(matches.containsMatch(match3));
        assertEquals("Raptors vs. Warriors\nLakers vs. Clippers\n", matches.linesOfMatches());
    }

    @Test
    void testClearMatches() {
        matches.addMatch(match1);
        matches.clearMatches();

        assertEquals(0, matches.getNumberOfMatches());
        assertFalse(matches.containsMatch(match1));
        assertEquals("No matches today", matches.linesOfMatches());
    }

}
