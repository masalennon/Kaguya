/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Masanari
 */
@ManagedBean(name = "ConfirmBeanParent")
@ViewScoped
public class ConfirmBeanParent implements Serializable {

    @NotNull
    private Integer id;
    @NotNull
    private String firstNameParent;
    @NotNull
    private String lastNameParent;
    @NotNull
    private String firstNameHuriganaParent;
    @NotNull
    private String lastNameHuriganaParent;
    @NotNull
    private Integer birthYearParent;
    @NotNull
    private Integer birthMonthParent;
    @NotNull
    private Integer birthDayParent;
    @NotNull
    private String phoneNumberParent;
    @NotNull
    private String mailAddressParent;

    private String firstName;

    private String birthYear;

    private String birthMonth;

    private String birthDay;

    private String addressOne;

    private String addressTwo;

    private String educationContent;

    private String message;

    private String payment;

    private String phoneNumber;

    private String messageTitle = "かぐや会員ご登録の確認メール";

    private String messageToParent = "正常に送信が行われました。お支払いを確認し次第、保育者様の連絡先をお教えいたします。もし万が一"
            + "保育者様と連絡が取れない場合は、こちらで事実確認をし次第必ず全額返金いたしますのでご安心ください。"
            + "このメールに覚えがない場合は、お手数ですがこのメールに返信する形で運営までおしらせください。";
    
//    @EJB
//    MailSender mailsender;

    @EJB
    OldCoupleInformationDb db;

    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        this.id = (Integer) flash.get("id");
        this.firstNameParent = (String) flash.get("firstNameParent");
        this.lastNameParent = (String) flash.get("lastNameParent");
        this.firstNameHuriganaParent = (String) flash.get("firstNameHuriganaParent");
        this.lastNameHuriganaParent = (String) flash.get("lastNameHuriganaParent");
        this.birthYearParent = (Integer) flash.get("birthYearParent");
        this.birthMonthParent = (Integer) flash.get("birthMonthParent");
        this.birthDayParent = (Integer) flash.get("birthDayParent");
        this.phoneNumberParent = (String) flash.get("phoneNumberParent");
        this.mailAddressParent = (String) flash.get("mailAddressParent");

        this.firstName = (String) flash.get("firstName");
        this.educationContent = (String) flash.get("educationContent");
        this.payment = (String) flash.get("payment");
        this.birthYear = (String) flash.get("birthYear");
        this.birthMonth = (String) flash.get("birthMonth");
        this.birthDay = (String) flash.get("birthDay");
        this.addressOne = (String) flash.get("addressOne");
        this.addressTwo = (String) flash.get("addressTwo");
        this.phoneNumber = (String) flash.get("phoneNumber");
        this.addressOne = (String) flash.get("addressOne");

    }

    public String goToComplete() {
        ParentEntity parentEntity = new ParentEntity(id, firstNameParent, lastNameParent,
                firstNameHuriganaParent, lastNameHuriganaParent, birthYearParent, birthMonthParent, birthDayParent,
                phoneNumberParent, mailAddressParent);

        try {
            MailSender mailsender = new MailSender();
            db.createa(parentEntity);
            mailsender.send(messageTitle, messageToParent, mailAddressParent);
            clear();
            return "complete-parent.xhtml";

        } catch (Exception e) {
            System.out.println("miss");
//            log.fine("新規登録できない/" + firstName + "|" + e.getMessage());
            return "error.xhtml";
        }
    }

    public void clear() {
        firstNameParent = lastNameParent = firstNameHuriganaParent
                = lastNameHuriganaParent = phoneNumberParent = mailAddressParent = null;
        id = birthYearParent = birthMonthParent = birthDayParent = null;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNameParent() {
        return firstNameParent;
    }

    public void setFirstNameParent(String firstNameParent) {
        this.firstNameParent = firstNameParent;
    }

    public String getLastNameParent() {
        return lastNameParent;
    }

    public void setLastNameParent(String lastNameParent) {
        this.lastNameParent = lastNameParent;
    }

    public String getFirstNameHuriganaParent() {
        return firstNameHuriganaParent;
    }

    public void setFirstNameHuriganaParent(String firstNameHuriganaParent) {
        this.firstNameHuriganaParent = firstNameHuriganaParent;
    }

    public String getLastNameHuriganaParent() {
        return lastNameHuriganaParent;
    }

    public void setLastNameHuriganaParent(String lastNameHuriganaParent) {
        this.lastNameHuriganaParent = lastNameHuriganaParent;
    }

    public Integer getBirthYearParent() {
        return birthYearParent;
    }

    public void setBirthYearParent(Integer birthYearParent) {
        this.birthYearParent = birthYearParent;
    }

    public Integer getBirthMonthParent() {
        return birthMonthParent;
    }

    public void setBirthMonthParent(Integer birthMonthParent) {
        this.birthMonthParent = birthMonthParent;
    }

    public Integer getBirthDayParent() {
        return birthDayParent;
    }

    public void setBirthDayParent(Integer birthDayParent) {
        this.birthDayParent = birthDayParent;
    }

    public String getPhoneNumberParent() {
        return phoneNumberParent;
    }

    public void setPhoneNumberParent(String phoneNumberParent) {
        this.phoneNumberParent = phoneNumberParent;
    }

    public String getMailAddressParent() {
        return mailAddressParent;
    }

    public void setMailAddressParent(String mailAddressParent) {
        this.mailAddressParent = mailAddressParent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getEducationContent() {
        return educationContent;
    }

    public void setEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public OldCoupleInformationDb getDb() {
        return db;
    }

    public void setDb(OldCoupleInformationDb db) {
        this.db = db;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageToParent() {
        return messageToParent;
    }

    public void setMessageToParent(String messageToParent) {
        this.messageToParent = messageToParent;
    }

}
