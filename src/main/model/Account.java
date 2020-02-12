package model;

// User's Account
public class Account {
    Integer balance;

    public Account() {
        balance = 0;
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
}
