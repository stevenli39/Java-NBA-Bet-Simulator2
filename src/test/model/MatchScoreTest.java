package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchScoreTest {
    MatchScore matchScore;

    @BeforeEach
    void runBefore() {
        matchScore = new MatchScore(110, 90);
    }

    @Test
    void testMatchScoreFunctions() {
        assertEquals(110, matchScore.getScore1());
        assertEquals(90, matchScore.getScore2());
    }
}
