package ui;

import model.*;

import java.util.Scanner;

public class BetSimulator {
    Account userBalance;
    HistoricalWagers pastWagers;
    Match match1;
    Match match2;
    Matches matches;
    MatchScores matchScores;
    Wager wager;
    private Scanner input;


    public BetSimulator() {
        runBetSimulator();
    }

    public void runBetSimulator() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        loadMatches();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }


    }

    private void loadMatches() {
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tb -> place a bet");
        System.out.println("\tc -> check balance");
        System.out.println("\ta -> add balance");
        System.out.println("\th -> view historical bets");
        System.out.println("\tq -> quit");
    }

    private void processCommand(String command) {
        if (command.equals("b")) {
            bet();
        }
    }

    private void bet() {
        System.out.println("Which match would you like to bet on?");


    }


}
