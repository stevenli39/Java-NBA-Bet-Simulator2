package ui;

import persistance.Saveable;
import persistance.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Saver {

    // MODIFIES: data
    // EFFECTS: Saves the progress of the UI application from the given Saveable class and saves it to the given file
    public Saver() {
    }

    public void save(Saveable s, String file) {
        try {
            Writer writer = new Writer(new File(file));
            writer.write(s);
            writer.close();
            System.out.println("Accounts saved to file" + file);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to file" + file);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

}
