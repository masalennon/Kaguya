/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

/**
 *
 * @author Masanari
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//
//@ViewScoped
//@ManagedBean

public class MailSender implements Serializable {
//    
//    MailToParent mailSend = new MailToParent();
//    mailSend.send("JavaMail テストメール", "テストメールの本文");

    private String from;

    // Google account mail address
    private String username;
    // Google App password
    private String password;
    private Properties configuration = new Properties();

    public void stream() {

    }

    public void send(String subject, String content, String to) {
//        from = (configuration.getProperty("from"));
        final Properties properties = new Properties();
        try (final InputStream stream
                = this.getClass().getResourceAsStream("property-mail.properties")) {
            properties.load(stream);

//            ClassLoader classLoader = MailSender.class.getClassLoader();
//            InputStream inputStream = classLoader.getResourceAsStream("property.properties");
//        configuration.load(inputStream);
            from = (properties.getProperty("from"));
            username = (properties.getProperty("username"));
            password = (properties.getProperty("password"));
            System.out.println(from + "this is from in stream method.");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        stream();

//    final String to = "competence.80@gmail.com";
        //final String charset = "ISO-2022-JP";
        final String charset = "UTF-8";

        final String encoding = "base64";

        // for gmail
        String host = "smtp.gmail.com";
        String port = "587";
        String starttls = "true";

        // for local
        //String host = "localhost";
        //String port = "2525";
        //String starttls = "false";
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", starttls);

        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");

        props.put("mail.debug", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            MimeMessage message = new MimeMessage(session);

            // Set From:
            message.setFrom(new InternetAddress(from, "かぐや"));
            // Set ReplyTo:
            message.setReplyTo(new Address[]{new InternetAddress(from)});
            // Set To:
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject, charset);
            message.setText(content, charset);

            message.setHeader("Content-Transfer-Encoding", encoding);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

}
