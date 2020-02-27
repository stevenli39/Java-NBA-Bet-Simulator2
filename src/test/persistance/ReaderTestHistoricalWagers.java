package persistance;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTestHistoricalWagers {

    @Test
    void testConstructor() {
        Reader reader;
        reader = new Reader();

        assertEquals(false, reader.equals(2));
    }

    @Test
    void testParseHistoricalWagersFile1() {
        try {
            List<String> pastWagers =
                    Reader.readFile(new File("./data/testHistoricalWagers1"));
            assertEquals("Raptors vs. Lakers, $500", pastWagers.get(0));
            assertEquals("Kings vs. Blazers, $400", pastWagers.get(1));
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


