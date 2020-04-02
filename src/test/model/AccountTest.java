package model;

import exceptions.NegativeAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @BeforeEach
    void runBefore() {
        account = new Account(0);
    }

    @Test
    void testConstructor() {
        assertEquals(0, account.getBalance());
    }

    @Test
    void testAddBalanceNoException() {
        try {
            account.addBalance(20);
        } catch (NegativeAmount negativeAmount) {
            fail();
        }

        assertEquals(20, account.getBalance());
    }

    @Test
    void testAddBalanceExceptionThrown() {
        try {
            account.addBalance(-20);
            fail();
        } catch (NegativeAmount negativeAmount) {
            // Expected to catch this exception
        }

    }


    @Test
    void testSubtractBalanceNoException() {
        try {
            account.addBalance(30);
        } catch (NegativeAmount negativeAmount) {
            fail();
        }
        try {
            account.subtractBalance(20);
        } catch (NegativeAmount negativeAmount) {
            fail();
        }

        assertEquals(10, account.getBalance());
    }

    @Test
    void testSubtractBalanceExceptionThrown() {
        try {
            account.addBalance(30);
        } catch (NegativeAmount negativeAmount) {
            fail();
        }
        try {
            account.subtractBalance(-20);
            fail();
        } catch (NegativeAmount negativeAmount) {
            // Expected to catch this exception
        }
    }

    @Test
    void testChangeBalance() {
        account.changeBalance(40);

        assertEquals(40, account.getBalance());
    }
}