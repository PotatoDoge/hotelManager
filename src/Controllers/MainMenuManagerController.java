package Controllers;

import Tools.Window;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainMenuManagerController {

    private final Window wn = new Window();
    @FXML
    private AnchorPane mainMenuPane;

    public void salirOnAction() {
        try {
            wn.changeStage(mainMenuPane,"/GUI/LogInScreen.fxml");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
