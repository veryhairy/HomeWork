package bean;

/**
 * Created by fwj on 2018/1/15.
 */
public class User {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserAction{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }
}
