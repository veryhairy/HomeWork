import org.junit.Test;

import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import java.util.Scanner;

public class Game {
        static String data1 = "~！@#￥%^&*（）{}[]/.,<>?_-+=";
        static String data2 = "abcdefghijklmnopqrstuvwxyz0123456789";
        static String data3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        static Random random = new Random();
        static StringBuffer sb = new StringBuffer();
        static Scanner scanner = new Scanner(System.in);


    public static void difficult(){
        for (int i = 0; i < 30; i++) {
            int number = random.nextInt(87);
            sb.append((data1+data2+data3).charAt(number));
          }
          //方法可以抽出
            System.out.println(sb);
        scanner.nextLine();
            String write = scanner.nextLine();
            if (write.equals(String.valueOf(sb))){
                System.out.println("恭喜，完成游戏");
            }else {System.out.println("输入错误，游戏失败");}
        }
    public static void middle(){
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(62);
            sb.append((data2+data3).charAt(number));
        }
        System.out.println(sb);
        scanner.nextLine();
        String write = scanner.nextLine();
        if (write.equals(String.valueOf(sb))){
            System.out.println("恭喜，完成游戏");
        }else {System.out.println("输入错误，游戏失败");}

    }
    public  static void easy(){
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(36);
            sb.append(data2.charAt(number));
        }
        System.out.println(sb);
        scanner.nextLine();
        String write = scanner.nextLine();
        if (write.equals(String.valueOf(sb))){
            System.out.println("恭喜，完成游戏");
        }else {System.out.println("输入错误，游戏失败");}
    }

    @Test
    public static void game(){
        int choice = scanner.nextInt();
        System.out.println("游戏将在三秒后开始");
        for (int i = 3; i >0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }System.out.println("游戏开始");
        long time1 = System.currentTimeMillis();
        if (choice == 1){
            Game.difficult();
        }else if (choice == 2){
            Game.middle();
        }else if (choice == 3){
            Game.easy();
        }
        long time2 = System.currentTimeMillis();
        long time3 = time2-time1;
        System.out.println("使用了"+time3+"毫秒");
    }
}
