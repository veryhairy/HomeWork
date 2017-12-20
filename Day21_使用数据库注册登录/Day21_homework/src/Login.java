import java.sql.*;
import java.util.Scanner;

public class Login {
    public static void login() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/day18homework" + "?user=root&password=123");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        PreparedStatement prepare = connection.prepareStatement("SELECT password FROM register WHERE name=?AND password=?");
        prepare.setString(1,name);
        prepare.setString(2,password);
        boolean execute = prepare.execute();
        if (execute){
            System.out.println("登陆成功");
        }
        prepare.close();
        connection.close();

    }
}
