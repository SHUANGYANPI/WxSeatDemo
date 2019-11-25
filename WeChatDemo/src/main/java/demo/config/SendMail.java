package demo.config;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import java.util.*;


@Controller
public class SendMail extends SimpleMailMessage {
    public boolean send(String password,String to){

        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

        senderImpl.setHost("smtp.qq.com");// 设定smtp邮件服务器

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("1843968167@qq.com");

        mailMessage.setSubject("你的密码为：");

        mailMessage.setText(password+"请记牢！！！");

        senderImpl.setUsername("1843968167@qq.com"); // 根据自己的情况,设置username

        senderImpl.setPassword("xcfcguuftoedcbbh"); // 根据自己的情况, 设置password

        Properties prop = new Properties();

        prop.put(" mail.smtp.auth ", " true "); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确

        prop.put(" mail.smtp.timeout ", " 25000 ");

        try {
            senderImpl.setJavaMailProperties(prop);// 发送邮件

            mailMessage.setTo(to);

            senderImpl.send(mailMessage);

            System.out.println("send OK by lkmgydx");
            return true;
        }catch (Exception e){
            return false;
        }


    }

}
