/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

import entities.Image;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.servlet.http.Part;
import net.tkxtools.MailSender;
import org.apache.commons.io.IOUtils;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Masanari
 * @param <T>
 */
@ManagedBean(name = "bb", eager = true)
@SessionScoped
public class Bb implements Serializable {

    @NotEmpty
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String firstNameHurigana;
    @NotEmpty
    private String lastNameHurigana;
    @NotEmpty
    private String addressOne;
    @NotEmpty
    private String addressTwo;
    @NotEmpty
    private String birthYear;
    @NotEmpty
    private String birthMonth;
    @NotEmpty
    private String birthDay;
    @NotEmpty
    private String firstNameWife;
    @NotEmpty
    private String lastNameWife;
    @NotEmpty
    private String firstNameHuriganaWife;
    @NotEmpty
    private String lastNameHuriganaWife;
    @NotEmpty
    private String birthYearWife;
    @NotEmpty
    private String birthMonthWife;
    @NotEmpty
    private String birthDayWife;
    @NotEmpty
    private String phoneNumber;

    private Part file;

    private String mailAddress;
    @Inject
    transient Logger log;
    @EJB
    protected MailSender sender;		// 電子メールユーティリティ
    @Inject
    protected MakeText text;
//    @EJB
//    protected DbBean dbBean;

//confirmBeanを作って、そこで再びflashによるデータの受け渡しをするとうまくいくかもしれない。
    @ManagedProperty(value = "#{dbbean}")
    private DbBean dbbean;

    public void uploadImage() {
//        DbBean dbbean = new DbBean();
        try {
            Map<String, Image> db = dbbean.getImage();
            Image img = new Image();
            img.setName(file.getSubmittedFileName());
            img.setContentType(file.getContentType());

            byte[] content = IOUtils.toByteArray(file.getInputStream());
            img.setContent(content);
            db.put(img.getName(), img);

            System.out.println(img.toString());

        } catch (IOException ex) {
            Logger.getLogger(Bb.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fail to upload");
        }

    }

    public String goToInput() {
        System.out.println("back to input.");
        return "input.xhtml";
    }

    public String goToConfirm() {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("firstName", this.firstName);
        flash.put("lastName", this.lastName);
        flash.put("firstNameHurigana", this.firstNameHurigana);
        flash.put("lastNameHurigana", this.lastNameHurigana);
        flash.put("addressOne", this.addressOne);
        flash.put("addressTwo", this.addressTwo);
        flash.put("birthYear", this.birthYear);
        flash.put("birthMonth", this.birthMonth);
        flash.put("birthDay", this.birthDay);
        flash.put("firstNameWife", this.firstNameWife);
        flash.put("lastNameWife", this.lastNameWife);
        flash.put("firstNameHuriganaWife", this.firstNameHuriganaWife);
        flash.put("lastNameHuriganaWife", this.lastNameHuriganaWife);
        flash.put("birthYearWife", this.birthYearWife);
        flash.put("birthMonthWife", this.birthMonthWife);
        flash.put("birthDayWife", this.birthDayWife);
        flash.put("phoneNumber", this.phoneNumber);
        flash.put("mailAddress", this.mailAddress);

        return "/realConfirm.xhtml?faces-redirect=true";
    }

    public String edit(OldCoupleInformation oldCoupleInformation) {
        firstName = oldCoupleInformation.getFirstName();
        return null;
    }

    public void sendMail() {
        sender.send(this.mailAddress, "お問い合わせのご確認", text.getText(this.firstName));
    }

//    public List<OldCoupleInformation> getAll() {
//        return db.getAll();
//    }
//
    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public void setId() {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameHurigana() {
        return firstNameHurigana;
    }

    public void setFirstNameHurigana(String firstNameHurigana) {
        this.firstNameHurigana = firstNameHurigana;
    }

    public String getLastNameHurigana() {
        return lastNameHurigana;
    }

    public void setLastNameHurigana(String lastNameHurigana) {
        this.lastNameHurigana = lastNameHurigana;
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

    public String getFirstNameWife() {
        return firstNameWife;
    }

    public void setFirstNameWife(String firstNameWife) {
        this.firstNameWife = firstNameWife;
    }

    public String getLastNameWife() {
        return lastNameWife;
    }

    public void setLastNameWife(String lastNameWife) {
        this.lastNameWife = lastNameWife;
    }

    public String getFirstNameHuriganaWife() {
        return firstNameHuriganaWife;
    }

    public void setFirstNameHuriganaWife(String firstNameHuriganaWife) {
        this.firstNameHuriganaWife = firstNameHuriganaWife;
    }

    public String getLastNameHuriganaWife() {
        return lastNameHuriganaWife;
    }

    public void setLastNameHuriganaWife(String lastNameHuriganaWife) {
        this.lastNameHuriganaWife = lastNameHuriganaWife;
    }

    public String getBirthYearWife() {
        return birthYearWife;
    }

    public void setBirthYearWife(String birthYearWife) {
        this.birthYearWife = birthYearWife;
    }

    public String getBirthMonthWife() {
        return birthMonthWife;
    }

    public void setBirthMonthWife(String birthMonthWife) {
        this.birthMonthWife = birthMonthWife;
    }

    public String getBirthDayWife() {
        return birthDayWife;
    }

    public void setBirthDayWife(String birthDayWife) {
        this.birthDayWife = birthDayWife;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public MailSender getSender() {
        return sender;
    }

    public void setSender(MailSender sender) {
        this.sender = sender;
    }

    public MakeText getText() {
        return text;
    }

    public void setText(MakeText text) {
        this.text = text;
    }

    public Bb() {
    }

    public void setDbbean(DbBean dbbean) {
        this.dbbean = dbbean;
    }

    public DbBean getDbbean() {
        return dbbean;
    }

}
