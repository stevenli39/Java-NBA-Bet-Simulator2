package persistance;

import model.Account;
import model.HistoricalWagers;
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
    private static final String TEST_FILE2 = "./data/testHistoricalWagers1";
    private Writer testWriter;
    private Writer testWriter2;
    private Account account;
    private HistoricalWagers pastWagers;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        testWriter2 = new Writer(new File(TEST_FILE2));
        account = new Account(200);
        pastWagers = new HistoricalWagers();
        pastWagers.addWager("Raptors vs. Lakers, $500");
        pastWagers.addWager("Kings vs. Blazers, $400");
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

    @Test
    void testWriteHistoricalWagers() {
        // save pastWagers to file
        testWriter2.write(pastWagers);
        testWriter2.close();

        try {
            List<String> historicalWagers = Reader.readFile(new File(TEST_FILE2));
            assertEquals("Raptors vs. Lakers, $500", historicalWagers.get(0));
            assertEquals("Kings vs. Blazers, $400", historicalWagers.get(1));
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}



