package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MatchScoresTest {
    MatchScores matchScores;
    MatchScore matchScore1;
    MatchScore matchScore2;
    MatchScore matchScore3;

    @BeforeEach
    void runBefore() {
        matchScores = new MatchScores();
        matchScore1 = new MatchScore(110, 90);
        matchScore2 = new MatchScore(80, 100);
        matchScore3 = new MatchScore(97, 89);
    }

    @Test
    void testConstructor() {
        assertFalse(matchScores.containsScore(matchScore1));
        assertEquals(0, matchScores.getNumberOfMatchScores());
    }

    @Test
    void testAddMultipleMatchScores() {
        matchScores.addMatchScore(matchScore1);
        matchScores.addMatchScore(matchScore2);

        assertTrue(matchScores.containsScore(matchScore2));
        assertFalse(matchScores.containsScore(matchScore3));
        assertEquals(2, matchScores.getNumberOfMatchScores());
    }

}
