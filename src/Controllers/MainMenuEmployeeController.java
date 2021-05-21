package Controllers;

import Tools.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private final ConTool c = new ConTool();
    private final User user = new User();

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

    private final ObservableList<String> tipoHab = FXCollections.observableArrayList("Sencilla", "Doble", "Premium"); // corregir esto

    private final ObservableList<String> filtroHab = FXCollections.observableArrayList("Sencilla", "Doble", "Premium", "Todo");

    private final ObservableList<String> capHab = FXCollections.observableArrayList("1", "2", "3", "4", "Todo");

    private final ObservableList<String> statusHab = FXCollections.observableArrayList("Disponible", "Ocupada", "Todo");

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
     * Método que desbloquea campos cuando se le da click a Reservacion -> Nueva
     */
    public void nuevaReservacionOnAction() {
        esconderElementosEnPantalla();
        claveClienteReservar.clear();
        fechaLlegadaReservacion.setValue(null);
        fechaSalidaReservacion.setValue(null);
        numPersonasReservar.clear();
        tipoReservar.setValue(null);
        claveClienteReservar.setVisible(true);
        fechaSalidaReservacion.setVisible(true);
        fechaLlegadaReservacion.setVisible(true);
        numPersonasReservar.setVisible(true);
        tipoReservar.setVisible(true);
        tipoReservar.setItems(tipoHab);
        reservarBoton.setVisible(true);
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
     * Método que desbloquea campos para cancelar reservación
     */
    public void cancelarResOnAction() {
        esconderElementosEnPantalla();
        cancelarReservacionBoton.setVisible(true);
        codigoCancelarReservacionID.setVisible(true);
        passwordCancelarReservacionID.setVisible(true);
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
                        String sql = "UPDATE habitacion SET disponible='D' where codigoHabitacion='"+codHab+"'";
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
    }

}