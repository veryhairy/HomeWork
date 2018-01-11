package com.lanou3g.bookstore.user.service;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class Email {
    private String sendAddr = "1344692534@qq.com";//这是发送方的邮箱
    private String receiveAddr ;//接收方的邮箱

    //这个不是密码,是开启163邮箱第三方登录时候设置的授权码
    //如果不开启,那么是无法第三方登录163邮箱账号的
    private String pass = "sktjvzzpsvdngaij";

    public void t1( String email,String uuid) throws MessagingException, GeneralSecurityException {
        receiveAddr = email;
        Properties prop = new Properties();
        //设置服务器主机名
        prop.setProperty("mail.host","smtp.qq.com");
                prop.setProperty("mail.smtp.auth","true");


        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);


        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendAddr, pass);
            }
        };


        Session session = Session.getInstance(prop, auth);


        MimeMessage msg = new MimeMessage(session);


        msg.setFrom(new InternetAddress(sendAddr));

        msg.setRecipients(Message.RecipientType.TO, receiveAddr);



        msg.setSubject("来自书城的一封邮件");


        msg.setContent("点击完成激活<br/><a href=http://192.168.11.100:8080/user?method=active&code="+uuid+">激活网址</a>", "text/html;charset=utf-8");

        Transport.send(msg);

    }

}
