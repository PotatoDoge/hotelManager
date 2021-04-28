package Tools;

public class User {
    private static String username="";
    private static String password="";
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
}
