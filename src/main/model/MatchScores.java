package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MatchScores {
    ArrayList<MatchScore> matchScores;

    public MatchScores() {
        matchScores = new ArrayList<>();
    }

    // REQUIRES: match scores must both be positive Integers and can not be equal to each other
    // MODIFIES: this
    // EFFECTS: Adds a finished match's score
    public void addMatchScore(MatchScore ms) {
        matchScores.add(ms);
    }

    public Boolean containsScore(MatchScore ms) {
        return matchScores.contains(ms);
    }

    public Integer getNumberOfMatchScores() {
        return matchScores.size();
    }

    public String linesOfMatchScores() {
        String matchLines = "";

        if (matchScores.size() > 0) {
            for (MatchScore m : matchScores) {
                matchLines = matchLines + m.getScore1() + " vs. " + m.getScore2() + "\n";
            }

            return matchLines;
        }

        return "No matches today";
    }
}



