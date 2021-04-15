package Controllers;
import Tools.Con;
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

    private final Con c = new Con();

    public void settingsOnAction() {
        try {
            wn.changeStage(logInPane,"/GUI/Connection.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void logInOnAction() {
        if(c.getPASS().equals("") || c.getUSER().equals("")|| c.getAddress().equals("")){
            wn.popUpMessage("Llenar campos","Todos los campos para conectar con la base de\ndatos tienen que estar llenos.");
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
                        System.out.println("SI existe");
                        break;
                    }
                }
            }
            catch (Exception e){
                System.out.println(c.getUSER());
                System.out.println(c.getDB_URL());
                System.out.println(c.getPASS());
                System.out.println("ERROR LOGIN");
                System.out.println(e);
            }
        }
    }
}