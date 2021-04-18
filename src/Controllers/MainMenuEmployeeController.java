package Controllers;

import Tools.ConTool;
import Tools.TableClientes;
import Tools.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private final TableClientes tc = new TableClientes();
    public TableColumn <TableClientes, String> claveTabla;
    public TableColumn <TableClientes, String> nombreTabla;
    public TableColumn <TableClientes, String> primerApTabla;
    public TableColumn <TableClientes, String> segundoApTabla;
    public TableColumn <TableClientes, String> telefonoTabla;
    public TableColumn <TableClientes, String> nacionalidadTabla;
    public TableView  <TableClientes> tablaClientesID;
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

    ObservableList<TableClientes> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        esconderElementosEnPantalla();
    }

    /**
     * Método que regresa a la pantalla de log in
     */
    public void salirOnAction() {
        try {
            wn.changeStage(mainMenuPane,"/GUI/LogInScreen.fxml");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Método que desbloquea campos cuando se le da clic en Huesped -> Nuevo
     */
    public void nuevoHuespedOnAction() {
        esconderElementosEnPantalla();
        nombreHuespedID.setVisible(true);
        aPHuespedID.setVisible(true);
        aMHuespedId.setVisible(true);
        telHuespedID.setVisible(true);
        nacionalidadID.setVisible(true);
        guardarHuesped.setVisible(true);
    }

    /**
     * Método que se encarga de guardar los datos del cliente
     */
    public void guardarHuespedOnAction(){
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

    /**
     * Método que esconde todos los campos
     */
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
        tablaClientesID.setVisible(false);
    }

    /**
     * Método que checa el último número de cliente registrado
     * @return número del último cliente +1
     * @throws SQLException exception
     */
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

    /**
     * Método que desbloquea campos cuando se le da clic en Huesped -> Editar
     */
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

    /**
     * Método que busca los datos del huesped y llena las areas a editar
     * @throws SQLException exception
     */
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

    /**
     *Método que se encarga de actualizar los datos del cliente
     */
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

    public void verClientesOnAction() {
        esconderElementosEnPantalla();
        tablaClientesID.getItems().clear();
        tablaClientesID.setVisible(true);
        try{
            c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM cliente";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while(rst.next()){
                oblist.add(new TableClientes(rst.getString("codigoCliente"), rst.getString("nombre"), rst.getString("primerApellido"),
                           rst.getString("segundoApellido"), rst.getString("telefono"),rst.getString("nacionalidad")));
            }
            c.getConn().close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("claveCliente"));
        nombreTabla.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        primerApTabla.setCellValueFactory(new PropertyValueFactory<>("primerApellido"));
        segundoApTabla.setCellValueFactory(new PropertyValueFactory<>("segundoApellido"));
        telefonoTabla.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        nacionalidadTabla.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        tablaClientesID.setItems(oblist);
    }
}