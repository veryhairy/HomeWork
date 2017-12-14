import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public  class UuerOperate {
    static SAXReader saxReader =new SAXReader();

    public static void  register() throws IOException, DocumentException {

        Document document = DocumentHelper.createDocument();
        Document doc =saxReader.read(new File("src/注册信息.xml"));
        Element element = document.addElement("data");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1登录\t\t2注册");
            int key = scanner.nextInt();
            scanner.nextLine();
            if (key == 1) {
                System.out.println("请输入用户名");
                String un = scanner.nextLine();
                System.out.println("请输入密码");
                String ps = scanner.nextLine();
                Login.login(un, ps);



            } else if(key == 2) {

                while (true) {
                    System.out.println("请输入手机号或者邮箱");
                    String loginname = scanner.nextLine();
                    if (loginname.matches
                            ("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")
                            || loginname.matches
                            ("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
                        Element LoginName = element.addElement("loginname");
                        LoginName.addAttribute("loginname", loginname);
                        break;
                    } else {
                        System.out.println("格式错误，请重试");
                        continue;
                    }
                }


                while (true) {
                    System.out.println("请输入密码");
                    String password = scanner.nextLine();
                    if (password.matches("[a-zA-z0-9]{6,14}")) {
                        Element PassWord = element.addElement("password");
                        PassWord.addAttribute("password", password);
                        break;
                    } else {
                        System.out.println("格式错误，请重试");
                        continue;
                    }
                }

                System.out.println("请输入昵称");
                String username = scanner.nextLine();
                Element UserNmae = element.addElement("username");
                UserNmae.addAttribute("username", username);
                System.out.println("注册成功");

                SAXReader saxReader = new SAXReader();
                Document document1 = saxReader.read("src/注册信息.xml");

            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("UTF-8");
            XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/注册信息.xml"), outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();}

        }

                }


            }












