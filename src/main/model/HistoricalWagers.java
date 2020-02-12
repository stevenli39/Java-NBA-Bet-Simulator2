package model;

import java.util.ArrayList;

// List of previous wagers
public class HistoricalWagers {
    ArrayList<Wager> pastWagers;

    public HistoricalWagers() {
        pastWagers = new ArrayList<>();
    }

    public void addWager(Wager wager) {
        pastWagers.add(wager);
    }

    public Integer getNumberOfPreviousWagers() {
        return pastWagers.size();
    }

}
