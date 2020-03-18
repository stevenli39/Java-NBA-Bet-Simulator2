package model;

import persistance.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

// List of previous wagers
public class HistoricalWagers implements Saveable {
    ArrayList<String> pastWagers;

    public HistoricalWagers() {
        pastWagers = new ArrayList<>();
    }

    public void addWager(String wager) {
        pastWagers.add(wager);
    }

    // EFFECTS: checks if the list of historicalwagers includes the wager
    public Boolean containsWager(String w) {
        return pastWagers.contains(w);
    }

    public String getWager(Integer i) {
        return pastWagers.get(i);
    }

    public Integer getNumberOfPreviousWagers() {
        return pastWagers.size();
    }

    // EFFECTS: prints out the lines of wagers
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

    @Override
    public void save(PrintWriter printWriter) {
        for (String i: pastWagers) {
            printWriter.print(i);
            printWriter.print("\n");
        }
    }
}
