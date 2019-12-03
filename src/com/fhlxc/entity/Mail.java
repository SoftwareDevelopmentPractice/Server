package com.fhlxc.entity;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fhlxc.backend.Student;
import com.fhlxc.backend.Task;
import com.fhlxc.backend.TaskDaoImpl;
import com.sun.mail.util.MailSSLSocketFactory;

public class Mail {
    public static void main(String[] args) throws GeneralSecurityException {
        ArrayList<Task> maillist = new ArrayList<>();
        maillist = new TaskDaoImpl().getMail();
        for (int i = 0; i < maillist.size(); i++) {
           if(判断时间差) {
               if(maillist.get(i).getSt_config() == 1) {
            // 收件人电子邮箱
            Student student =new Student() ;
            student.setSt_id(maillist.get(i).getSt_id());
            String to = new TaskDaoImpl().getMailAddr(student) ;

            // 发件人电子邮箱
            String from = "2393835269@qq.com";

            // 指定发送邮件的主机为 smtp.qq.com
            String host = "smtp.qq.com"; // QQ 邮件服务器

            // 获取系统属性
            Properties properties = System.getProperties();

            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", host);

            properties.put("mail.smtp.auth", "true");
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            // 获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("429240967@qq.com", "授权的 QQ 邮箱密码"); // 发件人邮件用户名、密码
                }
            });

            try {
                // 创建默认的 MimeMessage 对象
                MimeMessage message = new MimeMessage(session);

                // Set From: 头部头字段
                message.setFrom(new InternetAddress(from));

                // Set To: 头部头字段
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                // 设置标题
                message.setSubject(maillist.get(i).getT_title());

                // 设置纯文本消息体
                message.setText(maillist.get(i).getT_content());

                // 发送消息
                Transport.send(message);
                System.out.println("Sent message successfully....from runoob.com");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
               if(maillist.get(i).getPa_config() == 1) {
                // 收件人电子邮箱
                   Student student =new Student() ;
                   student.setSt_id(maillist.get(i).getPa_id());
                   String to = new TaskDaoImpl().getMailAddr(student) ;  
                   // 发件人电子邮箱
                   String from = "2393835269@qq.com";

                   // 指定发送邮件的主机为 smtp.qq.com
                   String host = "smtp.qq.com"; // QQ 邮件服务器

                   // 获取系统属性
                   Properties properties = System.getProperties();

                   // 设置邮件服务器
                   properties.setProperty("mail.smtp.host", host);

                   properties.put("mail.smtp.auth", "true");
                   MailSSLSocketFactory sf = new MailSSLSocketFactory();
                   sf.setTrustAllHosts(true);
                   properties.put("mail.smtp.ssl.enable", "true");
                   properties.put("mail.smtp.ssl.socketFactory", sf);
                   // 获取默认session对象
                   Session session = Session.getDefaultInstance(properties, new Authenticator() {
                       public PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication("429240967@qq.com", "授权的 QQ 邮箱密码"); // 发件人邮件用户名、密码
                       }
                   });

                   try {
                       // 创建默认的 MimeMessage 对象
                       MimeMessage message = new MimeMessage(session);

                       // Set From: 头部头字段
                       message.setFrom(new InternetAddress(from));

                       // Set To: 头部头字段
                       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                       // 设置标题
                       message.setSubject(maillist.get(i).getT_title());

                       // 设置纯文本消息体
                       message.setText(maillist.get(i).getT_content());

                       // 发送消息
                       Transport.send(message);
                       System.out.println("Sent message successfully....from runoob.com");
                   } catch (MessagingException mex) {
                       mex.printStackTrace();
                   }
               }
               Task mail = new Task();
               mail.setSt_id(maillist.get(i).getSt_id());
               mail.setPa_id(maillist.get(i).getPa_id());
               new TaskDaoImpl().updateStatus(mail);
        }
        }
    }
}