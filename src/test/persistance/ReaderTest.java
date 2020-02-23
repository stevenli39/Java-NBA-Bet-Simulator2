package persistance;

import model.Account;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {
    @Test
    void testParseAccountsFile1() {
        try {
            List<Account> accounts = Reader.readAccounts(new File("./data/testAccountFile1.txt"));
            Account account = accounts.get(0);
            assertEquals(200, account.getBalance());

            Account nextAccount = new Account(500);
            assertEquals(500, nextAccount.getBalance());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseAccountsFile2() {
        try {
            List<Account> accounts = Reader.readAccounts(new File("./data/testAccountFile2.txt"));
            Account account = accounts.get(0);
            assertEquals(300, account.getBalance());

            Account nextAccount = new Account(400);
            assertEquals(400, nextAccount.getBalance());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


    @Test
    void testIOException() {
        try {
            Reader.readAccounts(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
