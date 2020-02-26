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

    @Override
    public void save(PrintWriter printWriter) {
        for (String i: pastWagers) {
            printWriter.print(i);
            printWriter.print("\n");
        }
    }
}
