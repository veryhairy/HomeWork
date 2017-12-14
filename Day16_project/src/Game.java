import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class Game {
        String data1 = "~！@#￥%^&*（）{}[]/.,<>?_-+=";
        String data2 = "abcdefghijklmnopqrstuvwxyz0123456789";
        String data3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        @Test
    public void difficult(){
        for (int i = 0; i < 30; i++) {
            int number = random.nextInt(87);
            sb.append((data1+data2+data3).charAt(number));
          }
            System.out.println(sb);
            long time1 = System.currentTimeMillis();
            String write = scanner.nextLine();
            if (write.equals(String.valueOf(sb))){
                long time2 = System.currentTimeMillis();
                System.out.println("使用了"+(time2-time1)+"毫秒");

            }else {System.out.println("输入错误，游戏失败");}

        }

    public void middle(){
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(62);
            sb.append((data2+data3).charAt(number));
        }
        System.out.println(sb);
        long time1 = System.currentTimeMillis();
        String write = scanner.nextLine();
        if (write.equals(String.valueOf(sb))){
            long time2 = System.currentTimeMillis();
            System.out.println("使用了"+(time2-time1)+"毫秒");

        }else {System.out.println("输入错误，游戏失败");}

    }
    public void easy(){
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(36);
            sb.append(data2.charAt(number));
        }
        System.out.println(sb);
        long time1 = System.currentTimeMillis();
        String write = scanner.nextLine();
        if (write.equals(String.valueOf(sb))){
            long time2 = System.currentTimeMillis();
            System.out.println("使用了"+(time2-time1)+"毫秒");

        }else {System.out.println("输入错误，游戏失败");}

    }
}
