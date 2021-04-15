package Tools;

import javafx.animation.ParallelTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Window {

    public void changeStage(Pane currentPane, String nextStage) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource(nextStage));
        ParallelTransition logInPane;
        currentPane.getChildren().setAll(pane);
    }

    public void popUpMessage(String header, String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
