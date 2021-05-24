package Controllers;

import Tools.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swt.SWTFXUtils;
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

public class MainMenuManagerController implements Initializable {

    private final Window wn = new Window();
    private final ConTool c = new ConTool();
    private final User user = new User();

    @FXML
    private TableColumn <TableEmpleadoDepa,String> claveEmpTableEmpDepa;
    @FXML
    private TableColumn <TableEmpleadoDepa,String>claveDepaTableEmpDepa;
    @FXML
    private TableColumn <TableEmpleadoDepa,String>puestoTableEmpDepa;
    @FXML
    private TableColumn <TableEmpleadoDepa,Double>sueldoTableEmpDepa;
    @FXML
    private TableView <TableEmpleadoDepa>tablaEmpleadoDepa;
    @FXML
    private Button registrarEmpAreaButton;
    @FXML
    private TextField codigoEmpEmpArea;
    @FXML
    private TextField codigoAreaEmpArea;
    @FXML
    private TextField horarioEmpArea;
    @FXML
    private TextField codigoGerGerDepa;
    @FXML
    private TextField sueldoGerDepa;
    @FXML
    private TextField codigoDepaGerDepa;
    @FXML
    private Button registrarGerDepaButton;

    @FXML
    private TextField claveEmpleadoDepa;
    @FXML
    private TextField claveDepaDepa;
    @FXML
    private TextField puestoEmpDepa;
    @FXML
    private TextField sueldoEmpDepa;
    @FXML
    private Button addEmpleadoDepa;
    @FXML
    private TextField nombreGerenteEditar;
    @FXML
    private TextField telefonoGerenteEditar;
    @FXML
    private TextField direccionGerenteEditar;
    @FXML
    private TextField horaEntGerenteEditar;
    @FXML
    private TextField horaSalidaGerenteEditar;
    @FXML
    private Button actualizarGerenteButton;
    @FXML
    private Button buscarGerenteEditar;
    @FXML
    private TextField claveGerenteEditar;


    @FXML
    private TextField borrarClaveGerente;
    @FXML
    private PasswordField passBorrarGerente;
    @FXML
    private Button borrarGerenteBoton;
    @FXML
    private TableView <TableGerentes> tableGer;
    @FXML
    private TableColumn <TableGerentes,String>claveTableGer;
    @FXML
    private TableColumn <TableGerentes,String>nombreTableGer;
    @FXML
    private TableColumn <TableGerentes,String>telefTableGer;
    @FXML
    private TableColumn <TableGerentes,String>direccionTableGer;
    @FXML
    private TableColumn <TableGerentes,String> horaEntTableGer;
    @FXML
    private TableColumn <TableGerentes,String> horaSalidaTableGer;
    @FXML
    private TableColumn <TableGerentes,String> passTableGer;
    @FXML
    private PasswordField passGerenteNuevo;
    @FXML
    private TextField nombreGerenteNuevo;
    @FXML
    private TextField telefonoGerenteNuevo;
    @FXML
    private TextField direccionGerenteNuevo;
    @FXML
    private TextField horaEntGerenteNuevo;
    @FXML
    private TextField horaSalidaGerenteNuevo;
    @FXML
    private Button crearGerente;
    @FXML
    private ComboBox <String>tipoEditarArea;
    @FXML
    private TextField nombreEditarArea;
    @FXML
    private TextField numPersonalEditarArea;
    @FXML
    private Button buscarEditarAreaButton;
    @FXML
    private TextField buscarClaveEditarArea;
    @FXML
    private Button actualizarAreaButton;
    @FXML
    private TextField claveBorrarArea;
    @FXML
    private PasswordField passBorrarArea;
    @FXML
    private Button borrarAreaButton;
    @FXML
    private ComboBox <String>filtroTableAreas;
    @FXML
    private Button buscarTableAreas;
    @FXML
    private TableView <TableAreas> tableAreas;
    @FXML
    private TableColumn <TableAreas,String> claveTableAreas;
    @FXML
    private TableColumn <TableAreas,String> tipoTableAreas;
    @FXML
    private TableColumn <TableAreas,Integer> personalTableAreas;
    @FXML
    private TableColumn <TableAreas,String> nombreTableAreas;
    @FXML
    private Button nuevaAreaButton;
    @FXML
    private ComboBox <String> tipoNuevaArea;
    @FXML
    private TextField nombreNuevaArea;
    @FXML
    private TextField numPersonalArea;
    @FXML
    private Button buscarTableVenta;
    @FXML
    private TextField claveEmpleadoTableVenta;
    @FXML
    private ComboBox <String> filtroVentaComboBox;
    @FXML
    private TableColumn <TableVentas,String> empleadoTableVentas;
    @FXML
    private TableColumn <TableVentas,String> reservacionTableVentas;
    @FXML
    private TableColumn <TableVentas,Double>precioTableVentas;
    @FXML
    private TableView <TableVentas> tableVentas;
    @FXML
    private TableColumn <TableEmpleado,String>codigoTablaEmp;
    @FXML
    private TableColumn <TableEmpleado,String>nombreTablaEmp;
    @FXML
    private TableColumn <TableEmpleado,String>telefonoTablaEmp;
    @FXML
    private TableColumn <TableEmpleado,String>direccionTablaEmp;
    @FXML
    private TableColumn <TableEmpleado,String>passwordTablaEmp;
    @FXML
    private TableView <TableEmpleado> tablaEmp;
    @FXML
    private TableView <TablaDepartamento> tablaDep;
    @FXML
    private TableColumn <TablaDepartamento,String> codigoTablaDep;
    @FXML
    private TableColumn <TablaDepartamento,String> nombreTablaDep;
    @FXML
    private TableColumn <TablaDepartamento,Integer> empleadosTablaDep;
    @FXML
    private Button actualizarEmpleadoButtonID;
    @FXML
    private PasswordField passUserEditarID;
    @FXML
    private TextField nombreEmpleadoEditarID;
    @FXML
    private TextField telefonoEmpleadoEditarID;
    @FXML
    private TextArea direccionEmpleadoEditarID;
    @FXML
    private PasswordField passEmpleadoEditarID;
    @FXML
    private TextField claveEditarEmpleadoID;
    @FXML
    private Button buscarEmpleadoButton;
    @FXML
    private TextField borrarEmpleadoID;
    @FXML
    private PasswordField passUserBorrarEmpleadoID;
    @FXML
    private Button borrarEmpleadoButtonID;
    @FXML
    private TextField nombreEmpleadoCrearID;
    @FXML
    private TextArea direccionEmpleadoCrearID;
    @FXML
    private TextField telefonoEmpleadoCrearID;
    @FXML
    private PasswordField passEmpleadoCrearID;
    @FXML
    private PasswordField passUserCrearEmpleadoID;
    @FXML
    private Button crearEmpleadoButton;
    @FXML
    private TextField borrarClaveDepID;
    @FXML
    private PasswordField passBorrarDepID;
    @FXML
    private Button borrarDepID;
    @FXML
    private TextField nombreDepID;
    @FXML
    private PasswordField passDepID;
    @FXML
    private Button registrarDepID;
    @FXML
    private TextField claveDepID;
    @FXML
    private Button buscarClaveDep;
    @FXML
    private TextField actNombreDep;
    @FXML
    private Button actDep;
    @FXML
    private TableColumn <TableHuespedActivo,String> cuartoActivo;
    @FXML
    private TableColumn <TableHuespedActivo,String>reservacionActivo;
    @FXML
    private TableColumn <TableHuespedActivo,String>checkInActivo;
    @FXML
    private TableView<TableHuespedActivo> tablaHuespedActivo;
    @FXML
    private DatePicker fechaSalidaCheckOut;
    @FXML
    private TextField codigoResCheckOut;
    @FXML
    private PasswordField passwCheckOut;
    @FXML
    private Button checkOutButton;
    @FXML
    private TextField codigoCheckInID;
    @FXML
    private DatePicker fechaCheckInID;
    @FXML
    private Button registrarCheckInID;
    @FXML
    private TableView<TableCuarto> habitacionesTableID;
    @FXML
    private TableColumn<TableCuarto, String> codigoHabTable;
    @FXML
    private TableColumn<TableCuarto, Integer> capHabTable;
    @FXML
    private TableColumn<TableCuarto, String> tipoHabTable;
    @FXML
    private TableColumn<TableCuarto, Integer> numHabTable;
    @FXML
    private TableColumn<TableCuarto, Integer> pisoHabTable;
    @FXML
    private TableColumn<TableCuarto, String> dispHabTable;
    @FXML
    private ComboBox<String> filtroStatusComboBoxID;
    @FXML
    private ComboBox<String> filtroCapacidadComboBoxID;
    @FXML
    private ComboBox<String> filtroTipoComboBoxID;
    @FXML
    private Button filtrarID;
    @FXML
    private PasswordField passwordCancelarReservacionID;
    @FXML
    private Button cancelarReservacionBoton;
    @FXML
    private TextField codigoCancelarReservacionID;
    @FXML
    private TableView<TableReservacion> tablaRes;
    @FXML
    private TableColumn<TableReservacion, String> clienteTablaRes;
    @FXML
    private TableColumn<TableReservacion, String> resTablaRes;
    @FXML
    private TableColumn<TableReservacion, String> cuartoTablaRes;
    @FXML
    private TableColumn<TableReservacion, String> inTablaRes;
    @FXML
    private TableColumn<TableReservacion, String> outTablaRes;
    @FXML
    private TableColumn<TableReservacion, String> personasTablaRes;
    @FXML
    private DatePicker fechaLlegadaReservacion;
    @FXML
    private DatePicker fechaSalidaReservacion;
    @FXML
    private TableColumn<TableClientes, String> claveTabla;
    @FXML
    private TableColumn<TableClientes, String> nombreTabla;
    @FXML
    private TableColumn<TableClientes, String> primerApTabla;
    @FXML
    private TableColumn<TableClientes, String> segundoApTabla;
    @FXML
    private TableColumn<TableClientes, String> telefonoTabla;
    @FXML
    private TableColumn<TableClientes, String> nacionalidadTabla;
    @FXML
    private TableView<TableClientes> tablaClientesID;
    @FXML
    private TextField claveClienteReservar;
    @FXML
    private TextField numPersonasReservar;
    @FXML
    private ComboBox<String> tipoReservar;
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

    private final ObservableList<TableCuarto> oblist3 = FXCollections.observableArrayList();

    private final ObservableList<TableHuespedActivo> oblist4 = FXCollections.observableArrayList();

    private final ObservableList<TablaDepartamento> oblist5 = FXCollections.observableArrayList();

    private final ObservableList<TableEmpleado> oblist6 = FXCollections.observableArrayList();

    private final ObservableList<TableVentas> oblist7 = FXCollections.observableArrayList();

    private final ObservableList<TableAreas> oblist8 = FXCollections.observableArrayList();

    private final ObservableList<TableGerentes> oblist9 = FXCollections.observableArrayList();

    private final ObservableList<TableEmpleadoDepa> oblist10 = FXCollections.observableArrayList();

    private final ObservableList<String> filtroHab = FXCollections.observableArrayList("Sencilla", "Doble", "Premium", "Todo");

    private final ObservableList<String> capHab = FXCollections.observableArrayList("1", "2", "3", "4", "Todo");

    private final ObservableList<String> statusHab = FXCollections.observableArrayList("Disponible", "Ocupada", "Todo");

    private final ObservableList<String> filtroVenta = FXCollections.observableArrayList("Empleado","Todo");

    private final ObservableList<String> tipoArea = FXCollections.observableArrayList("Recepción","Limpieza","Recreativa","Almacén","Servicio","Restaurante");

    private final ObservableList<String> tipoTableArea = FXCollections.observableArrayList("Recepción","Limpieza","Recreativa","Almacén","Servicio","Restaurante","Todo");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        esconderElementosEnPantalla();
    }


    // ******************************************************************************//
    // <!--------------------------FUNCIONES DE BOTONES--------------------------!> //
    // ******************************************************************************//
    /**
     * Método que regresa a la pantalla de log in
     */
    public void salirOnAction() {
        try {
            wn.changeStage(mainMenuPane, "/GUI/LogInScreen.fxml");
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
    public void guardarHuespedOnAction() {
        if (!(nombreHuespedID.getText().isEmpty() && aPHuespedID.getText().isEmpty() && aMHuespedId.getText().isEmpty() && telHuespedID.getText().isEmpty() && nacionalidadID.getText().isEmpty())) {
            if (nacionalidadID.getText().length() > 3) {
                wn.popUpMessage("Editar campo", "EL campo nacionalidad no puede\ncontener más e 3 caracteres");
            } else if (telHuespedID.getText().length() > 20) {
                wn.popUpMessage("Teléfono muy largo", "EL número de teléfono no puede\nexceder de 20 números.");
            } else {
                try {
                    c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    int n = generarNumeroCliente();
                    String codigo = "CL" + n;
                    c.getStmt().executeUpdate("INSERT INTO cliente(codigoCliente,nombre,telefono,nacionalidad,numVisitas,numCliente,primerApellido,segundoApellido) values('" +
                            codigo + "','" + nombreHuespedID.getText() + "','" + telHuespedID.getText() + "','"
                            + nacionalidadID.getText() + "',0," + n + ",'" + aPHuespedID.getText() + "','" + aMHuespedId.getText() + "')");
                    c.getConn().close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                wn.popUpMessage("Guardado con éxito", "El huésped se registro con éxito.");
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
        } else {
            wn.popUpMessage("Llenar campos", "Todos los campos deben de estar llenos ");
        }
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
     *
     * @throws SQLException exception
     */
    public void buscarHuespedOnAction() throws SQLException {
        boolean found = false;
        if (!buscarHuespedID.getText().isEmpty()) {
            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM cliente WHERE codigoCliente='" + codigoClienteID.getText() + "'";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while (rst.next()) {
                if (rst.getString("codigoCliente").equals(codigoClienteID.getText())) {
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
            if (!found) {
                wn.popUpMessage("Cliente no encontrado", "El sistema no encontró al cliente con\nesa clave");
            }
        } else {
            wn.popUpMessage("Poner código de cliente", "El campo del código de cliente debe de\n estar lleno para hacer una\nbúsqueda");
        }
    }

    /**
     * Método que se encarga de actualizar los datos del cliente
     */
    public void actualizarOnAction() {
        if (!(nombreHuespedID.getText().isEmpty() && aPHuespedID.getText().isEmpty() && aMHuespedId.getText().isEmpty() && telHuespedID.getText().isEmpty() && nacionalidadID.getText().isEmpty())) {
            if (nacionalidadID.getText().length() > 3) {
                wn.popUpMessage("Editar campo", "EL campo nacionalidad no puede\ncontener más de 3 caracteres");
            } else if (telHuespedID.getText().length() > 20) {
                wn.popUpMessage("Teléfono muy largo", "EL número de teléfono no puede\nexceder de 20 números.");
            } else {
                try {
                    c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String sql = "UPDATE cliente SET nombre='" + nombreHuespedID.getText() + "',telefono='" + telHuespedID.getText() + "',nacionalidad='" + nacionalidadID.getText()
                            + "',primerApellido='" + aPHuespedID.getText() + "',segundoApellido='" + aMHuespedId.getText() + "' WHERE codigoCliente='" + codigoClienteID.getText() + "'";
                    c.getStmt().executeUpdate(sql);
                    c.getConn().close();
                    wn.popUpMessage("Guardado con éxito", "El huésped se actualizó con éxito.");
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
                } catch (Exception e) {
                    System.out.println(e);
                }
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
        try {
            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM cliente";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while (rst.next()) {
                oblist.add(new TableClientes(rst.getString("codigoCliente"), rst.getString("nombre"), rst.getString("primerApellido"),
                        rst.getString("segundoApellido"), rst.getString("telefono"), rst.getString("nacionalidad")));
            }
            c.getConn().close();
        } catch (Exception e) {
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

    /**
     * Método que se encarga de guardar los datos de la reservación
     *
     * @throws SQLException exception
     */
    public void reservarOnAction() throws SQLException {
        if (claveClienteReservar.getText().isEmpty() || fechaLlegadaReservacion.getValue() == null || fechaSalidaReservacion.getValue() == null || numPersonasReservar.getText().isEmpty() || tipoReservar.getValue() == null) {
            wn.popUpMessage("Llenar campos", "Todos los campos deben estar llenos.");
        } else if (!checarSiClienteExiste(claveClienteReservar.getText()) && !(claveClienteReservar.getText().isEmpty())) {
            wn.popUpMessage("Clave equivocada", "No existe el cliente ingresado");
        } else if (Integer.parseInt(numPersonasReservar.getText()) > 4 && !(numPersonasReservar.getText().isEmpty())) {
            wn.popUpMessage("Máximo de personas", "El máximo de personas por habitación\nes de 4.");
        } else {
            try {
                c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                int nR = generarNumeroReservacion();
                String res = "RES_" + nR;
                String SQL = "INSERT INTO reservacion(codigoReservacion,numRes,fecha) values('" + res + "'," + nR + ",'" + user.getDate() + "')";
                c.getStmt().executeUpdate(SQL);
                String SQL_2 = "INSERT INTO cliente_reservacion(codigoCliente,codigoReservacion,numPersonas,tipo,checkIn,checkOut) values((SELECT codigoCliente FROM cliente where codigoCliente='" + claveClienteReservar.getText() + "')" +
                        ",(SELECT codigoReservacion FROM reservacion where codigoReservacion='" + res + "')," + numPersonasReservar.getText() + ",'" + tipoReservar.getValue() + "','" + fechaLlegadaReservacion.getValue() + "','" + fechaSalidaReservacion.getValue() + "')";
                c.getStmt().executeUpdate(SQL_2);
                String [] datos = buscarNumeroPersonasYTipoReservacion(res);
                double precio;
                if(datos[1].equals("Sencilla")){
                    precio = Integer.parseInt(datos[0])*400;
                }
                else if(datos[1].equals("Doble")){
                    precio = Integer.parseInt(datos[0])*700;
                }
                else{
                    precio = Integer.parseInt(datos[0])*1200;
                }
                String SQL_3 = "INSERT INTO empleado_reservacion(codigoReservacion,codigoEmpleado,precio) values('"+res+"','"+user.getUsername()+"',"+precio+")";
                c.getStmt().executeUpdate(SQL_3);
                c.getConn().close();
                wn.popUpMessage("Reservación hecha", "La reservación fue realizada de manera\nexitosa");
                claveClienteReservar.clear();
                fechaLlegadaReservacion.setValue(null);
                fechaSalidaReservacion.setValue(null);
                numPersonasReservar.clear();
                tipoReservar.setValue(null);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Método que muestra la tabla llena de las reservaciones
     */
    public void verReservacionOnAction() {
        oblist2.clear();
        esconderElementosEnPantalla();
        tablaRes.getItems().clear();
        tablaRes.setVisible(true);
        try {
            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM cliente_reservacion";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while (rst.next()) {
                oblist2.add(new TableReservacion(rst.getString("codigoCliente"), rst.getString("codigoReservacion"), rst.getString("tipo"),
                        rst.getString("checkIn"), rst.getString("checkOut"), rst.getString("numPersonas")));
            }
            c.getConn().close();
        } catch (Exception e) {
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

    /**
     * Método que se encarga de borrar la reservación de la base de datos
     *
     * @throws SQLException exception
     */
    public void cancelarReservacionOnAction() throws SQLException {
        if (!codigoCancelarReservacionID.getText().isEmpty()) {
            if (checarSiReservacionExiste(codigoCancelarReservacionID.getText())) {
                if (passwordCancelarReservacionID.getText().equals(user.getPassword())) {
                    try {
                        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                        c.setStmt(c.getConn().createStatement());
                        String SQL = "DELETE FROM cliente_reservacion where codigoReservacion='" + codigoCancelarReservacionID.getText() + "'";
                        c.getStmt().executeUpdate(SQL);
                        String sql_2 = "DELETE FROM empleado_reservacion where codigoReservacion='"+codigoCancelarReservacionID.getText()+"'";
                        c.getStmt().executeUpdate(sql_2);
                        String sql = "DELETE FROM reservacion where codigoReservacion='" + codigoCancelarReservacionID.getText() + "'";
                        c.getStmt().executeUpdate(sql);
                        c.getConn().close();
                        wn.popUpMessage("Cancelado con éxito", "La reservación fue cancelada con éxito");
                        codigoCancelarReservacionID.clear();
                        passwordCancelarReservacionID.clear();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    wn.popUpMessage("Contraseña equivocada", "Ingresar la contraseña del usuario\nque inició sesión.");
                }
            } else {
                wn.popUpMessage("No existe la reservación", "La reservación no existe");
            }

        } else {
            wn.popUpMessage("Llenar el campo", "El campo debe estar lleno");
        }
    }

    /**
     * Método que desbloquea campos cuando se le da clic a Habitaciones -> Ver
     */
    public void verHabitacionOnAction() {
        esconderElementosEnPantalla();
        filtroStatusComboBoxID.setVisible(true);
        filtroStatusComboBoxID.setItems(statusHab);
        filtroCapacidadComboBoxID.setVisible(true);
        filtroCapacidadComboBoxID.setItems(capHab);
        filtroTipoComboBoxID.setVisible(true);
        filtroTipoComboBoxID.setItems(filtroHab);
        habitacionesTableID.setVisible(true);
        filtrarID.setVisible(true);
        habitacionesTableID.getItems().clear();
    }

    /**
     * Método que filtra las habitaciones para mostrarlas en tabla
     */
    public void filtrarHabitacionesOnAction() {
        habitacionesTableID.getItems().clear(); // limpia la tabla por si se realizan distintos filtros sin cambiar de vista
        if (filtroCapacidadComboBoxID.getValue() != null && filtroTipoComboBoxID.getValue() != null && filtroStatusComboBoxID.getValue() != null) {
            try {
                c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                String sql = obtenerFiltroHabitacion(filtroCapacidadComboBoxID.getValue(), filtroTipoComboBoxID.getValue(), filtroStatusComboBoxID.getValue());
                c.setPst(c.getConn().prepareStatement(sql));
                ResultSet rst = c.getPst().executeQuery();
                while (rst.next()) {
                    oblist3.add(new TableCuarto(rst.getString("codigoHabitacion"), rst.getInt("capacidad"), rst.getString("tipo"),
                            rst.getInt("numero"), rst.getInt("piso"), rst.getString("disponible")));
                }
                c.getConn().close();
                codigoHabTable.setCellValueFactory(new PropertyValueFactory<>("codigo"));
                capHabTable.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
                tipoHabTable.setCellValueFactory(new PropertyValueFactory<>("tipo"));
                numHabTable.setCellValueFactory(new PropertyValueFactory<>("numero"));
                pisoHabTable.setCellValueFactory(new PropertyValueFactory<>("piso"));
                dispHabTable.setCellValueFactory(new PropertyValueFactory<>("disp"));
                habitacionesTableID.setItems(oblist3);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            wn.popUpMessage("Filtros deben seleccionarse", "Todos los filtros deben de estar\nseleccionados para poder hacer la búsqueda");
        }
    }

    /**
     * Método que desbloquea los campos necesarios para el check in
     */
    public void checkInOnAction() {
        esconderElementosEnPantalla();
        registrarCheckInID.setVisible(true);
        fechaCheckInID.setVisible(true);
        codigoCheckInID.setVisible(true);
    }

    /**
     * Método que desbloquea los campos necesarios para el check out
     */
    public void checkOutOnAction() {
        esconderElementosEnPantalla();
        checkOutButton.setVisible(true);
        passwCheckOut.setVisible(true);
        codigoResCheckOut.setVisible(true);
        fechaSalidaCheckOut.setVisible(true);
    }

    /**
     * Método que se encarga de la lógica del check-in
     */
    public void hacerCheckIn() throws SQLException {
        if (codigoCheckInID.getText().isEmpty() || fechaCheckInID.getValue() == null) {
            wn.popUpMessage("Llenar campos", "Se tiene que ingresar un código\ny seleccionar una fecha.");
        }
        else {
            if (checarSiReservacionExiste(codigoCheckInID.getText()) && checarSiReservacionAsignada(codigoCheckInID.getText())) {
                wn.popUpMessage("Problemas con la reservación", "La reservación no existe o ya fue asignada");
            } else {
                try {
                    c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String [] numPer = buscarNumeroPersonasYTipoReservacion(codigoCheckInID.getText());
                    String codHab = asignarHabitacion(numPer);
                    if(codHab.equals("notFound")){
                        wn.popUpMessage("Habitación no encontrada","No hay habitaciones disponibles\nde ese tipo para ese número de personas");
                    }
                    else{
                        String SQL = "INSERT into reservacion_habitacion (codigoReservacion,codigoHabitacion,fecha,numPersonas) values ('"+codigoCheckInID.getText()+"','"+
                                codHab+"','"+fechaCheckInID.getValue()+"',"+Integer.valueOf(numPer[0])+")";
                        c.getStmt().executeUpdate(SQL);
                        String sql = "UPDATE habitacion SET disponible='O' where codigoHabitacion='"+codHab+"'";
                        c.getStmt().executeUpdate(sql);
                        c.getConn().close();
                        wn.popUpMessage("Habitación asignada","Se le asignó la habitación:\n"+codHab);
                        codigoCheckInID.clear();
                        fechaCheckInID.setValue(null);
                    }
                } catch (Exception e) {
                    wn.popUpMessage("Error","Verifique que los datos ingresados\nsean correctos.");
                    System.out.println(e);
                }
            }
        }
    }
    /**
     * Método que se encarga de la lógica del check-out
     */
    public void hacerCheckOut() throws SQLException {
        if(codigoResCheckOut.getText().isEmpty() || fechaSalidaCheckOut.getValue() == null || passwCheckOut.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Todos los campos deben estar llenados\npara proeceder con el check-out");
        }
        else{
            if(passwCheckOut.getText().equals(user.getPassword())){
                if (checarSiReservacionExiste(codigoResCheckOut.getText()) && !checarSiReservacionAsignada(codigoResCheckOut.getText())) {
                    wn.popUpMessage("Problemas con la reservación", "La reservación no existe o ya se hizo check-out");
                }
                else{
                    try{
                        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                        c.setStmt(c.getConn().createStatement());
                        String SQL = "DELETE FROM cliente_reservacion where codigoReservacion='"+ codigoResCheckOut.getText()+"'";
                        c.getStmt().executeUpdate(SQL);
                        String sql2 = "DELETE FROM reservacion_habitacion where codigoReservacion='"+ codigoResCheckOut.getText()+"'";
                        c.getStmt().executeUpdate(sql2);
                        String sql = "UPDATE habitacion SET disponible='D' where codigoHabitacion='"+obtenerHabitacionAsignada(codigoResCheckOut.getText())+"'";
                        c.getStmt().executeUpdate(sql);
                        c.getConn().close();
                        wn.popUpMessage("Éxito","El check out fue realizado con éxito.");
                        passwCheckOut.clear();
                        codigoResCheckOut.clear();
                        fechaSalidaCheckOut.setValue(null);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
            else{
                wn.popUpMessage("Contraseña incorrecta","Ingrese la contraseña correcta");
            }
        }
    }

    /**
     * Método que muestra la tabla de los huéspedes activos al momento
     */
    public void verHuespedOnAction() {
        esconderElementosEnPantalla();
        oblist4.clear();
        tablaHuespedActivo.getItems().clear();
        tablaHuespedActivo.setVisible(true);
        try{
            c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String SQL = "SELECT * FROM reservacion_habitacion";
            c.setPst(c.getConn().prepareStatement(SQL));
            ResultSet rst = c.getPst().executeQuery();
            while(rst.next()){
                oblist4.add(new TableHuespedActivo(obtenerHabitacionAsignada(rst.getString("codigoReservacion")),rst.getString("codigoReservacion"),rst.getString("fecha")));
            }
            c.getConn().close();
            cuartoActivo.setCellValueFactory(new PropertyValueFactory<>("cuarto"));
            reservacionActivo.setCellValueFactory(new PropertyValueFactory<>("reservacion"));
            checkInActivo.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
            tablaHuespedActivo.setItems(oblist4);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Método que desbloquea campos para registrar el nuevo departamento
     */
    public void nuevoDepartamento() {
        esconderElementosEnPantalla();
        nombreDepID.setVisible(true);
        passDepID.setVisible(true);
        registrarDepID.setVisible(true);
    }

    /**
     * Método que registra el nuevo departamento
     */
    public void registrarDepOnAction() {
        if(nombreDepID.getText().isEmpty() || passDepID.getText().isEmpty()){
            wn.popUpMessage("Campos vacíos","Asegúrese que todos los campos estén llenos");
        }
        else{
            if(passDepID.getText().equals(user.getPassword())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    int n = generarNumeroDepartamento();
                    String claveDep = "DEP_" + n;
                    String sql = "INSERT INTO departamento (codigoDepartamento, nombre, numEmpleados, numeroDepartamento) values('"+claveDep+"','"+nombreDepID.getText()+"',0,"+n+")";
                    c.getStmt().executeUpdate(sql);
                    wn.popUpMessage("Departamento creado","El departamento fue creado de \nforma exitosa");
                    c.getConn().close();
                    nombreDepID.clear();
                    passDepID.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Contraseña incorrecta","Ingrese la contraseña correcta");
            }
        }
    }

    /**
     * Método que desbloquea los filtros para editar el departamento
     */
    public void editarDepartamento() {
        esconderElementosEnPantalla();
        claveDepID.setVisible(true);
        buscarClaveDep.setVisible(true);
        nombreDepID.setVisible(true);
        actDep.setVisible(true);
    }

    /**
     * Método que busca (al presionar el botón buscar) el departamento a editar
     * @throws SQLException exception
     */
    public void buscarDepOnAction()  throws  SQLException{
        if(!claveDepID.getText().isEmpty()){
            if(checarClaveDepartamento(claveDepID.getText())){
                c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                String SQL = "SELECT * from departamento where codigoDepartamento='"+claveDepID.getText()+"'";
                c.setPst(c.getConn().prepareStatement(SQL));
                ResultSet rst = c.getPst().executeQuery();
                while(rst.next()){
                    nombreDepID.setText(rst.getString("nombre"));
                }
                c.getConn().close();
            }
            else{
                wn.popUpMessage("No existe departamento","Ingrese una clave valida.");
            }
        }
        else{
            wn.popUpMessage("Ingresar clave","Por favor ingrese una clave para\npoder seguir con la búsqueda.");
        }
    }

    /**
     * Método que actualiza los datos del departamento encontrado
     * @throws SQLException exception
     */
    public void actDepOnAction() throws SQLException {
        if(nombreDepID.getText().isEmpty() || !checarClaveDepartamento(claveDepID.getText())){
            wn.popUpMessage("Error","Asegúrese que el nombre no esté vacío,\ny que la clave sea correcta y no esté vacía.");
        }
        else{
            c.setStmt(c.getConn().createStatement());
            String SQL = "UPDATE departamento set nombre='"+nombreDepID.getText()+"' where codigoDepartamento='"+claveDepID.getText()+"'";
            c.getStmt().executeUpdate(SQL);
            c.getConn().close();
            claveDepID.clear();
            nombreDepID.clear();
            wn.popUpMessage("Exito","El departamento fue actualizado con éxito");
        }
    }

    /**
     * Método que desbloquea los campos para borrar un departamento
     */
    public void borrarDepartamento() {
        esconderElementosEnPantalla();
        borrarClaveDepID.setVisible(true);
        passBorrarDepID.setVisible(true);
        borrarDepID.setVisible(true);
    }

    /**
     * Método que borra un departamento de la base de datos
     */
    public void borrarDep() throws SQLException {
        if(!borrarClaveDepID.getText().isEmpty() || !passBorrarDepID.getText().isEmpty()){
            if(checarClaveDepartamento(borrarClaveDepID.getText()) && passBorrarDepID.getText().equals(user.getPassword())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "DELETE FROM departamento where codigoDepartamento='"+borrarClaveDepID.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    c.getConn().close();
                    borrarClaveDepID.clear();
                    passBorrarDepID.clear();
                    wn.popUpMessage("Éxito","El departamento fue borrado con éxito");

                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Clave no válida","La clave ingresada no existe en\nla base de datos o la contraseña\nno es válida.");
            }
        }
        else{
            wn.popUpMessage("Llenar campos","Llenar todos los campos para poder\ncontinuar con el proceso");
        }
    }

    /**
     * Método que desbloquea los campos para poder dar de alta un empleado
     */
    public void nuevoEmpleado() {
        esconderElementosEnPantalla();
        nombreEmpleadoCrearID.setVisible(true);
        telefonoEmpleadoCrearID.setVisible(true);
        direccionEmpleadoCrearID.setVisible(true);
        passEmpleadoCrearID.setVisible(true);
        passUserCrearEmpleadoID.setVisible(true);
        crearEmpleadoButton.setVisible(true);
    }

    /**
     * Método que desbloquea campos para poder borrar un empleado
     */
    public void borrarEmpleado() {
        esconderElementosEnPantalla();
        borrarEmpleadoID.setVisible(true);
        passUserBorrarEmpleadoID.setVisible(true);
        borrarEmpleadoButtonID.setVisible(true);
    }

    /**
     * Método que desbloquea los campos para poder editar los campos de un empleado
     */
    public void editarEmpleado() {
        esconderElementosEnPantalla();
        nombreEmpleadoEditarID.setVisible(true);
        telefonoEmpleadoEditarID.setVisible(true);
        direccionEmpleadoEditarID.setVisible(true);
        passEmpleadoEditarID.setVisible(true);
        claveEditarEmpleadoID.setVisible(true);
        buscarEmpleadoButton.setVisible(true);
        passUserEditarID.setVisible(true);
        actualizarEmpleadoButtonID.setVisible(true);
    }

    /**
     * Método que se encarga de registrar al empleado en la base de datos
     */
    public void crearEmpleadoOnAction() {
        if(nombreEmpleadoCrearID.getText().isEmpty() || telefonoEmpleadoCrearID.getText().isEmpty() || direccionEmpleadoCrearID.getText().isEmpty() ||
           passEmpleadoCrearID.getText().isEmpty() || passUserCrearEmpleadoID.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Checar que todos los campos estén llenos");
        }
        else{
            if(passUserCrearEmpleadoID.getText().equals(user.getPassword())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    int numEmp = generarNumeroEmpleado();
                    String codEmp = "EMP_" + numEmp;
                    String SQL = "INSERT INTO empleado (codigoEmpleado,nombre,telefono, direccion,password,numEmpleado) values('"+codEmp+"','"+nombreEmpleadoCrearID.getText()+"','"+telefonoEmpleadoCrearID.getText()
                                  +"','"+direccionEmpleadoCrearID.getText()+"','"+passEmpleadoCrearID.getText()+"',"+numEmp+")";
                    c.getStmt().execute(SQL);
                    c.getConn().close();
                    wn.popUpMessage("Registro exitoso","Se creo el empleado: " + codEmp + "\nCon la contraseña: " + passEmpleadoCrearID.getText());
                    nombreEmpleadoCrearID.clear();
                    telefonoEmpleadoCrearID.clear();
                    direccionEmpleadoCrearID.clear();
                    passEmpleadoCrearID.clear();
                    passUserCrearEmpleadoID.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Contraseña incorrecta","La contraseña del gerente\nno es correcta.");
            }
        }
    }

    /**
     * Método que se encarga de borrar al empleado de la base de datos
     */
    public void borrarEmpleadoOnAction() throws SQLException {
        if(borrarEmpleadoID.getText().isEmpty() || passUserBorrarEmpleadoID.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Checar que todos los campos estén llenos");
        }
        else{
            if(passUserBorrarEmpleadoID.getText().equals(user.getPassword()) && checarClaveEmpleado(borrarEmpleadoID.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String sql = "DELETE FROM empleado_departamento where codigoEmpleado='"+borrarEmpleadoID.getText()+"'";
                    c.getStmt().executeUpdate(sql);
                    String sql2 = "DELETE FROM empleado_area where codigoEmpleado='"+borrarEmpleadoID.getText()+"'";
                    c.getStmt().executeUpdate(sql2);
                    String SQL = "DELETE FROM empleado where codigoEmpleado='"+borrarEmpleadoID.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    // FALTA VER COMO BORRAR DE EMPLEADO RESERVACION SIN QUE BORRE LAS RESERVACIONES HECHAS
                    c.getConn().close();
                    wn.popUpMessage("Listo","El empleado fue dado de baja con éxito");
                    borrarEmpleadoID.clear();
                    passUserBorrarEmpleadoID.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Clave no válida","La clave ingresada no existe en\nla base de datos o la contraseña\nno es válida.");
            }
        }
    }

    /**
     * Método que busca al empleado para llenar campos a editar
     */
    public void buscarEmpleadoOnAction() throws SQLException {
        if(claveEditarEmpleadoID.getText().isEmpty()){
            wn.popUpMessage("Ingresar clave","Por favor ingresar una clave\na editar.");
        }
        else{
            if(checarClaveEmpleado(claveEditarEmpleadoID.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "SELECT * FROM empleado where codigoEmpleado='"+claveEditarEmpleadoID.getText()+"'";
                    ResultSet rst = c.getStmt().executeQuery(SQL);
                    while(rst.next()){
                        nombreEmpleadoEditarID.setText(rst.getString("nombre"));
                        telefonoEmpleadoEditarID.setText(rst.getString("telefono"));
                        direccionEmpleadoEditarID.setText(rst.getString("direccion"));
                        passEmpleadoEditarID.setText(rst.getString("password"));
                    }
                    c.getConn().close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Clave no válida","No existe empleado con esa clave");
            }
        }
    }

    /**
     * Método que actualiza los datos del empleado en la BD
     */
    public void actualizarEmpleadoOnAction() {
        if(nombreEmpleadoEditarID.getText().isEmpty() || telefonoEmpleadoEditarID.getText().isEmpty() ||
           direccionEmpleadoEditarID.getText().isEmpty() || passEmpleadoEditarID.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Todos los campos deben de estar llenos para poder\ncontinuar");
        }
        else{
            if(passUserEditarID.getText().equals(user.getPassword())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "UPDATE empleado set nombre='"+nombreEmpleadoEditarID.getText()+"', telefono='"+telefonoEmpleadoEditarID.getText()
                                 +"', direccion='"+direccionEmpleadoEditarID.getText() + "', password='"+passEmpleadoEditarID.getText()+"' where " +
                                 "codigoEmpleado='"+ claveEditarEmpleadoID.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    wn.popUpMessage("Éxito","Los datos fueron actualizados con éxito");
                    nombreEmpleadoEditarID.clear();
                    telefonoEmpleadoEditarID.clear();
                    direccionEmpleadoEditarID.clear();
                    claveClienteReservar.clear();
                    passEmpleadoEditarID.clear();
                    passUserEditarID.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Error","Contraseña no válida. Ingrese una\nque si lo sea.");
            }
        }
    }

    /**
     * Método que muestra la tabla de departamentos
     */
    public void mostrarTablaDep() {
        oblist5.clear();
        esconderElementosEnPantalla();
        tablaDep.getItems().clear();
        tablaDep.setVisible(true);
        try {
            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM departamento ";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while (rst.next()) {
                oblist5.add(new TablaDepartamento(rst.getString("codigoDepartamento"),rst.getString("nombre"),rst.getInt("numEmpleados")));
            }
            c.getConn().close();
        } catch (Exception e) {
            System.out.println(e);
        }
        codigoTablaDep.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nombreTablaDep.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        empleadosTablaDep.setCellValueFactory(new PropertyValueFactory<>("empleados"));
        tablaDep.setItems(oblist5);
    }

    /**
     * Método que muestra la tabla de empleados
     */
    public void mostrarTablaEmp() {
        oblist6.clear();
        esconderElementosEnPantalla();
        tablaEmp.getItems().clear();
        tablaEmp.setVisible(true);
        try {
            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM empleado ";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while (rst.next()) {
                oblist6.add(new TableEmpleado(rst.getString("codigoEmpleado"),rst.getString("nombre"),rst.getString("telefono"),rst.getString("direccion"),
                            rst.getString("password")));
            }
            c.getConn().close();
        } catch (Exception e) {
            System.out.println(e);
        }
        codigoTablaEmp.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nombreTablaEmp.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        telefonoTablaEmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        direccionTablaEmp.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        passwordTablaEmp.setCellValueFactory(new PropertyValueFactory<>("password"));
        tablaEmp.setItems(oblist6);
    }

    /**
     * Método que desbloquea campos para ver las ventas
     */
    public void mostrarVentas() {
        esconderElementosEnPantalla();
        oblist7.clear();
        tableVentas.setVisible(true);
        buscarTableVenta.setVisible(true);
        claveEmpleadoTableVenta.setVisible(true);
        filtroVentaComboBox.setVisible(true);
        filtroVentaComboBox.setItems(filtroVenta);
    }

    /**
     * Método que filtra las ventas
     */
    public void buscarTableVentaOnAction() throws SQLException {
        tableVentas.getItems().clear();
        if(filtroVentaComboBox.getValue() != null){
            if(filtroVentaComboBox.getValue().equals("Todo")){
                try {
                    c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String sql = "SELECT * FROM empleado_reservacion ";
                    c.setPst(c.getConn().prepareStatement(sql));
                    ResultSet rst = c.getPst().executeQuery();
                    while (rst.next()) {
                        oblist7.add(new TableVentas(rst.getString("codigoEmpleado"),rst.getString("codigoReservacion"), rst.getDouble("precio")));
                    }
                    c.getConn().close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                empleadoTableVentas.setCellValueFactory(new PropertyValueFactory<>("empleado"));
                reservacionTableVentas.setCellValueFactory(new PropertyValueFactory<>("claveRes"));
                precioTableVentas.setCellValueFactory(new PropertyValueFactory<>("precio"));
                tableVentas.setItems(oblist7);
            }
            else if(filtroVentaComboBox.getValue().equals("Empleado")){
                if(claveEmpleadoTableVenta.getText().isEmpty()){
                    wn.popUpMessage("Llenar campo","La clave del empleado debe estar llena\npara buscar con este filtro.");
                }
                else{
                    if(checarClaveEmpleado(claveEmpleadoTableVenta.getText())){
                        try {
                            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                            c.setStmt(c.getConn().createStatement());
                            String sql = "SELECT * FROM empleado_reservacion where codigoEmpleado='"+claveEmpleadoTableVenta.getText()+"'";
                            c.setPst(c.getConn().prepareStatement(sql));
                            ResultSet rst = c.getPst().executeQuery();
                            while (rst.next()) {
                                oblist7.add(new TableVentas(rst.getString("codigoEmpleado"),rst.getString("codigoReservacion"), rst.getDouble("precio")));
                            }
                            c.getConn().close();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        empleadoTableVentas.setCellValueFactory(new PropertyValueFactory<>("empleado"));
                        reservacionTableVentas.setCellValueFactory(new PropertyValueFactory<>("claveRes"));
                        precioTableVentas.setCellValueFactory(new PropertyValueFactory<>("precio"));
                        tableVentas.setItems(oblist7);
                        claveEmpleadoTableVenta.clear();
                    }
                    else{
                        wn.popUpMessage("Error","No existe empleado con esa clave.");
                    }
                }
            }
        }
        else{
            wn.popUpMessage("Error","Por favor seleccione un filtro\npara seguir con la búsqueda");
        }
    }

    /**
     * Método que desbloquea campos para crear una nueva area
     */
    public void nuevaArea() {
        esconderElementosEnPantalla();
        nombreNuevaArea.setVisible(true);
        tipoNuevaArea.setVisible(true);
        tipoNuevaArea.setItems(tipoArea);
        numPersonalArea.setVisible(true);
        nuevaAreaButton.setVisible(true);
    }

    /**
     * Método que se encarga de desbloquear campos para editar un area
     */
    public void editarArea() {
        esconderElementosEnPantalla();
        buscarEditarAreaButton.setVisible(true);
        buscarClaveEditarArea.setVisible(true);
        nombreEditarArea.setVisible(true);
        tipoEditarArea.setVisible(true);
        tipoEditarArea.setItems(tipoArea);
        numPersonalEditarArea.setVisible(true);
        actualizarAreaButton.setVisible(true);
    }

    /**
     * Método que desbloquea campos para borrar un area
     */
    public void borrarArea() {
        esconderElementosEnPantalla();
        borrarAreaButton.setVisible(true);
        passBorrarArea.setVisible(true);
        claveBorrarArea.setVisible(true);
    }

    /**
     * Método que regitra el area nueva en la base de datos
     */
    public void nuevaAreaOnAction() {
        if(!nombreNuevaArea.getText().isEmpty() || tipoNuevaArea.getValue() != null || !numPersonalArea.getText().isEmpty()){
            try{
                c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                int nA = generarNumeroArea();
                String claveArea = "AR_"+nA;
                String SQL = "INSERT INTO area (codigoArea,tipo,capacidad,nombre,numArea) values('"+claveArea+"','"+tipoNuevaArea.getValue()+"',"+ Integer.valueOf(numPersonalArea.getText())+
                              ",'"+nombreNuevaArea.getText()+"',"+nA+")";
                c.getStmt().executeUpdate(SQL);
                wn.popUpMessage("Exito","El area fue creada de manera correcta");
                nombreNuevaArea.clear();
                tipoNuevaArea.setValue(null);
                numPersonalArea.clear();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            wn.popUpMessage("Llenar campos","Todos los campos deben de estar llenos para\ncontinuar con el registro.");
        }
    }

    /**
     * Método que busca si existe el area, y si sí, llena los campos a editar
     */
    public void buscarEditarAreaOnAction() throws SQLException {
        if(buscarClaveEditarArea.getText().isEmpty()){
            wn.popUpMessage("Error","Ingrese una clave para realizar la búsqueda");
        }
        else{
            if(checarClaveArea(buscarClaveEditarArea.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "SELECT * FROM area where codigoArea='"+buscarClaveEditarArea.getText()+"'";
                    ResultSet rst = c.getStmt().executeQuery(SQL);
                    while(rst.next()){
                        nombreEditarArea.setText(rst.getString("nombre"));
                        tipoEditarArea.setValue(rst.getString("tipo"));
                        numPersonalEditarArea.setText(String.valueOf(rst.getInt("capacidad")));
                    }
                    c.getConn().close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("No existe","No existe area con esa clave.");
            }
        }
    }

    /**
     * Método que actualiza los valores del area
     */
    public void actualizarAreaOnAction() throws  SQLException {
        if(checarClaveArea(buscarClaveEditarArea.getText())){
            c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String SQL = "UPDATE area set nombre='"+nombreEditarArea.getText()+"', tipo='"+tipoEditarArea.getValue()
                    +"', capacidad="+numPersonalEditarArea.getText() + " where " +
                    "codigoArea='"+ buscarClaveEditarArea.getText()+"'";
            c.getStmt().executeUpdate(SQL);
            c.getConn().close();
            wn.popUpMessage("Éxito","Los datos fueron actualizados con éxito");
            nombreEditarArea.clear();
            buscarClaveEditarArea.clear();
            numPersonalEditarArea.clear();
            tipoEditarArea.setValue(null);
        }
        else{
            wn.popUpMessage("Clave no válida","La clave de area ingresada no es válida");
        }
    }

    /**
     * Método que borra el area deseada de la base de datos
     *
     */
    public void borrarAreaOnAction() throws SQLException {
        if(passBorrarArea.getText().isEmpty() || claveBorrarArea.getText().isEmpty()){
            wn.popUpMessage("Error","Todos los campos deben de estar llenos\npara poder seguir con el proceso.");
        }
        else{
            if(passBorrarArea.getText().equals(user.getPassword()) && checarClaveArea(claveBorrarArea.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "DELETE FROM empleado_area where codigoArea='"+claveBorrarArea.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    String sql = "DELETE FROM area where codigoArea='"+claveBorrarArea.getText()+"'";
                    c.getStmt().executeUpdate(sql);
                    c.getConn().close();
                    wn.popUpMessage("Listo","El area fue dada de baja con éxito");
                    passBorrarArea.clear();
                    claveBorrarArea.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Contraseña incorrecta","La contraseña ingresada es inválida.\nNo corresponde con el usuario,\no la clave de area no es válida. ");
            }
        }
    }

    /**
     * Método que desbloquea campos para ver tabla de areas
     */
    public void mostrarAreas() {
        esconderElementosEnPantalla();
        oblist8.clear();
        tableAreas.setVisible(true);
        tableAreas.getItems().clear();
        filtroTableAreas.setVisible(true);
        buscarTableAreas.setVisible(true);
        filtroTableAreas.setItems(tipoTableArea);
    }

    /**
     * Método que llena la tabla de areas
     */
    public void buscarTableAreasOnAction() {
        tableAreas.getItems().clear();
        String sql;
        if(filtroTableAreas.getValue() != null){
            if(filtroTableAreas.getValue().equals("Todo")){
                sql = "SELECT * FROM area";
            }
            else{
                sql = "SELECT * FROM area where tipo='"+filtroTableAreas.getValue()+"'";
            }
            try {
                c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
                c.setStmt(c.getConn().createStatement());

                c.setPst(c.getConn().prepareStatement(sql));
                ResultSet rst = c.getPst().executeQuery();
                while (rst.next()) {
                    oblist8.add(new TableAreas(rst.getString("codigoArea"),rst.getString("tipo"),rst.getInt("capacidad"),rst.getString("nombre")));
                }
                c.getConn().close();
            } catch (Exception e) {
                System.out.println(e);
            }
            claveTableAreas.setCellValueFactory(new PropertyValueFactory<>("clave"));
            nombreTableAreas.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            personalTableAreas.setCellValueFactory(new PropertyValueFactory<>("personal"));
            tipoTableAreas.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tableAreas.setItems(oblist8);
            filtroTableAreas.setValue(null);
        }
        else{
            wn.popUpMessage("Error","Seleccione un filtro para poder seguir\ncon la búsqueda");
        }
    }

    /**
     * Método que desbloquea campos para crear un nuevo gerente
     */
    public void nuevoGerente() {
        esconderElementosEnPantalla();
        nombreGerenteNuevo.setVisible(true);
        telefonoGerenteNuevo.setVisible(true);
        direccionGerenteNuevo.setVisible(true);
        horaEntGerenteNuevo.setVisible(true);
        horaSalidaGerenteNuevo.setVisible(true);
        crearGerente.setVisible(true);
        passGerenteNuevo.setVisible(true);
    }

    /**
     * Método que desbloquea los campos para editar al gerente
     */
    public void editarGerente() {
        esconderElementosEnPantalla();
        nombreGerenteEditar.setVisible(true);
        telefonoGerenteEditar.setVisible(true);
        direccionGerenteEditar.setVisible(true);
        horaEntGerenteEditar.setVisible(true);
        horaSalidaGerenteEditar.setVisible(true);
        actualizarGerenteButton.setVisible(true);
        buscarGerenteEditar.setVisible(true);
        claveGerenteEditar.setVisible(true);
    }

    /**
     * Método que desbloquea campos para borrar gerentes
     */
    public void borrarGerente() {
        esconderElementosEnPantalla();
        borrarClaveGerente.setVisible(true);
        passBorrarGerente.setVisible(true);
        borrarGerenteBoton.setVisible(true);
    }

    /**
     * Método que registra en la BD a un nuevo gerente
     */
    public void crearGerenteOnAction() {
        if(nombreGerenteNuevo.getText().isEmpty() || telefonoGerenteNuevo.getText().isEmpty() || direccionGerenteNuevo.getText().isEmpty() ||
           horaEntGerenteNuevo.getText().isEmpty() || horaSalidaGerenteNuevo.getText().isEmpty() || passGerenteNuevo.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Todos los campos deben de estar llenos\npara poder seguir con el registro.");
        }
        else{
            try{
                c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                c.setStmt(c.getConn().createStatement());
                int nG = generarNumeroGerente();
                String claveGer = "GER_"+nG;
                String sql = "INSERT INTO gerente(codigoGerente,nombre,telefono,direccion,horaEntrada,horaSalida,password,numGerente) "+
                              "values('"+claveGer+"','"+nombreGerenteNuevo.getText()+"','"+telefonoGerenteNuevo.getText()+"','"+
                              direccionGerenteNuevo.getText()+"','"+horaEntGerenteNuevo.getText()+"','"+horaSalidaGerenteNuevo.getText()+"','"+
                              passGerenteNuevo.getText()+"',"+nG+")";
                c.getStmt().executeUpdate(sql);
                c.getConn().close();
                wn.popUpMessage("Registro exitoso","Se creo el gerente: " + claveGer + "\nCon la contraseña: " + passGerenteNuevo.getText());
                nombreGerenteNuevo.clear();
                telefonoGerenteNuevo.clear();
                direccionGerenteNuevo.clear();
                horaSalidaGerenteNuevo.clear();
                horaEntGerenteNuevo.clear();
                passGerenteNuevo.clear();
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    /**
     * Método que muestra la tabla de los gerentes
     */
    public void mostrarGerentes() {
        oblist9.clear();
        esconderElementosEnPantalla();
        tableGer.getItems().clear();
        tableGer.setVisible(true);
        try {
            c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String sql = "SELECT * FROM gerente";
            c.setPst(c.getConn().prepareStatement(sql));
            ResultSet rst = c.getPst().executeQuery();
            while (rst.next()) {
                oblist9.add(new TableGerentes(rst.getString("codigoGerente"),rst.getString("nombre"),rst.getString("telefono"),
                            rst.getString("direccion"),rst.getString("horaEntrada"),rst.getString("horaSalida"),rst.getString("password")));
            }
            c.getConn().close();
        } catch (Exception e) {
            System.out.println(e);
        }
        claveTableGer.setCellValueFactory(new PropertyValueFactory<>("codigoGerente"));
        nombreTableGer.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        telefTableGer.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        direccionTableGer.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        horaEntTableGer.setCellValueFactory(new PropertyValueFactory<>("horaEnt"));
        horaSalidaTableGer.setCellValueFactory(new PropertyValueFactory<>("horaSal"));
        passTableGer.setCellValueFactory(new PropertyValueFactory<>("pass"));
        tableGer.setItems(oblist9);

    }

    /**
     * Método que borra gerentes
     */
    public void borrarGerenteOnAction() throws SQLException {
        if(borrarClaveGerente.getText().isEmpty() || passBorrarGerente.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Todos los campos deben de estar llenos\npara poder continuar con el proceso.");
        }
        else{
            if(passBorrarGerente.getText().equals(user.getPassword()) && checarClaveGerente(borrarClaveGerente.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "DELETE FROM gerente_departamento where codigoGerente='"+borrarClaveGerente.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    String sql = "DELETE FROM gerente where codigoGerente='"+borrarClaveGerente.getText()+"'";
                    c.getStmt().executeUpdate(sql);
                    c.getConn().close();
                    wn.popUpMessage("Listo","El gerente fue dado de baja con éxito");
                    borrarClaveGerente.clear();
                    passBorrarGerente.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Contraseña equivocada","La contraseña ingresada no es válida, o\nla clave de gerente no es válida.");
            }
        }
    }

    /**
     * Método que busca al gerente y llena los campos para editar
     */
    public void buscarGerenteOnAction() throws SQLException {
        if(!claveGerenteEditar.getText().isEmpty()){
            if(checarClaveGerente(claveGerenteEditar.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "SELECT * FROM gerente where codigoGerente='"+claveGerenteEditar.getText()+"'";
                    ResultSet rst = c.getStmt().executeQuery(SQL);
                    while(rst.next()){
                        nombreGerenteEditar.setText(rst.getString("nombre"));
                        telefonoGerenteEditar.setText(rst.getString("telefono"));
                        direccionGerenteEditar.setText(rst.getString("direccion"));
                        horaEntGerenteEditar.setText(rst.getString("horaEntrada"));
                        horaSalidaGerenteEditar.setText(rst.getString("horaSalida"));
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("No existe clave","La clave ingresada no existe");
            }
        }
        else{
            wn.popUpMessage("Error","Debe de poner una clave para poder hacer la búsqueda.");
        }
    }

    /**
     * Método que actualiza los datos del gerente
     */
    public void actualizarGerenteOnAction() throws SQLException {
        if(nombreGerenteEditar.getText().isEmpty() || telefonoGerenteEditar.getText().isEmpty() || direccionGerenteEditar.getText().isEmpty() ||
           horaEntGerenteEditar.getText().isEmpty() || horaSalidaGerenteEditar.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Todos los campos deben de estar llenos\npara continuar con el proceso");
        }
        else{
            if(checarClaveGerente(claveGerenteEditar.getText())){
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "UPDATE gerente set nombre='"+nombreGerenteEditar.getText()+"', telefono='"+telefonoGerenteEditar.getText()+
                                 "', direccion='"+direccionGerenteEditar.getText()+"', horaEntrada='"+horaEntGerenteEditar.getText()+
                                 "', horaSalida='"+horaSalidaGerenteEditar.getText()+"' where codigoGerente='"+claveGerenteEditar.getText()+"'";
                    c.getStmt().executeUpdate(SQL);
                    c.getConn().close();
                    wn.popUpMessage("Éxito","Los datos fueron actualizados con éxito");
                    nombreGerenteEditar.clear();
                    telefonoGerenteEditar.clear();
                    direccionGerenteEditar.clear();
                    horaSalidaGerenteEditar.clear();
                    horaEntGerenteEditar.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                wn.popUpMessage("Error","La clave no existe");
            }
        }
    }

    /**
     * Método que desbloquea campos para asignar el empleado a un departamento
     */
    public void empleadoDepartamentoOnAction() {
        esconderElementosEnPantalla();
        claveEmpleadoDepa.setVisible(true);
        claveDepaDepa.setVisible(true);
        puestoEmpDepa.setVisible(true);
        sueldoEmpDepa.setVisible(true);
        addEmpleadoDepa.setVisible(true);
    }

    /**
     * Método que registra el empleado con el departamento
     */
    public void addEmpleadoDepaOnAction() throws SQLException {
        if(claveEmpleadoDepa.getText().isEmpty() || claveDepaDepa.getText().isEmpty() || puestoEmpDepa.getText().isEmpty() ||
           sueldoEmpDepa.getText().isEmpty()){
            wn.popUpMessage("Llenar campos","Todos los campos debene de estar llenos\npara continuar");
        }
        else{
            if(checarEmpleadoDepartamento(claveEmpleadoDepa.getText(),claveDepaDepa.getText())){
                wn.popUpMessage("Error","Este empleado ya fue añadido a este departamento");
            }
            else{
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "INSERT INTO empleado_departamento (codigoEmpleado,codigoDepartamento,puesto,sueldo) values('"+
                                 claveEmpleadoDepa.getText()+"','"+claveDepaDepa.getText()+"','"+puestoEmpDepa.getText()+"',"+
                                 sueldoEmpDepa.getText()+")";
                    c.getStmt().executeUpdate(SQL);
                    wn.popUpMessage("Asignado con éxito","El empleado fue asignado con éxito");
                    claveEmpleadoDepa.clear();
                    claveDepaDepa.clear();
                    puestoEmpDepa.clear();
                    sueldoEmpDepa.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }

    }

    /**
     * Métod que desbloquea campos para asginar un gerente a un departamento
     */
    public void gerenteDepartamentoOnAction() {
        esconderElementosEnPantalla();
        codigoGerGerDepa.setVisible(true);
        sueldoGerDepa.setVisible(true);
        codigoDepaGerDepa.setVisible(true);
        registrarGerDepaButton.setVisible(true);
    }

    /**
     * Método que registra gerente con un departamento
     */
    public void registrarGerDepaOnAction() throws SQLException {
        if(codigoGerGerDepa.getText().isEmpty() || sueldoGerDepa.getText().isEmpty() || codigoDepaGerDepa.getText().isEmpty()){
            wn.popUpMessage("Error","Todos los campos deben de estar llenos\npara seguir con el proceso.");
        }
        else{
            if(checarClaveDepartamento(codigoDepaGerDepa.getText()) && checarClaveGerente(codigoGerGerDepa.getText())){
                if(checarGerenteEnDepartamento(codigoGerGerDepa.getText()) || checsrDepartamentoConGerente(codigoDepaGerDepa.getText())){
                    wn.popUpMessage("Error","Ya fue asignado el gerente a un departamento,o \nal departamento ya se le fue asignado un gerente");
                }
                else{
                    try{
                        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                        c.setStmt(c.getConn().createStatement());
                        String SQL = "INSERT INTO gerente_departamento(codigoGerente,codigoDepartamento,sueldo) values('"+
                                codigoGerGerDepa.getText()+"','"+codigoDepaGerDepa.getText()+"',"+sueldoGerDepa.getText()+")";
                        c.getStmt().executeUpdate(SQL);
                        wn.popUpMessage("Exito","El gerente fue registrado con éxito");
                        codigoDepaGerDepa.clear();
                        sueldoGerDepa.clear();
                        codigoGerGerDepa.clear();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
            else{
                wn.popUpMessage("Error","No existe el gerente o el departamento");
            }

        }
    }

    /**
     * Método que desbloquea campos para poder asignar un empleado a un area
     */
    public void empleadoAreaOnAction() {
        esconderElementosEnPantalla();
        codigoEmpEmpArea.setVisible(true);
        codigoAreaEmpArea.setVisible(true);
        horarioEmpArea.setVisible(true);
        registrarEmpAreaButton.setVisible(true);
    }

    /**
     * Métood que registra empleado con area
     */
    public void registrarEmpAreaOnAction() throws SQLException {
        if(codigoAreaEmpArea.getText().isEmpty() || codigoEmpEmpArea.getText().isEmpty() || horarioEmpArea.getText().isEmpty()){
            wn.popUpMessage("Error","Todos los campos deben estar llenos\npara continuar con el proceso.");
        }
        else{
            if(checarSiEmpleadoArea(codigoEmpEmpArea.getText(),codigoAreaEmpArea.getText())){
                wn.popUpMessage("Error","El empleado ya fue asignado a esta area");
            }
            else{
                try{
                    c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
                    c.setStmt(c.getConn().createStatement());
                    String SQL = "INSERT INTO empleado_area(codigoEmpleado,codigoArea,horario) values('"+
                                 codigoEmpEmpArea.getText()+"','"+codigoAreaEmpArea.getText()+"','"+horarioEmpArea.getText()+"')";
                    c.getStmt().executeUpdate(SQL);
                    wn.popUpMessage("Exito","El empleado y el area fueron registrados con éxito");
                    codigoAreaEmpArea.clear();
                    codigoEmpEmpArea.clear();
                    horarioEmpArea.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    /**
     * Método que muestra la tabla de empleado_departamento
     */
    public void verEmpleadoDepaOnAction() {
        esconderElementosEnPantalla();
        oblist10.clear();
        tablaEmpleadoDepa.setVisible(true);
        tablaEmpleadoDepa.getItems().clear();
        try{
            c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
            c.setStmt(c.getConn().createStatement());
            String SQL = "SELECT * FROM empleado_departamento";
            c.setPst(c.getConn().prepareStatement(SQL));
            ResultSet rst = c.getPst().executeQuery();
            while(rst.next()){
                oblist10.add(new TableEmpleadoDepa(rst.getString("codigoEmpleado"),rst.getString("codigoDepartamento"),
                             rst.getString("puesto"),rst.getDouble("sueldo")));
            }
            c.getConn().close();
            claveEmpTableEmpDepa.setCellValueFactory(new PropertyValueFactory<>("claveEmpleado"));
            claveDepaTableEmpDepa.setCellValueFactory(new PropertyValueFactory<>("claveDepa"));
            puestoTableEmpDepa.setCellValueFactory(new PropertyValueFactory<>("puesto"));
            sueldoTableEmpDepa.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
            tablaEmpleadoDepa.setItems(oblist10);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    // ************************************************************************************//
    // <!--------------------------FUNCIONES QUE HACEN QUERIES--------------------------!> //
    // ************************************************************************************//

    /**
     * Método que checa el último número de cliente registrado
     *
     * @return número del último cliente +1
     * @throws SQLException exception
     */
    public int generarNumeroCliente() throws SQLException {
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT * FROM cliente";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while (rst.next()) {
            nc = rst.getInt("numCliente");
        }
        return nc + 1;
    }

    /**
     * Método que checa en la base de datos si existe el cliente
     *
     * @param clave clave de cliente
     * @return true si existe cliente en base de datos, else false
     * @throws SQLException exception
     */
    public boolean checarSiClienteExiste(String clave) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT * FROM cliente";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (clave.equals(rs.getString("codigoCliente"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que checa en la base de datos si existe el cliente
     *
     * @param clave clave de la reservación
     * @return true si existe reservación, else false
     * @throws SQLException exception
     */
    public boolean checarSiReservacionExiste(String clave) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT * FROM reservacion";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (clave.equals(rs.getString("codigoReservacion"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que genera el numero de una nueva reservacion
     *
     * @return numero de reservacion
     * @throws SQLException exception
     */
    public int generarNumeroReservacion() throws SQLException {
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT * FROM reservacion";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while (rst.next()) {
            nc = rst.getInt("numRes");
        }
        return nc + 1;
    }

    /**
     * Método que checa si a la reservación ya se le hizo check in
     * @return false si no está asignada, else true
     */
    public boolean checarSiReservacionAsignada(String res) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoReservacion from reservacion_habitacion";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (res.equals(rs.getString("codigoReservacion"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que regresa la habitación con la cantidad de personas deseada
     * @return numero de habitación, o notFound si no hay disponibles
     */
    public String asignarHabitacion(String [] d) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "select codigoHabitacion,tipo,capacidad from habitacion where disponible = 'D' and tipo='"+d[1]+"' and capacidad = " + Integer.valueOf(d[0]);
        ResultSet rs = c.getPst().executeQuery(SQL);
        if(rs.next()){
            return rs.getString("codigoHabitacion");
        }
        c.getConn().close();
        return "notFound";
    }

    /**
     * Método que regresa el número de personas de la reservación y el tipo
     * @param res numero de reservacion
     * @return [0] --> numero de personas, [1] --> tipo
     * @throws SQLException exception
     */
    public String [] buscarNumeroPersonasYTipoReservacion(String res) throws SQLException {
        String[] datos = new String [2];
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoReservacion,numPersonas,tipo from cliente_reservacion";
        ResultSet rs = c.getPst().executeQuery(SQL);
        while(rs.next()){
            if(res.equals(rs.getString("codigoReservacion"))){
                datos[0] = String.valueOf(rs.getInt("numPersonas"));
                datos[1] = rs.getString("tipo");
                return datos;
            }
        }
        c.getConn().close();
        return null; // nunca llegará a esto porque ya se validó que la reservación exista
    }

    /**
     * Método que regresa la habitación asignada a la reservación
     * @param clave codigo de la reservacion
     * @return clave de la habitación
     * @throws SQLException exception
     */
    public String obtenerHabitacionAsignada(String clave) throws SQLException{
        String codHab="";
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoHabitacion FROM reservacion_habitacion where codigoReservacion='"+clave+"'";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        if(rs.next()){
            codHab = rs.getString("codigoHabitacion");
        }
        return codHab;
    }

    /**
     * Método que regresa el numero a crear del nuevo departamento
     * @return nuevo numeroDep
     * @throws SQLException exception
     */
    public int generarNumeroDepartamento() throws  SQLException{
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT numeroDepartamento FROM departamento";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while (rst.next()) {
            nc = rst.getInt("numeroDepartamento");
        }
        return nc + 1;
    }

    /**
     * Checar si la clave ingresada existe
     * @param clave clave de departamento
     * @return true if exists, else false
     */
    public boolean checarClaveDepartamento(String clave) throws SQLException{
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoDepartamento from departamento";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (clave.equals(rs.getString("codigoDepartamento"))) {
                return true;
            }
        }
        return false;

    }

    /**
     * Método que busca el último numero de empleado registrado y regresa el siguiente número
     * @return n = numero de empleado nuevo
     * @throws SQLException exception
     */
    public int generarNumeroEmpleado() throws SQLException{
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT numEmpleado FROM empleado";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while (rst.next()) {
            nc = rst.getInt("numEmpleado");
        }
        return nc + 1;
    }

    /**
     * Método que checa si existe la clave del empleado
     * @param clave clave del empleado
     * @return true si existe, else false
     * @throws SQLException exception
     */
    public boolean checarClaveEmpleado(String clave) throws  SQLException{
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoEmpleado from empleado";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (clave.equals(rs.getString("codigoEmpleado"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que busca el último numero de area registrado y regresa el siguiente número
     * @return n = numero de area nueva
     * @throws SQLException exception
     */
    public int generarNumeroArea() throws SQLException{
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT numArea FROM area";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while (rst.next()) {
            nc = rst.getInt("numArea");
        }
        return nc + 1;
    }

    /**
     * Método que checa si existe la clave area ingresada
     * @param clave clave del area
     * @return true si existe, else false
     * @throws SQLException exception
     */
    public boolean checarClaveArea(String clave) throws  SQLException{
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoArea from area";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (clave.equals(rs.getString("codigoArea"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que busca el último numero de gerente registrado y regresa el siguiente número
     * @return n = numero de gerente nuevo
     * @throws SQLException exception
     */
    public int generarNumeroGerente() throws  SQLException{
        int nc = 0;
        c.setConn(DriverManager.getConnection(c.getDB_URL(), c.getUSER(), c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String sql = "SELECT numGerente FROM gerente";
        c.setPst(c.getConn().prepareStatement(sql));
        ResultSet rst = c.getPst().executeQuery();
        while (rst.next()) {
            nc = rst.getInt("numGerente");
        }
        return nc + 1;
    }

    /**
     * Método que checa si existe gerente con la clave dada
     * @param clave clave de gerente
     * @return true si existe, else false
     * @throws SQLException exception
     */
    public boolean checarClaveGerente(String clave) throws  SQLException{
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoGerente from gerente";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (clave.equals(rs.getString("codigoGerente"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que checa si empleado ya fue asignado a departamento
     * @param c1 codigoEmpleado
     * @param c2 codigoDepartamento
     * @return true si ya fue, else false
     * @throws SQLException exception
     */
    public boolean checarEmpleadoDepartamento(String c1,String c2) throws SQLException{
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoEmpleado, codigoDepartamento from empleado_departamento";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (c1.equals(rs.getString("codigoEmpleado")) && c2.equals(rs.getString("codigoGerente"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que checa si un gerente ya fue asignado a un departamento
     * c1 = codigo del gerente
     * @return true si sí, else false
     */
    public boolean checarGerenteEnDepartamento(String c1) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoGerente from gerente_departamento";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (c1.equals(rs.getString("codigoGerente"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que checa si a un departamento ya se le fue asignado un gerente
     * c1 = codigo del departamento
     * @return true si sí, else false
     */
    public boolean checsrDepartamentoConGerente(String c1) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoDepartamento from gerente_departamento";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (c1.equals(rs.getString("codigoDepartamento"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que checa si un empleado ya fue asignado a un area
     * c1 = clave empleado, c2 = clave area
     * @return true si ya está asignado, else false
     */
    public boolean checarSiEmpleadoArea(String c1,String c2) throws SQLException {
        c.setConn(DriverManager.getConnection(c.getDB_URL(),c.getUSER(),c.getPASS()));
        c.setStmt(c.getConn().createStatement());
        String SQL = "SELECT codigoEmpleado, codigoArea from empleado_area";
        c.setPst(c.getConn().prepareStatement(SQL));
        ResultSet rs = c.getPst().executeQuery();
        while (rs.next()) {
            if (c1.equals(rs.getString("codigoEmpleado")) && c2.equals(rs.getString("codigoArea"))) {
                return true;
            }
        }
        return false;
    }

    // ****************************************************************************//
    // <!--------------------------FUNCIONES DE AYUDA--------------------------!> //
    // ***************************************************************************//

    /**
     * Método que regresa los filtros con los que se hará el query en la base de datos
     *
     * @param f1 campo de filtro 1 capacidad
     * @param f2 campo de filtro 2 tipo
     * @param f3 campo de filtro 3 status
     * @return filtro
     */
    public String obtenerFiltroHabitacion(String f1, String f2, String f3) {
        if (f3.equals("Disponible")) {
            f3 = "D";
        } else if (f3.equals("Ocupada")) {
            f3 = "O";
        }

        if (f1.equals("Todo") || f2.equals("Todo") || f3.equals("Todo")) {
            if (f1.equals("Todo") && f2.equals("Todo") && f3.equals("Todo")) {
                return "SELECT * FROM habitacion";
            } else if (f1.equals("Todo") && f2.equals("Todo")) {
                return "SELECT * FROM habitacion where disponible='" + f3 + "'";
            } else if (f1.equals("Todo") && f3.equals("Todo")) {
                return "SELECT * FROM habitacion where tipo='" + f2 + "'";
            } else if (f2.equals("Todo") && f3.equals("Todo")) {
                return "SELECT * FROM habitacion where capacidad='" + f1 + "'";
            } else if (f1.equals("Todo")) {
                return "SELECT * from habitacion where tipo='" + f2 + "' and disponible='" + f3 + "'";
            } else if (f2.equals("Todo")) {
                return "SELECT * from habitacion where capacidad=" + f1 + " and disponible='" + f3 + "'";
            } else {
                return "SELECT * from habitacion where capacidad=" + f1 + " and tipo='" + f2 + "'";
            }
        } else {
            return "SELECT * from habitacion where capacidad=" + f1 + " and tipo='" + f2 + "' and disponible='" + f3 + "'";
        }
    }

    /**
     * Botón de hacer check-in
     * @throws SQLException exception
     */
    public void registrarCheckIn() throws SQLException {
        hacerCheckIn();
    }

    /**
    * Botón de hacer check-out
     */
    public void registrarCheckOut() throws SQLException{
        hacerCheckOut();
    }

    /**
     * Método que esconde todos los campos
     */
    public void esconderElementosEnPantalla() {
        nombreHuespedID.setVisible(false);
        nombreHuespedID.clear();
        aPHuespedID.setVisible(false);
        aPHuespedID.clear();
        aMHuespedId.setVisible(false);
        aMHuespedId.clear();
        telHuespedID.setVisible(false);
        telHuespedID.clear();
        nacionalidadID.setVisible(false);
        nacionalidadID.clear();
        buscarHuespedID.setVisible(false);
        codigoClienteID.setVisible(false);
        codigoClienteID.clear();
        actualizarID.setVisible(false);
        guardarHuesped.setVisible(false);
        tablaClientesID.setVisible(false);
        claveClienteReservar.setVisible(false);
        claveClienteReservar.clear();
        numPersonasReservar.setVisible(false);
        numPersonasReservar.clear();
        tipoReservar.setVisible(false);
        tipoReservar.setValue(null);
        reservarBoton.setVisible(false);
        fechaLlegadaReservacion.setVisible(false);
        fechaLlegadaReservacion.setValue(null);
        fechaSalidaReservacion.setVisible(false);
        fechaSalidaReservacion.setValue(null);
        tablaRes.setVisible(false);
        codigoCancelarReservacionID.setVisible(false);
        codigoCancelarReservacionID.clear();
        cancelarReservacionBoton.setVisible(false);
        passwordCancelarReservacionID.setVisible(false);
        passwordCancelarReservacionID.clear();
        filtroStatusComboBoxID.setVisible(false);
        filtroStatusComboBoxID.setValue(null);
        filtroCapacidadComboBoxID.setVisible(false);
        filtroCapacidadComboBoxID.setValue(null);
        filtroTipoComboBoxID.setVisible(false);
        filtroTipoComboBoxID.setValue(null);
        habitacionesTableID.setVisible(false);
        filtrarID.setVisible(false);
        registrarCheckInID.setVisible(false);
        fechaCheckInID.setVisible(false);
        fechaCheckInID.setValue(null);
        codigoCheckInID.setVisible(false);
        codigoCheckInID.clear();
        checkOutButton.setVisible(false);
        passwCheckOut.setVisible(false);
        passwCheckOut.clear();
        codigoResCheckOut.setVisible(false);
        codigoResCheckOut.clear();
        fechaSalidaCheckOut.setVisible(false);
        fechaSalidaCheckOut.setValue(null);
        tablaHuespedActivo.setVisible(false);
        nombreDepID.setVisible(false);
        nombreDepID.clear();
        passDepID.setVisible(false);
        passDepID.clear();
        registrarDepID.setVisible(false);
        claveDepID.setVisible(false);
        claveDepID.clear();
        buscarClaveDep.setVisible(false);
        actNombreDep.setVisible(false);
        actNombreDep.clear();
        actDep.setVisible(false);
        borrarClaveDepID.setVisible(false);
        borrarClaveDepID.clear();
        passBorrarDepID.setVisible(false);
        passBorrarDepID.clear();
        borrarDepID.setVisible(false);
        nombreEmpleadoCrearID.setVisible(false);
        nombreEmpleadoCrearID.clear();
        telefonoEmpleadoCrearID.setVisible(false);
        telefonoEmpleadoCrearID.clear();
        direccionEmpleadoCrearID.setVisible(false);
        direccionEmpleadoCrearID.clear();
        passEmpleadoCrearID.setVisible(false);
        passEmpleadoCrearID.clear();
        passUserCrearEmpleadoID.setVisible(false);
        passUserCrearEmpleadoID.clear();
        crearEmpleadoButton.setVisible(false);
        borrarEmpleadoID.setVisible(false);
        borrarEmpleadoID.clear();
        passUserBorrarEmpleadoID.setVisible(false);
        passUserBorrarEmpleadoID.clear();
        borrarEmpleadoButtonID.setVisible(false);
        nombreEmpleadoEditarID.setVisible(false);
        nombreEmpleadoEditarID.clear();
        telefonoEmpleadoEditarID.setVisible(false);
        telefonoEmpleadoEditarID.clear();
        direccionEmpleadoEditarID.setVisible(false);
        direccionEmpleadoEditarID.clear();
        passEmpleadoEditarID.setVisible(false);
        passEmpleadoEditarID.clear();
        claveEditarEmpleadoID.setVisible(false);
        claveEditarEmpleadoID.clear();
        buscarEmpleadoButton.setVisible(false);
        passUserEditarID.setVisible(false);
        passUserEditarID.clear();
        actualizarEmpleadoButtonID.setVisible(false);
        tablaDep.setVisible(false);
        tablaEmp.setVisible(false);
        tableVentas.setVisible(false);
        buscarTableVenta.setVisible(false);
        claveEmpleadoTableVenta.setVisible(false);
        claveEmpleadoTableVenta.clear();
        filtroVentaComboBox.setVisible(false);
        filtroVentaComboBox.setValue(null);
        nombreNuevaArea.setVisible(false);
        nombreNuevaArea.clear();
        tipoNuevaArea.setVisible(false);
        tipoNuevaArea.setValue(null);
        numPersonalArea.setVisible(false);
        numPersonalArea.clear();
        nuevaAreaButton.setVisible(false);
        tableAreas.setVisible(false);
        filtroTableAreas.setVisible(false);
        filtroTableAreas.setValue(null);
        buscarTableAreas.setVisible(false);
        borrarAreaButton.setVisible(false);
        passBorrarArea.setVisible(false);
        passBorrarArea.clear();
        claveBorrarArea.setVisible(false);
        claveBorrarArea.clear();
        buscarEditarAreaButton.setVisible(false);
        buscarClaveEditarArea.setVisible(false);
        buscarClaveEditarArea.clear();
        nombreEditarArea.setVisible(false);
        nombreEditarArea.clear();
        tipoEditarArea.setVisible(false);
        tipoEditarArea.setValue(null);
        numPersonalEditarArea.setVisible(false);
        numPersonalEditarArea.clear();
        actualizarAreaButton.setVisible(false);
        nombreGerenteNuevo.setVisible(false);
        nombreGerenteNuevo.clear();
        telefonoGerenteNuevo.setVisible(false);
        telefonoGerenteNuevo.clear();
        direccionGerenteNuevo.setVisible(false);
        direccionGerenteNuevo.clear();
        horaEntGerenteNuevo.setVisible(false);
        horaEntGerenteNuevo.clear();
        horaSalidaGerenteNuevo.setVisible(false);
        horaSalidaGerenteNuevo.clear();
        crearGerente.setVisible(false);
        passGerenteNuevo.setVisible(false);
        passGerenteNuevo.clear();
        tableGer.setVisible(false);
        borrarClaveGerente.setVisible(false);
        borrarClaveGerente.clear();
        passBorrarGerente.setVisible(false);
        passBorrarGerente.clear();
        borrarGerenteBoton.setVisible(false);
        nombreGerenteEditar.setVisible(false);
        nombreGerenteEditar.clear();
        telefonoGerenteEditar.setVisible(false);
        telefonoGerenteEditar.clear();
        direccionGerenteEditar.setVisible(false);
        direccionGerenteEditar.clear();
        horaEntGerenteEditar.setVisible(false);
        horaEntGerenteEditar.clear();
        horaSalidaGerenteEditar.setVisible(false);
        horaSalidaGerenteEditar.clear();
        actualizarGerenteButton.setVisible(false);
        buscarGerenteEditar.setVisible(false);
        claveGerenteEditar.setVisible(false);
        claveGerenteEditar.clear();
        claveEmpleadoDepa.setVisible(false);
        claveEmpleadoDepa.clear();
        claveDepaDepa.setVisible(false);
        claveDepaDepa.clear();
        puestoEmpDepa.setVisible(false);
        puestoEmpDepa.clear();
        sueldoEmpDepa.setVisible(false);
        sueldoEmpDepa.clear();
        addEmpleadoDepa.setVisible(false);
        codigoGerGerDepa.setVisible(false);
        codigoGerGerDepa.clear();
        sueldoGerDepa.setVisible(false);
        sueldoGerDepa.clear();
        codigoDepaGerDepa.setVisible(false);
        codigoDepaGerDepa.clear();
        registrarGerDepaButton.setVisible(false);
        codigoEmpEmpArea.setVisible(false);
        codigoEmpEmpArea.clear();
        codigoAreaEmpArea.setVisible(false);
        codigoAreaEmpArea.clear();
        horarioEmpArea.setVisible(false);
        horarioEmpArea.clear();
        registrarEmpAreaButton.setVisible(false);
        tablaEmpleadoDepa.setVisible(false);
    }
}





