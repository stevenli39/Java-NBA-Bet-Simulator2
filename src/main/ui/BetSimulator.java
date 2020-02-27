package ui;

import model.*;
import persistance.Reader;
import persistance.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

public class BetSimulator {
    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private static final String HISTORICAL_FILE = "./data/historicalWagers.txt";
    private Account account;
    private HistoricalWagers pastWagers;
    private Match match1;
    private Match match2;
    private Matches matches;
    private Scanner input;


    public BetSimulator() {
        runBet();
    }

    private void runBet() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        pastWagers = new HistoricalWagers();
        account = new Account(400);
        matches = new Matches();

        match1 = new Match("Raptors", "Lakers");
        match2 = new Match("Kings", "Blazers");

        matches.addMatch(match1);
        matches.addMatch(match2);

        loadAccounts();
        loadHistoricalWagers();

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


    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tb -> place a bet");
        System.out.println("\tc -> check balance");
        System.out.println("\ta -> add balance");
        System.out.println("\th -> view historical bets");
        System.out.println("\ts -> save account to file");
        System.out.println("\tsh -> save HistoricalWagers to file");
        System.out.println("\tq -> quit");
    }

    private void processCommand(String command) {
        if (command.equals("b")) {
            bet();
        } else if (command.equals("c")) {
            System.out.println("Your balance is currently " + account.getBalance());
        } else if (command.equals("a")) {
            addMoney();
        } else if (command.equals("s")) {
            saveAccounts();
        } else if (command.equals("sh")) {
            saveHistoricalWagers();
        } else if (command.equals("h")) {
            System.out.println(pastWagers.linesOfWagers());
        } else {
            System.out.println("Selection is not valid...");
        }
    }

    private void loadAccounts() {
        try {
            List<Account> accounts = Reader.readAccounts(new File(ACCOUNTS_FILE));
            account = accounts.get(0);
        } catch (IOException e) {
            initAccounts();
        }
    }

    private void initAccounts() {
        account = new Account(200);
    }


    private void loadHistoricalWagers() {
        try {
            List<String> historicalWagers = Reader.readHistoricalWagers(new File(HISTORICAL_FILE));
            for (String i: historicalWagers) {
                pastWagers.addWager(i);
            }
        } catch (IOException e) {
            initHistoricalWagers();
        }
    }

    private void initHistoricalWagers() {
        pastWagers = new HistoricalWagers();
    }

    private void saveAccounts() {
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(account);
            writer.close();
            System.out.println("Accounts saved to file" + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to file" + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    private void saveHistoricalWagers() {
        try {
            Writer writer = new Writer(new File(HISTORICAL_FILE));
            writer.write(pastWagers);
            writer.close();
            System.out.println("HistoricalWagers saved to file" + HISTORICAL_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save HistoricalWagers to file" + HISTORICAL_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    private void bet() {
        System.out.println("Which match would you like to bet on?");
        matches.linesOfMatches();
        System.out.println("Type 1 for Raptors vs. Lakers" + "\n" + "Type 2 for Kings vs. Blazers");
        Integer matchChosen = input.nextInt();

        if (matchChosen == 1) {
            betMatch1();
        } else if (matchChosen == 2) {
            betMatch2();
        } else {
            System.out.println("Please enter a valid match");
        }
    }

    private void betMatch1() {
        System.out.println("Which team would you like to wager on, type 1 for raptors and 2 for lakers ");
        Integer teamChosen = input.nextInt();

        if (teamChosen == 1) {
            betRaptors();
        } else if (teamChosen == 2) {
            betLakers();
        } else {
            System.out.println("Please enter a valid team");
        }
    }

    private void betRaptors() {
        System.out.println("How much do you want to wager, Please enter a positive Integer");
        Integer wagerAmount = input.nextInt();
        if (account.getBalance() > wagerAmount) {
            System.out.println("Your wager has been successfully placed");
            System.out.println("Raptors won 119-110 against the Lakers");
            System.out.println("You have doubled your wager");
            account.addBalance(wagerAmount);

            pastWagers.addWager("Raptors vs. Lakers, $" + wagerAmount);
        } else {
            System.out.println("You do not have enough money");
        }
    }

    private void betLakers() {
        System.out.println("How much do you want to wager, Please enter a positive Integer");
        Integer wagerAmount = input.nextInt();
        if (account.getBalance() > wagerAmount) {
            System.out.println("Your wager has been successfully placed");
            System.out.println("Lakers lost 110-119 against the Raptors");
            System.out.println("You have lost all of your wager");
            account.subtractBalance(wagerAmount);

            pastWagers.addWager("Raptors vs. Lakers, $" + wagerAmount);
        } else {
            System.out.println("You do not have enough money");
        }
    }

    private void betMatch2() {
        System.out.println("Which team would you like to wager on, 1 for Kings and 2 for Blazers");
        Integer teamChosen = input.nextInt();

        if (teamChosen == 1) {
            betKings();
        } else if (teamChosen == 2) {
            betBlazers();
        } else {
            System.out.println("Please enter a valid team");
        }
    }

    private void betKings() {
        System.out.println("How much do you want to wager, Please enter a positive Integer");
        Integer wagerAmount = input.nextInt();
        if (account.getBalance() > wagerAmount) {
            System.out.println("Your wager has been successfully placed");
            System.out.println("Kings lost 101-120 against to the Blazers");
            System.out.println("You have lost all of your wager");
            account.subtractBalance(wagerAmount);

            pastWagers.addWager("Kings vs. Blazers, $" + wagerAmount);
        } else {
            System.out.println("You do not have enough money");
        }

    }

    private void betBlazers() {
        System.out.println("How much do you want to wager, Please enter a positive Integer");
        Integer wagerAmount = input.nextInt();
        if (account.getBalance() > wagerAmount) {
            System.out.println("Your wager has been successfully placed");
            System.out.println("Blazers won 120-101 against to the Blazers");
            System.out.println("You have doubled your wager");
            account.addBalance(wagerAmount);

            pastWagers.addWager("Kings vs. Blazers, $" + wagerAmount);
        } else {
            System.out.println("You do not have enough money");
        }
    }

    private void addMoney() {
        System.out.println("How much money would you like you to add to your balance, Enter a positive Integer");
        Integer amount = input.nextInt();

        account.addBalance(amount);
        System.out.println("$" + amount + " has been successfully added to your account");
    }


}
