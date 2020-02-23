package persistance;

import model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testAccounts.txt";
    private Writer testWriter;
    private Account account;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        account = new Account(200);
    }

    @Test
    void testWriteAccounts() {
        // save account to file
        testWriter.write(account);
        testWriter.close();

        try {
            List<Account> accounts = Reader.readAccounts(new File(TEST_FILE));
            Account account = accounts.get(0);
            assertEquals(200, account.getBalance());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

}



