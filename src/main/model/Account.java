package model;

import persistance.Saveable;

import java.io.PrintWriter;

// User's Account
public class Account implements Saveable {
    Integer balance;

    public Account(int balance) {
        this.balance = balance;
    }


    // REQUIRES: Amount must be a positive Integer
    // MODIFIES: this
    // EFFECTS: Add the amount onto the balance
    public void addBalance(Integer amount) {
        balance = balance + amount;
    }

    // REQUIRES: Balance must be larger than the amount being subtracted
    // MODIFIES: this
    // EFFECTS: Subtracts the amount from the balance
    public void subtractBalance(Integer amount) {
        balance = balance - amount;
    }

    public Integer getBalance() {
        return balance;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.println(balance);
    }
}
