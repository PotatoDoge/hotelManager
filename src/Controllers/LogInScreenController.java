package Controllers;
import Tools.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.*;


public class LogInScreenController {

    @FXML
    private Button settingsButton;
    @FXML
    private AnchorPane logInPane;
    @FXML
    private Button logInButton;
    @FXML
    private TextField usernameTextArea;
    @FXML
    private PasswordField passwordTextArea;

    private final Window wn = new Window();

    public void settingsOnAction(ActionEvent actionEvent) {
        try {
            wn.changeStage(logInPane,"/GUI/Connection.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}