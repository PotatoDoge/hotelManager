package Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Con {

    private static String USER = ""; //this will be set in the gui
    private static String PASS = ""; //this will be set in the gui
    private static Statement stmt = null;
    private static Connection conn = null;
    private static PreparedStatement pst = null;
    private static String SQLTable = "hotelManager"; // this is set to be changed to the db's name once the system checks if it exists
    private static String databaseName = "hotelManager"; // change to a valid db name
    private static String address = "";
    private static String DB_URL = "";

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        Con.USER = USER;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        Con.databaseName = databaseName;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        Con.PASS = PASS;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        Con.stmt = stmt;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        Con.conn = conn;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        Con.pst = pst;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        Con.DB_URL = DB_URL;
    }

    public String getSQLTABLE(){
        return SQLTable;
    }
    public void setSQLTable(String SQLTABLE){
        SQLTable = SQLTABLE;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        Con.address = address;
        DB_URL = "jdbc:mariadb://"+address+"/"+SQLTable+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    }
}
