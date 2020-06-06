package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Controller {

    private String login = "abc";
    private String haslo = "123";

    @FXML
    Button helpButton;
    @FXML
    Button startApp;
    @FXML
    TextField loginField;
    @FXML
    PasswordField password;
    @FXML
    Label notif;
    @FXML
    AnchorPane rootPane;

    public void helpButtonAction(javafx.event.ActionEvent event) throws IOException {
        File file = new File("C:\\Users\\PC\\Desktop\\Studia\\Java programowanie\\AppProjectRebuild\\src\\sample\\help.txt");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    public void startButtonAction(javafx.event.ActionEvent event) throws IOException {
        if(loginField.getText().equals(login) && password.getText().equals(haslo)) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            rootPane.getChildren().setAll(pane);

        }
        else notif.setText("Błąd logowania");
    }

}
