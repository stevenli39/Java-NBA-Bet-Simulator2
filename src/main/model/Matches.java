package model;

import java.util.ArrayList;

// List of current matches available to wager on
public class Matches {
    ArrayList<Match> matches;

    public Matches() {
        matches = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a match onto the list of matches
    public void addMatch(Match m) {
        matches.add(m);
    }

    public Integer getNumberOfMatches() {
        return matches.size();
    }

    // MODIFIES: this
    // EFFECTS: clears the list of matches
    public void clearMatches() {
        matches.clear();
    }

    // EFFECTS: checks if the list contains a match, returns true if found, false otherwise
    public Boolean containsMatch(Match m) {
        return matches.contains(m);
    }

}
