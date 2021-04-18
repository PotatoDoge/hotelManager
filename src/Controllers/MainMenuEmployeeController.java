package Controllers;

import Tools.ConTool;
import Tools.Window;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainMenuEmployeeController implements Initializable {

    private final Window wn = new Window();

    private  final ConTool c = new ConTool();
    @FXML
    private Button actualizarID;
    @FXML
    private Button buscarHuespedID;
    @FXML
    private TextField codigoClienteID;
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

    public void guardarHuespedOnAction() throws SQLException {
        if(!(nombreHuespedID.getText().isEmpty() && aPHuespedID.getText().isEmpty() && aMHuespedId.getText().isEmpty() && telHuespedID.getText().isEmpty() && nacionalidadID.getText().isEmpty())){
            if(nacionalidadID.getText().length() > 3){
                wn.popUpMessage("Editar campo","EL campo nacionalidad no puede\ncontener más e 3 caractere");
            }
            else if(telHuespedID.getText().length() > 20){
                wn.popUpMessage("Teléfono muy largo","EL número de teléfono no puede\nexceder de 20 números.");
            }
            else{
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    int n = generarNumeroCliente();
                    String codigo = "CL"+n;
                    c.getStmt().executeUpdate("INSERT INTO cliente(codigoCliente,nombre,telefono,nacionalidad,numVisitas,numCliente,primerApellido,segundoApellido) values('"+
                                                    codigo+"','"+nombreHuespedID.getText()+"','"+telHuespedID.getText()+"','"
                                                    +nacionalidadID.getText()+"',0,"+n+",'"+aPHuespedID.getText()+"','"+aMHuespedId.getText()+"')");
                    c.getConn().close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                wn.popUpMessage("Guardado con éxito","El huésped se registro con éxito.");
                nombreHuespedID.clear();
                aPHuespedID.clear();
                aMHuespedId.clear();
                telHuespedID.clear();
                nacionalidadID.clear();
                nombreHuespedID.setFocusTraversable(false);
                aPHuespedID.setFocusTraversable(false);
                aMHuespedId.setFocusTraversable(false);
                telHuespedID.setFocusTraversable(false);
                nacionalidadID.setFocusTraversable(false);
            }
        }
        else{
            wn.popUpMessage("Llenar campos","Todos los campos deben de estar llenos ");
        }
    }

    public void esconderElementosEnPantalla(){
        nombreHuespedID.setVisible(false);
        aPHuespedID.setVisible(false);
        aMHuespedId.setVisible(false);
        telHuespedID.setVisible(false);
        nacionalidadID.setVisible(false);
        buscarHuespedID.setVisible(false);
        codigoClienteID.setVisible(false);
        actualizarID.setVisible(false);
        guardarHuesped.setVisible(false);
    }

    public int generarNumeroCliente() throws SQLException {
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT * FROM cliente";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while(rst.next()){
            nc = rst.getInt("numCliente");
        }
        return nc+1;
    }

    public void editarHuespedOnAction() {
        esconderElementosEnPantalla();
        nombreHuespedID.setVisible(true);
        aPHuespedID.setVisible(true);
        aMHuespedId.setVisible(true);
        telHuespedID.setVisible(true);
        nacionalidadID.setVisible(true);
        buscarHuespedID.setVisible(true);
        codigoClienteID.setVisible(true);
        actualizarID.setVisible(true);
    }

    public void buscarHuespedOnAction() throws SQLException {
        boolean found = false;
        if(!buscarHuespedID.getText().isEmpty()){
            c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM cliente WHERE codigoCliente='" + codigoClienteID.getText() + "'";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while(rst.next()){
                System.out.println("EN EL WHILE");
                if(rst.getString("codigoCliente").equals(codigoClienteID.getText())){
                    found = true;
                    System.out.println("encontro");
                    nombreHuespedID.setText(rst.getString("nombre"));
                    aPHuespedID.setText(rst.getString("primerApellido"));
                    aMHuespedId.setText(rst.getString("segundoApellido"));
                    telHuespedID.setText(rst.getString("telefono"));
                    nacionalidadID.setText(rst.getString("nacionalidad"));
                    break;
                }
            }
            c.getConn().close();
            if(!found){
                wn.popUpMessage("Cliente no encontrado","El sistema no encontró al cliente con\nesa clave");
            }
        }
        else{
            wn.popUpMessage("Poner código de cliente","El campo del código de cliente debe de\n estar lleno para hacer una\nbúsqueda");
        }
    }

    public void actualizarOnAction() {
        if(!(nombreHuespedID.getText().isEmpty() && aPHuespedID.getText().isEmpty() && aMHuespedId.getText().isEmpty() && telHuespedID.getText().isEmpty() && nacionalidadID.getText().isEmpty())){
            if(nacionalidadID.getText().length() > 3){
                wn.popUpMessage("Editar campo","EL campo nacionalidad no puede\ncontener más de 3 caracteres");
            }
            else if(telHuespedID.getText().length() > 20){
                wn.popUpMessage("Teléfono muy largo","EL número de teléfono no puede\nexceder de 20 números.");
            }
            else{
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String sql="UPDATE cliente SET nombre='"+ nombreHuespedID.getText()+"',telefono='"+telHuespedID.getText()+"',nacionalidad='"+nacionalidadID.getText()
                                +"',primerApellido='"+aPHuespedID.getText()+"',segundoApellido='"+aMHuespedId.getText()+"' WHERE codigoCliente='"+codigoClienteID.getText()+"'";
                    c.getStmt().executeUpdate(sql);
                    c.getConn().close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
                wn.popUpMessage("Guardado con éxito","El huésped se actualizó con éxito.");
                nombreHuespedID.clear();
                aPHuespedID.clear();
                aMHuespedId.clear();
                telHuespedID.clear();
                nacionalidadID.clear();
                codigoClienteID.clear();
                nombreHuespedID.setFocusTraversable(false);
                aPHuespedID.setFocusTraversable(false);
                aMHuespedId.setFocusTraversable(false);
                telHuespedID.setFocusTraversable(false);
                nacionalidadID.setFocusTraversable(false);
                codigoClienteID.setFocusTraversable(false);
            }
        }
    }
}