package Tools;

import javafx.animation.ParallelTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Window {
    public void changeStage(Pane currentPane, String nextStage) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource(nextStage));
        ParallelTransition logInPane;
        currentPane.getChildren().setAll(pane);
    }
}
