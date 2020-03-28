package ui;


import exceptions.NegativeAmount;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Account;
import model.HistoricalWagers;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import persistance.Reader;
import persistance.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class UI extends Application {

    private static final String ACCOUNTS_FILE = "./data/accounts.txt";
    private static final String HISTORICAL_FILE = "./data/historicalWagers.txt";
    private static final String musicFile = "BallinlikeCurryTikTokMeme.mp4";
    private static final String musicFileClean = "Ballin'LikeCurry(Clean).mp4";

    Button msButton1 = new Button();
    Button msButton2 = new Button();
    Button msButton3 = new Button();
    Button msButton4 = new Button();
    Button msButton5 = new Button();
    Button betSceneButton1 = new Button();
    Button betSceneButton2 = new Button();
    Button betSceneButton3 = new Button();
    Button rvlButton1 = new Button();
    Button rvlButton2 = new Button();
    Button kvbButton1 = new Button();
    Button kvbButton2 = new Button();
    Button rvlBetButton1 = new Button();
    Button rvlBetButton2 = new Button();
    Button kvbBetButton1 = new Button();
    Button kvbBetButton2 = new Button();
    Button accountButton2 = new Button();
    Button accountButton = new Button();
    Button accountButton3 = new Button();
    Stage window;
    Scene mainScene;
    Scene betScene;
    Scene rvlBetScene;
    Scene kvbBetScene;
    Scene rvlScene;
    Scene kvbScene;
    Scene accountScene;
    Scene scene8;
    VBox layout5;
    HistoricalWagers pastWagers = new HistoricalWagers();
    ArrayList<Label> labelList = new ArrayList<>();
    Account account = new Account(0);
    MediaPlayer mediaPlayer;
    Image image;
    ImageView iv;
    GridPane rvlGrid;
    GridPane kvbGrid;
    GridPane accountGrid;
    Label rvlAmountLabel;
    Label kvbAmountLabel2;
    Label accountAmount1;
    Label balanceLabel4;
    TextField rvlAmountInput;
    TextField kvbAmountInput2;
    TextField accountInput1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        loadHistoricalWagers();
        loadAccounts();
        programImage();
        programSound();
        mainScreenButtons();
        mainScreenButtonFunctions();
        mainScreenLayout();
        betSceneLayout();
        raptorsVLakers();
        kingsVBlazers();
        raptorsVLakersBetGrid();
        raptorsVLakersBetButtons();
        raptorsVLakersBetScene();
        kingsVBlazersBetGrid();
        kingsVBlazersBetButtons();
        kingsVBlazersBetScene();
        accountFunctionsGrid();
        accountButtonAddBalance();
        accountButtonSubtractBalance();
        accountScene();
        mainScreenInitialization();
        producePastWagerLabels();
    }

    private void closeProgram() {
        saveHistoricalWagers();
        saveAccounts();
        window.close();
    }

    private void saveAccounts() {
        try {
            Writer writer = new Writer(new File(ACCOUNTS_FILE));
            writer.write(account);
            writer.close();
            System.out.println("Accounts saved to file" + ACCOUNTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to file" + ACCOUNTS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    private void saveHistoricalWagers() {
        try {
            Writer writer = new Writer(new File(HISTORICAL_FILE));
            writer.write(pastWagers);
            writer.close();
            System.out.println("HistoricalWagers saved to file" + HISTORICAL_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save HistoricalWagers to file" + HISTORICAL_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    private Boolean isPositiveInt(TextField input, String message) {
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

    private void loadHistoricalWagers() {
        try {
            List<String> historicalWagers = Reader.readFile(new File(HISTORICAL_FILE));
            for (String i : historicalWagers) {
                pastWagers.addWager(i);
            }
        } catch (IOException e) {
            initHistoricalWagers();
        }
    }

    private void initHistoricalWagers() {
        pastWagers = new HistoricalWagers();
    }

    private void loadAccounts() {
        try {
            List<Account> accounts = Reader.readAccounts(new File(ACCOUNTS_FILE));
            account = accounts.get(0);
        } catch (IOException e) {
            initAccounts();
        }
    }

    private void initAccounts() {
        account = new Account(200);
    }

    private void producePastWagerLabels() {
        if (pastWagers.getNumberOfPreviousWagers() > 0) {
            for (int i = 0; i < pastWagers.getNumberOfPreviousWagers(); i++) {
                labelList.add(new Label(pastWagers.getWager(i)));
            }
        }
    }

    private void addLabelToLayout() {
        if (labelList.size() > 0) {
            for (Label l : labelList) {
                layout5.getChildren().addAll(l);
            }
        }
    }

    private void programSound() {
        Media sound = new Media(new File(musicFileClean).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(10);
        mediaPlayer.setVolume(1.0);
    }

    private void programImage() {
        image = new Image("file:Michael_Jordan_crying.jpg");
        iv = new ImageView();
        iv.setFitWidth(500);
        iv.setFitHeight(350);
        iv.setImage(image);
    }

    private void mainScreenButtons() {
        msButton1.setText("Place A Bet");
        msButton2.setText("Account");
        msButton3.setText("Past Wagers Record");
        msButton4.setText("Quit and Save");
        msButton5.setText("NBA Website");
    }

    private void mainScreenButtonFunctions() {
        msButton1.setOnAction(e -> window.setScene(betScene));
        msButton2.setOnAction(e -> window.setScene(accountScene));
        msButton3.setOnAction(e -> {
            layout5 = new VBox(20);
            layout5.setAlignment(Pos.CENTER);
            layout5.getChildren().add(rvlBetButton1);
            addLabelToLayout();
            scene8 = new Scene(layout5, 500, 300);
            window.setScene(scene8);
        });
        msButton4.setOnAction(e -> closeProgram());
        msButton5.setOnAction(e -> {
            try {
                AlertBoxNBA.display("NBA Website Redirect",
                        "Click 'Go' to be redirected to the NBA website");
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void mainScreenLayout() {
        StackPane layout = new StackPane();
        layout.getChildren().addAll(iv, msButton1, msButton2, msButton3, msButton5, msButton4);
        msButton1.setTranslateY(-150.0);
        msButton2.setTranslateY(-70.0);
        msButton5.setTranslateY(75.0);
        msButton4.setTranslateY(150.0);
        mainScene = new Scene(layout, 500, 350);
    }

    private void betSceneLayout() {
        betSceneButton1.setText("Back");
        betSceneButton2.setText("Raptors vs. Lakers");
        betSceneButton3.setText("Kings vs. Blazers");
        betSceneButton1.setOnAction(e -> window.setScene(mainScene));
        betSceneButton2.setOnAction(e -> window.setScene(rvlScene));
        betSceneButton3.setOnAction((e -> window.setScene(kvbScene)));

        VBox layout2 = new VBox(30);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(betSceneButton2, betSceneButton3, betSceneButton1);
        betScene = new Scene(layout2, 500, 350);
    }

    private void raptorsVLakers() {
        rvlButton1.setText("Raptors");
        rvlButton2.setText("Lakers");

        rvlButton1.setOnAction(e -> window.setScene(rvlBetScene));
        rvlButton2.setOnAction(e -> window.setScene(rvlBetScene));

        VBox layout3 = new VBox(20);
        layout3.setAlignment(Pos.CENTER);
        layout3.getChildren().addAll(rvlButton1, rvlButton2, rvlBetButton1);
        rvlScene = new Scene(layout3, 500, 350);
    }

    private void kingsVBlazers() {
        kvbButton1.setText("Kings");
        kvbButton2.setText("Blazers");
        kvbButton1.setOnAction(e -> window.setScene(kvbBetScene));
        kvbButton2.setOnAction(e -> window.setScene(kvbBetScene));

        VBox layout4 = new VBox(20);
        layout4.setAlignment(Pos.CENTER);
        layout4.getChildren().addAll(kvbButton1, kvbButton2, rvlBetButton1);
        kvbScene = new Scene(layout4, 500, 350);
    }

    private void raptorsVLakersBetGrid() {
        rvlGrid = new GridPane();
        rvlGrid.setPadding(new Insets(10, 10, 10, 10));
        rvlGrid.setVgap(10.0);
        rvlGrid.setHgap(15.0);

        // Amount Label
        rvlAmountLabel = new Label("Amount:");
        GridPane.setConstraints(rvlAmountLabel, 0, 0);

        // Amount Input
        rvlAmountInput = new TextField();
        rvlAmountInput.setPromptText("5000");
        GridPane.setConstraints(rvlAmountInput, 1, 0);
    }

    private void raptorsVLakersBetButtons() {
        rvlBetButton1.setText("Back to Main Menu");
        rvlBetButton1.setOnAction(e -> window.setScene(mainScene));
        rvlBetButton2.setText("Bet");
        rvlBetButton2.setOnAction(e -> {
            if (isPositiveInt(rvlAmountInput, rvlAmountInput.getText())) {
                pastWagers.addWager("Raptors vs. Lakers " + rvlAmountInput.getText());
                Label l = new Label("Raptors vs. Lakers " + rvlAmountInput.getText());
                labelList.add(l);
                window.setScene(mainScene);
                AlertBoxMessage.display("Confirmation", "Your Bet Has Been Placed!");
            } else if (!isPositiveInt(rvlAmountInput, rvlAmountInput.getText())) {
                AlertBoxMessage.display("Field Error", "Please enter an Integer");
            }
        });
    }

    private void raptorsVLakersBetScene() {
        GridPane.setConstraints(rvlBetButton1, 1, 5);
        GridPane.setConstraints(rvlBetButton2, 1, 1);

        rvlGrid.getChildren().addAll(rvlAmountLabel, rvlAmountInput, rvlBetButton1, rvlBetButton2);
        rvlBetScene = new Scene(rvlGrid, 500, 350);
    }

    private void kingsVBlazersBetGrid() {
        kvbGrid = new GridPane();
        kvbGrid.setPadding(new Insets(10, 10, 10, 10));
        kvbGrid.setVgap(10.0);
        kvbGrid.setHgap(15.0);

        // Amount Label
        kvbAmountLabel2 = new Label("Amount:");
        GridPane.setConstraints(kvbAmountLabel2, 0, 0);

        // Amount Input
        kvbAmountInput2 = new TextField();
        kvbAmountInput2.setPromptText("5000");
        GridPane.setConstraints(kvbAmountInput2, 1, 0);
    }

    private void kingsVBlazersBetButtons() {
        kvbBetButton1.setText("Back to Main Menu");
        kvbBetButton1.setOnAction(e -> window.setScene(mainScene));
        kvbBetButton2.setText("Bet");
        kvbBetButton2.setOnAction(e -> {
            if (isPositiveInt(kvbAmountInput2, kvbAmountInput2.getText())) {
                pastWagers.addWager("Kings vs. Blazers " + kvbAmountInput2.getText());
                Label l = new Label("Kings vs. Blazers " + kvbAmountInput2.getText());
                labelList.add(l);
                window.setScene(mainScene);
                AlertBoxMessage.display("Confirmation", "Your Bet Has Been Placed!");
            } else if (!isPositiveInt(kvbAmountInput2, kvbAmountInput2.getText())) {
                AlertBoxMessage.display("Field Error", "Please Enter an Integer!");
            }
        });
    }

    private void kingsVBlazersBetScene() {
        GridPane.setConstraints(kvbBetButton1, 1, 9);
        GridPane.setConstraints(kvbBetButton2, 1, 1);

        kvbGrid.getChildren().addAll(kvbAmountLabel2, kvbAmountInput2, kvbBetButton1, kvbBetButton2);
        kvbBetScene = new Scene(kvbGrid, 500, 350);
    }

    private void accountFunctionsGrid() {
        accountGrid = new GridPane();
        accountGrid.setPadding(new Insets(10, 10, 10, 10));
        accountGrid.setVgap(10.0);
        accountGrid.setHgap(15.0);

        accountAmount1 = new Label("Amount:");
        GridPane.setConstraints(accountAmount1, 0, 0);

        accountInput1 = new TextField();
        accountInput1.setPromptText("5000");
        GridPane.setConstraints(accountInput1, 1, 0);

        balanceLabel4 = new Label();
        balanceLabel4.setText("Your balance is: " + "$ " + account.getBalance());
    }

    private void accountButtonAddBalance() {
        accountButton.setText("Add Amount");
        accountButton2.setText("Back to Main Menu");
        accountButton2.setOnAction(e -> window.setScene(mainScene));
        accountButton.setOnAction(e -> {
            if (isPositiveInt(accountInput1, accountInput1.getText())) {
                try {
                    account.addBalance(Integer.parseInt(accountInput1.getText()));
                } catch (NegativeAmount negativeAmount) {
                    negativeAmount.printStackTrace();
                }
                window.setScene(mainScene);
                balanceLabel4.setText("Your balance is: " + "$ " + account.getBalance());
                AlertBoxMessage.display("Confirmation",
                        "$ " + accountInput1.getText() + " has been added to your account!");
            } else if (!isPositiveInt(accountInput1, accountInput1.getText())) {
                AlertBoxMessage.display("Field Error", "Please Enter an Integer!");
            }
        });
    }

    private void accountButtonSubtractBalance() {
        accountButton3.setText("Withdrawal");
        accountButton3.setOnAction(e -> {
            if ((isPositiveInt(accountInput1, accountInput1.getText()))
                    && (account.getBalance() > (Integer.parseInt(accountInput1.getText())))) {
                try {
                    account.subtractBalance((Integer.parseInt(accountInput1.getText())));
                } catch (NegativeAmount negativeAmount) {
                    negativeAmount.printStackTrace();
                }
                window.setScene(mainScene);
                balanceLabel4.setText("Your balance is: " + "$" + account.getBalance());
                AlertBoxMessage.display("Confirmation",
                        "$ " + accountInput1.getText() + " has been withdrawn from your account!");
            } else if (isPositiveInt(accountInput1, accountInput1.getText())) {
                AlertBoxMessage.display("Field Error", "Enter a positive Integer \n"
                        + "You do not have sufficient balance");
            }
        });
    }

    private void accountScene() {
        GridPane.setConstraints(accountButton, 1, 1);
        GridPane.setConstraints(balanceLabel4, 1, 3);
        GridPane.setConstraints(accountButton2, 1, 5);
        GridPane.setConstraints(accountButton3, 1, 2);
        accountGrid.getChildren().addAll(accountAmount1, accountButton, accountButton2, accountButton3,
                accountInput1, balanceLabel4);
        accountScene = new Scene(accountGrid, 500, 350);
    }

    private void mainScreenInitialization() {
        window.setOnCloseRequest(e -> closeProgram());
        window.setScene(mainScene);
        window.setTitle("Welcome to Sports Gambling Simulator");
        window.show();
    }
}
