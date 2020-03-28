package model;

import exceptions.NegativeAmount;
import persistance.Saveable;

import java.io.PrintWriter;

// User's Account
public class Account implements Saveable {
    Integer balance;

    public Account(int balance) {
        this.balance = balance;
    }



    // MODIFIES: this
    // EFFECTS: Add the amount onto the balance
    public void addBalance(Integer amount) throws NegativeAmount {
        if (!(amount > 0)) {
            throw new NegativeAmount();
        }
        balance = balance + amount;
    }


    // MODIFIES: this
    // EFFECTS: Subtracts the amount from the balance
    public void subtractBalance(Integer amount) throws NegativeAmount {
        if (!(amount > 0)) {
            throw new NegativeAmount();
        }
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
