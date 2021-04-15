package Controllers;

import Tools.Con;
import Tools.Window;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConnectionController {

    private final Window wn = new Window();

    private final Con c = new Con();

    @FXML
    public TextField direccionBD;
    @FXML
    public TextField passwordBD;
    @FXML
    public TextField usuarioBD;
    @FXML
    private AnchorPane connectionPane;
    @FXML
    public Button regresarButton;

    /**
     * Método que regresa a la página de log in
     */
    public void regresarOnAction() {
        try {
            wn.changeStage(connectionPane,"/GUI/LogInScreen.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que guarda los datos que conectan a la BD
     */
    public void guardarOnAction() {
        if(direccionBD.getText().isEmpty() || passwordBD.getText().isEmpty() || usuarioBD.getText().isEmpty()){
            wn.popUpMessage("Llenar todos los campos","Todos los campos tienen que estar llenos.");
        }
        else{

            c.setUSER(usuarioBD.getText());
            c.setPASS(passwordBD.getText());
            c.setAddress(direccionBD.getText());
            wn.popUpMessage("Guardado","Los datos fueron guardados correctamente");
        }
    }
}
