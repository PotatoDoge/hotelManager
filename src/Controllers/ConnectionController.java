package Controllers;

import Tools.ConTool;
import Tools.Window;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnectionController implements Initializable {

    private final Window wn = new Window();

    private final ConTool c = new ConTool();
    @FXML
    private Button nuevaID;
    @FXML
    private TextField nombreBD;
    @FXML
    private TextField direccionBD;
    @FXML
    private PasswordField passwordBD;
    @FXML
    private TextField usuarioBD;
    @FXML
    private AnchorPane connectionPane;
    @FXML
    private Button regresarButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

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
