package model;

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
    void testAddBalance() {
        account.addBalance(20);

        assertEquals(20, account.getBalance());
    }

    @Test
    void testSubtractBalance() {
        account.addBalance(30);
        account.subtractBalance(20);

        assertEquals(10, account.getBalance());
    }

}