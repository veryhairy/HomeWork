import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Login {

    public static void login(String un, String ps) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/注册信息.xml"));
        Element root = document.getRootElement();
        Element login = root.element("loginname");
        Attribute name = login.attribute ("loginname");
        Element pass = root.element("password");
        Attribute psw = pass.attribute("password");
        if (un.equals(name.getValue())){
            if (ps.equals(psw.getValue())){
                System.out.println("登录成功");

                System.out.println("请选择：1查询天气\t\t2查询归属地\t\t3手速游戏");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
               // scanner.nextInt();

                if (choice == 1){
                    Weather weather = new Weather();
                    System.out.println("请输入要查询的城市");
                    String ct = scanner.nextLine();
                    weather.find(ct);
                }else if (choice == 2){
                    Phone phone = new Phone();
                    System.out.println("请输入要查询的手机号");
                    String ph = scanner.nextLine();
                    phone.place(ph);
                }else if (choice == 3){
                    System.out.println("请选择游戏难度\t\t1:困难\t2:中等\t3：简单");
                        Game.game();
                } }
        }else {
            System.out.println("账户名或密码错误，请重试");
        }
    }
}
