package Controllers;
import Tools.Con;
import Tools.Window;
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

    private final Con c = new Con();

    /**
     * Método que camia la escena cuando el botón de settings es picado
     */
    public void settingsOnAction() {
        try {
            wn.changeStage(logInPane,"/GUI/Connection.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se encarga de la lógica del log in
     */
    public void logInOnAction() {
        boolean logInAllowed = false;
        if(c.getPASS().equals("") || c.getUSER().equals("")|| c.getAddress().equals("")){
            wn.popUpMessage("Llenar campos","Todos los campos para conectar con la base de\ndatos tienen que haber sido llenados\nal menos una vez.");
        }
        else if(usernameTextArea.getText().isEmpty() || passwordTextArea.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","El usuario y contraseña de esta ventana deben\nestar llenos");
        }
        else{
            try{
                c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                String SQL = "SELECT * FROM users WHERE usr='" + usernameTextArea.getText() + "'";
                c.setPst(c.getConn().prepareStatement(SQL));
                ResultSet rs = c.getPst().executeQuery();
                while(rs.next()){
                    if(passwordTextArea.getText().equals(rs.getString("ps"))){
                        logInAllowed = true;
                        break;
                    }
                }
                c.getConn().close();
            }
            catch (Exception e){
                System.out.println("ERROR LOGIN");
                System.out.println(e);
            }
        }
        if(logInAllowed){
            try{
                wn.changeStage(logInPane, "/GUI/MainMenu.fxml");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            wn.popUpMessage("Datos incorrectos","Checar que el usuario y la contraseña\nsean correctos.");
        }
    }
}