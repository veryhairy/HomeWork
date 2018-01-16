package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import service.UserService;

/**
 * Created by fwj on 2018/1/16.
 */
public class UserAction extends ActionSupport{
    private String username;
    private String password;
    private int number;
    private String email;
      private   UserService userService = new UserService();
    public String insert(){
        userService.insert(username,password,number,email);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(username+password+number+email);
        return super.execute();
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
