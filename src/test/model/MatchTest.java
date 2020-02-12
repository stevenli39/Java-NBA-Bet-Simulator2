package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
    Match match;

    @BeforeEach
    void runBefore() {
        match = new Match("Raptors", "Lakers");
    }

    @Test
    void testMatchFunctions() {
        assertEquals("Lakers", match.getTeam2());
        assertEquals("Raptors", match.getTeam1());
    }
}
