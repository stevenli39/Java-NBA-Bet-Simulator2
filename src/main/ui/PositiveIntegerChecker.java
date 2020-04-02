package ui;

import javafx.scene.control.TextField;

public class PositiveIntegerChecker {


    public PositiveIntegerChecker() {
    }

    public Boolean checkPositiveInteger(TextField input, String message) {
        try {
            int betAmount = Integer.parseInt(input.getText());
            if (betAmount > 0) {
                return true;
            }

            return false;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not an Integer");
            return false;
        }
    }
}

