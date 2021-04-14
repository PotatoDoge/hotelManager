package Controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.*;


public class LogInScreenController {

    @FXML
    private AnchorPane logInPane;
    @FXML
    private Button logInButton;
    @FXML
    private TextField usernameTextArea;
    @FXML
    private PasswordField passwordTextArea;

    static String SQLTable = "mysql"; // this is set to be changed to the db's name once the system checks if it exists

    static final String databaseName = "StorageManager"; // change to a valid db name

    // uncomment this so that the system can connect to the DB
    //static String DB_URL = "jdbc:mysql://localhost/"+SQLTable+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String USER = "root"; //change user to a valid one

    static final String PASS = ""; // change password to a valid one

    static Statement stmt = null;

    static Connection conn = null;

    static PreparedStatement pst = null;

}