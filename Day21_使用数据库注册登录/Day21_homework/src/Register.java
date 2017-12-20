import java.sql.*;
import java.util.Scanner;

public class Register {
    public static void register() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/day18homework" + "?user=root&password=123");

//        Statement statement = connection.createStatement();
//
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
//
//        String sql = "INSERT INTO register VALUES"+"("+name+","+password+")";
//        statement.executeUpdate(sql);
        PreparedStatement prepare = connection.prepareStatement("INSERT INTO register VALUES(?,?)");
        prepare.setString(1,name);
        prepare.setString(2,password);
        prepare.executeUpdate();

        System.out.println("注册成功");
        prepare.close();
        connection.close();
    }

}
