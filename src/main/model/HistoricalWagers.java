package model;

import java.util.ArrayList;

// List of previous wagers
public class HistoricalWagers {
    ArrayList<String> pastWagers;

    public HistoricalWagers() {
        pastWagers = new ArrayList<>();
    }

    public void addWager(String wager) {
        pastWagers.add(wager);
    }

    public Integer getNumberOfPreviousWagers() {
        return pastWagers.size();
    }

    public String linesOfWagers() {
        String wagerLines = "";

        if (pastWagers.size() > 0) {
            for (String wager: pastWagers) {
                wagerLines = wagerLines + wager + "\n";
            }

            return wagerLines;
        }

        return "No wagers placed in the past";
    }

}
