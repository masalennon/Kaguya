package Db;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Masanari
 */
@ManagedBean(name = "inqueryBean")
@ViewScoped
public class InqueryBean {

    private String content;
    private String mailAddress;
    private String title;

    public String send() {
        MailSender mailsender = new MailSender();
        mailsender.send(title, content, mailAddress);
        System.out.println("send() in inquery");
        return "/complete-inquery.xhtml?faces-redirect=true";

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
