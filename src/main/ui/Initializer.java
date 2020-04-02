package ui;

import model.Account;
import model.HistoricalWagers;
import persistance.Reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Initializer {

    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private static final String HISTORICAL_FILE = "./data/historicalWagers.txt";

    HistoricalWagers pastWagers;
    Account account;


    public Initializer() {
    }

    public void loadHistoricalWagers(HistoricalWagers hw) {
        try {
            List<String> historicalWagers = Reader.readFile(new File(HISTORICAL_FILE));
            for (String i : historicalWagers) {
                hw.addWager(i);
            }
        } catch (IOException e) {
            initHistoricalWagers();
        }
    }

    public void initHistoricalWagers() {
        pastWagers = new HistoricalWagers();
    }

    public void loadAccounts(Account acc) {
        try {
            List<Account> accounts = Reader.readAccounts(new File(ACCOUNTS_FILE));
            acc.changeBalance(accounts.get(0).getBalance());
        } catch (IOException e) {
            initAccounts();
        }
    }

    public void initAccounts() {
        account = new Account(200);
    }

}
