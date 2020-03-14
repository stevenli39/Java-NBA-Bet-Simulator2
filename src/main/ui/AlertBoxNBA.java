package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class AlertBoxNBA {

    public static void display(String tittle, String message) throws URISyntaxException, IOException {
        Stage window = new Stage();

        Desktop d = Desktop.getDesktop();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(tittle);
        window.setMinWidth(500);

        Label label = new Label();
        label.setText(message);
        Button linkButton = new Button("Go");
        linkButton.setOnAction(e -> {
            try {
                d.browse(new URI("https://ca.nba.com/?gr=www"));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, linkButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }


}
