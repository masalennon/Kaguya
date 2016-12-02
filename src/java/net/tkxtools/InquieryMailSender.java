/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tkxtools;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Masanari
 */
public class InquieryMailSender implements Email {

    public void send(String[] args) {

        String to = "KaguyaForJapan@gmail.com";
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "localhost");
        Session session = Session.getDefaultInstance(properties);

        MimeMessage mimeMessage = new MimeMessage(session);

        // InternetAddressの作成
        InternetAddress[] toAddress = new InternetAddress[args.length];
        try {
            for (int i = 0; i < args.length; i++) {
                toAddress[i] = new InternetAddress(args[i]);
            }
        } catch (AddressException e) {
            e.printStackTrace();
            return;
        }

        try {
            // 宛先の設定
            //mimeMessage.setRecipients(MimeMessage.RecipientType.TO, toAddress);
            // 送信元の設定
            mimeMessage.setFrom(new InternetAddress(""));//sessionで送り主のメール取得？メールにする必要ないか

            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // サブジェクトの設定
            mimeMessage.setSubject("The time is ...");
            // 本文の設定
            mimeMessage.setText(new Date().toString());
            // 設定の保存
            mimeMessage.saveChanges();
            // メールの送信
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return;
        }
    }

}
