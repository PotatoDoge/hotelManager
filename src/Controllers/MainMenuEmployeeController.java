package Controllers;

import Tools.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuEmployeeController implements Initializable {

    private final Window wn = new Window();
    @FXML
    private TextField nombreHuespedID;
    @FXML
    private TextField aPHuespedID;
    @FXML
    private TextField aMHuespedId;
    @FXML
    private TextField telHuespedID;
    @FXML
    private TextField nacionalidadID;
    @FXML
    private Button guardarHuesped;
    @FXML
    private AnchorPane mainMenuPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        esconderElementosEnPantalla();
    }

    public void salirOnAction() {
        try {
            wn.changeStage(mainMenuPane,"/GUI/LogInScreen.fxml");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void nuevoHuespedOnAction() {
        esconderElementosEnPantalla();
        nombreHuespedID.setVisible(true);
        aPHuespedID.setVisible(true);
        aMHuespedId.setVisible(true);
        telHuespedID.setVisible(true);
        nacionalidadID.setVisible(true);
        guardarHuesped.setVisible(true);
    }

    public void guardarHuespedOnAction() {

    }

    public void esconderElementosEnPantalla(){
        nombreHuespedID.setVisible(false);
        aPHuespedID.setVisible(false);
        aMHuespedId.setVisible(false);
        telHuespedID.setVisible(false);
        nacionalidadID.setVisible(false);
        guardarHuesped.setVisible(false);
    }


}
