package net.tkxtools;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class MailSender {

    String mail_id = "kaguyaforjapan";
    String mail_pw = "joblennon";
    String from = "kaguyaforjapan@gmail.com";

    String host = "smtp.gmail.com";
    int port = 587;

    public MailSender() {
    }

    @Asynchronous
    public void send(String c_mail, String subject, String body) {
        try {
            JmSender.send(mail_id, mail_pw, host, port, c_mail, from, subject, body);
            System.out.println("------------------success------------------");
            System.out.println(mail_id + "/" + mail_pw + "/" + host);
        } catch (Exception e) {
            System.out.println("------------------fail------------------");
            System.out.println("mail_id: " + mail_id + "/" + "mail_pw: " + mail_pw + "/"+ "host: " + host + "subject: " + subject + "body: " + body + "c_mail" + c_mail);
        }
    }
}
