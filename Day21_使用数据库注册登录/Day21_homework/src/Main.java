import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择\t1\t登录\t2\t注册");
        int i = scanner.nextInt();
        if (i == 1){
            Login.login();
        }else if (i == 2){
            Register.register();

        }


    }
}
