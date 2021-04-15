package Controllers;

import Tools.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConnectionController {
    static final Window wn = new Window();
    @FXML
    private AnchorPane connectionPane;
    @FXML
    public Button regresarButton;

    public void regresarOnAction(ActionEvent actionEvent) {
        try {
            wn.changeStage(connectionPane,"/GUI/LogInScreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
