package persistance;

import model.Account;
import model.HistoricalWagers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = ",";

    public Reader() {
    }

    // EFFECTS returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Account> readAccounts(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: return the content of the file as a string, representing
    // the data for the account saved 
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of account balances parsed from list of strings
    // where each string contains data for one account
    private static List<Account> parseContent(List<String> fileContent) {
        List<Account> accounts = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            accounts.add(parseAccount(lineComponents));
        }

        return accounts;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 1 where element 0 represents
    // the balance of the account to be constructed
    // EFFECTS: returns an account constructed from components
    private static Account parseAccount(List<String> components) {
        int balance = Integer.parseInt(components.get(0));
        return new Account(balance);
    }

    public static List<String> readHistoricalWagers(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseHistoricalWagersContent(fileContent);
    }

    private static List<String> parseHistoricalWagersContent(List<String> fileContent) {
        List<String> pastWagers = new ArrayList<>();

        for (String line : fileContent) {
            pastWagers.add(line);
        }
        return pastWagers;
    }

}
