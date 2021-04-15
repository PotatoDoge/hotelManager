package Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Con {

    static final String USER = ""; //this will be set in the gui
    static final String PASS = ""; //this will be set in the gui
    static Statement stmt = null;
    static Connection conn = null;
    static PreparedStatement pst = null;
    static String SQLTable = "mysql"; // this is set to be changed to the db's name once the system checks if it exists
    static final String databaseName = "hotelManager"; // change to a valid db name
    static String DB_URL = "jdbc:mysql://localhost/"+SQLTable+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

}
