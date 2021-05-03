package Tools;
import java.util.Date;

public class User {
    private static String username="";
    private static String password="";
    private static String date;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        User.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        User.date = date;
    }
}
