package Controllers;

import Tools.ConTool;
import Tools.TableClientes;
import Tools.TableReservacion;
import Tools.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML
    private Button cancelarReservacionBoton;
    @FXML
    private TextField codigoCancelarReservacionID;
    @FXML
    private TableView <TableReservacion>tablaRes;
    @FXML
    private TableColumn <TableReservacion, String> clienteTablaRes;
    @FXML
    private TableColumn <TableReservacion, String> resTablaRes;
    @FXML
    private TableColumn <TableReservacion, String> cuartoTablaRes;
    @FXML
    private TableColumn <TableReservacion, String> inTablaRes;
    @FXML
    private TableColumn <TableReservacion, String> outTablaRes;
    @FXML
    private TableColumn <TableReservacion, String> personasTablaRes;
    @FXML
    private DatePicker fechaLlegadaReservacion;
    @FXML
    private DatePicker fechaSalidaReservacion;
    @FXML
    private TableColumn <TableClientes, String> claveTabla;
    @FXML
    private TableColumn <TableClientes, String> nombreTabla;
    @FXML
    private TableColumn <TableClientes, String> primerApTabla;
    @FXML
    private TableColumn <TableClientes, String> segundoApTabla;
    @FXML
    private TableColumn <TableClientes, String> telefonoTabla;
    @FXML
    private TableColumn <TableClientes, String> nacionalidadTabla;
    @FXML
    private TableView  <TableClientes> tablaClientesID;
    @FXML
    private TextField claveClienteReservar;
    @FXML
    private TextField numPersonasReservar;
    @FXML
    private ComboBox <String> tipoReservar;
    @FXML
    public Button reservarBoton;
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

    private final ObservableList<TableClientes> oblist = FXCollections.observableArrayList();

    private final ObservableList<TableReservacion> oblist2 = FXCollections.observableArrayList();

    private final ObservableList<String> tipoHab = FXCollections.observableArrayList("Sencilla","Doble","Premium");

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
                wn.popUpMessage("Editar campo","EL campo nacionalidad no puede\ncontener más e 3 caracteres");
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
        claveClienteReservar.setVisible(false);
        numPersonasReservar.setVisible(false);
        tipoReservar.setVisible(false);
        tipoReservar.setItems(null);
        reservarBoton.setVisible(false);
        fechaLlegadaReservacion.setVisible(false);
        fechaSalidaReservacion.setVisible(false);
        tablaRes.setVisible(false);
        codigoCancelarReservacionID.setVisible(false);
        cancelarReservacionBoton.setVisible(false);
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
                if(rst.getString("codigoCliente").equals(codigoClienteID.getText())){
                    found = true;
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

    /**
     * Método que muestra la tabla de los clientes registrados
     */
    public void verClientesOnAction() {
        oblist.clear();
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

    public void nuevaReservacionOnAction() {
        esconderElementosEnPantalla();
        claveClienteReservar.setVisible(true);
        fechaSalidaReservacion.setVisible(true);
        fechaLlegadaReservacion.setVisible(true);
        numPersonasReservar.setVisible(true);
        tipoReservar.setVisible(true);
        tipoReservar.setItems(tipoHab);
        reservarBoton.setVisible(true);
    }

    public void reservarOnAction() throws SQLException {
        if(claveClienteReservar.getText().isEmpty() || fechaLlegadaReservacion.getValue() == null || fechaSalidaReservacion.getValue() == null || numPersonasReservar.getText().isEmpty() || tipoReservar.getValue() == null){
            wn.popUpMessage("Llenar campos","Todos los campos deben estar llenos.");
        }
        else if(!checarSiClienteExiste(claveClienteReservar.getText()) && !(claveClienteReservar.getText().isEmpty())){
            wn.popUpMessage("Clave equivocada","No existe el cliente ingresado");
        }
        else if(Integer.parseInt(numPersonasReservar.getText()) > 4 && !(numPersonasReservar.getText().isEmpty())){
            wn.popUpMessage("Máximo de personas","El máximo de personas por habitación\nes de 4.");
        }
        else{
            try{
                c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                int nR = generarNumeroReservacion();
                String res = "RES_"+ nR;
                String SQL = "INSERT INTO reservacion(codigoReservacion,numRes) values('"+res+"',"+nR+")";
                c.getStmt().executeUpdate(SQL);
                String SQL_2 = "INSERT INTO cliente_reservacion(codigoCliente,codigoReservacion,numPersonas,tipo,checkIn,checkOut) values((SELECT codigoCliente FROM cliente where codigoCliente='"+claveClienteReservar.getText()+"')" +
                        ",(SELECT codigoReservacion FROM reservacion where codigoReservacion='"+res+"'),"+numPersonasReservar.getText()+",'"+tipoReservar.getValue()+"','"+fechaLlegadaReservacion.getValue()+"','"+fechaSalidaReservacion.getValue()+"')";
                c.getStmt().executeUpdate(SQL_2);
                c.getConn().close();
                wn.popUpMessage("Reservación hecha","La reservación fue realizada de manera\nexitosa");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public boolean checarSiClienteExiste(String clave) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT * FROM cliente";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while(rs.next()){
            if(clave.equals(rs.getString("codigoCliente"))){
                return true;
            }
        }
        return false;
    }

    public boolean checarSiReservacionExiste(String clave) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT * FROM reservacion";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while(rs.next()){
            if(clave.equals(rs.getString("codigoReservacion"))){
                return true;
            }
        }
        return false;
    }

    public int generarNumeroReservacion() throws SQLException {
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT * FROM reservacion";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while(rst.next()){
            nc = rst.getInt("numRes");
        }
        return nc+1;
    }

    public void verHuespedOnAction(ActionEvent actionEvent) {
        // MOSTRAR HUESPED
    }

    public void verReservacionOnAction(ActionEvent actionEvent) {
        oblist2.clear();
        esconderElementosEnPantalla();
        tablaRes.getItems().clear();
        tablaRes.setVisible(true);
        try{
            c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM cliente_reservacion";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while(rst.next()){
                oblist2.add(new TableReservacion(rst.getString("codigoCliente"),rst.getString("codigoReservacion"),rst.getString("tipo"),
                                             rst.getString("checkIn"),rst.getString("checkOut"),rst.getString("numPersonas")));
                System.out.println(rst.getString("codigoReservacion"));
            }
            c.getConn().close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        clienteTablaRes.setCellValueFactory(new PropertyValueFactory<>("codigoCliente"));
        resTablaRes.setCellValueFactory(new PropertyValueFactory<>("codigoRes"));
        cuartoTablaRes.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        inTablaRes.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        outTablaRes.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        personasTablaRes.setCellValueFactory(new PropertyValueFactory<>("numPersonas"));
        tablaRes.setItems(oblist2);
    }

    public void cancelarResOnAction() {
        esconderElementosEnPantalla();
        cancelarReservacionBoton.setVisible(true);
        codigoCancelarReservacionID.setVisible(true);
    }

    public void cancelarReservacionOnAction(ActionEvent actionEvent) throws SQLException {
        if(!codigoCancelarReservacionID.getText().isEmpty()){
            if(checarSiReservacionExiste(codigoCancelarReservacionID.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "DELETE FROM cliente_reservacion where codigoReservacion='"+codigoCancelarReservacionID.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    String sql = "DELETE FROM reservacion where codigoReservacion='"+codigoCancelarReservacionID.getText()+"'";
                    c.getStmt().executeUpdate(sql);
                    c.getConn().close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("No existe la reservación","La reservación no existe");
            }

        }
        else{
            wn.popUpMessage("Llenar el campo","El campo debe estar lleno");
        }

        wn.popUpMessage("Cancelado con éxito","La reservación fue cancelada con éxito");
    }
}